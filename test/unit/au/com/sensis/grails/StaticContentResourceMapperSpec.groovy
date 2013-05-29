package au.com.sensis.grails

import org.apache.commons.io.FileUtils
import org.grails.plugin.resource.ResourceMeta
import org.grails.plugin.resource.mapper.MapperPhase
import spock.lang.Specification

class StaticContentResourceMapperSpec extends Specification {

    def "should be defined against the distribution phase"() {
        setup:
            StaticContentResourceMapper mapper = new StaticContentResourceMapper()

        expect:
            assert mapper.phase == MapperPhase.DISTRIBUTION
    }

    def "should create a DirectoryDistribution based on the target directory specified in config"() {
        setup:
            def config = [target: FileUtils.getTempDirectoryPath()]
            File tempFile = File.createTempFile("pre", ".tmp")
            tempFile.deleteOnExit()
            ResourceMeta resource = new ResourceMeta()
            resource.processedFile = tempFile
            DirectoryDistribution mockDistribution = Mock()
            StaticContentResourceMapper mapper = new StaticContentResourceMapper()
            mapper.distribution = mockDistribution

        when:
            mapper.map(resource, config)

        then:
            1 * mockDistribution.distribute(tempFile)
    }

    def "should not distribute if target directory is not specified"() {
        setup:
            def config = [enabled:true]
            ResourceMeta resource = new ResourceMeta()
            DirectoryDistribution mockDistribution = Mock()
            StaticContentResourceMapper mapper = new StaticContentResourceMapper()
            mapper.distribution = mockDistribution

        when:
            mapper.map(resource, config)

        then:
            0 * mockDistribution.distribute(_)
    }

    def "should not distribute when disabled"() {
        setup:
            def config = [enabled: false]
            ResourceMeta resource = new ResourceMeta()
            DirectoryDistribution mockDistribution = Mock()
            StaticContentResourceMapper mapper = new StaticContentResourceMapper()
            mapper.distribution = mockDistribution

        when:
            mapper.map(resource, config)

        then:
            0 * mockDistribution.distribute(_)
    }
}
