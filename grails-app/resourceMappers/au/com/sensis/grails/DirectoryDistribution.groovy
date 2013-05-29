package au.com.sensis.grails

import org.apache.commons.io.FileUtils

class DirectoryDistribution {

    static final String PREFIX = "dir-dist-"

    static final String SUFFIX = ".tmp"

    File destination

    DirectoryDistribution(File targetDirectory) {
        this.destination = targetDirectory
    }

    def distribute(File sourceFile) {
        File destFile = new File(destination, sourceFile.getName())
        if(!destFile.exists()) {
            if(!destination.exists()) {
                destination.mkdirs()
            }
            File tempFile = File.createTempFile(PREFIX, SUFFIX, destination)
            FileUtils.copyFile(sourceFile, tempFile)
            tempFile.renameTo(destFile)
        }
    }
}
