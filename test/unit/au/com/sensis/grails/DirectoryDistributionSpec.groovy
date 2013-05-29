package au.com.sensis.grails

import org.apache.commons.io.FileUtils
import spock.lang.Specification

class DirectoryDistributionSpec extends Specification {

    File source
    File destinationDirectory

    def setup() {
        source = File.createTempFile("dir-dist", ".txt")
        source.deleteOnExit()
        destinationDirectory = new File(FileUtils.getTempDirectory(), "dist-test")
        destinationDirectory.mkdir()
        destinationDirectory.deleteOnExit()
    }

    def "should distribute to the target directory"() {
        setup:
            DirectoryDistribution distribution = new DirectoryDistribution(destinationDirectory)

        when:
            distribution.distribute(source)

        then:
            File dest = new File(destinationDirectory, source.getName())
            assert dest.exists()
    }

    def "should create the target directory if it does not exist"() {
        setup:
            destinationDirectory = new File(FileUtils.getTempDirectory(), "non-existant-dist-test")
            destinationDirectory.deleteOnExit()
            DirectoryDistribution distribution = new DirectoryDistribution(destinationDirectory)

        when:
            distribution.distribute(source)

        then:
            File dest = new File(destinationDirectory, source.getName())
            assert dest.exists()
    }

    def "should not overwrite file if it exists"() {
        setup:
            File existing = new File(destinationDirectory, source.getName())
            existing.createNewFile()
            long modifiedTime = new Date(0).getTime()
            existing.setLastModified(modifiedTime)  // use the last modified time to ensure the existing file is not modified.
            existing.deleteOnExit()
            DirectoryDistribution distribution = new DirectoryDistribution(destinationDirectory)

        when:
            distribution.distribute(source)

        then:
            File dest = new File(destinationDirectory, source.getName())
            assert dest.exists()
            assert dest.lastModified() == modifiedTime
    }
}
