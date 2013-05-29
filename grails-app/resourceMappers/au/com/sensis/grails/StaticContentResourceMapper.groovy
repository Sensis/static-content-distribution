package au.com.sensis.grails;

import org.apache.commons.logging.LogFactory
import org.grails.plugin.resource.mapper.MapperPhase

class StaticContentResourceMapper {

    def log = LogFactory.getLog(StaticContentResourceMapper)

    def phase = MapperPhase.DISTRIBUTION

    def distribution

    def map(resource, config) {
        log.info("mapping resource: ${resource?.processedFile?.name}, to ${config?.target}")

        boolean enabled = config?.enabled ?: true
        if(enabled && config?.target) {
            distribution = getDistribution(config)
            distribution.distribute(resource.processedFile)
        }
    }

    def DirectoryDistribution getDistribution(config) {
        if(distribution == null) {
            distribution = new DirectoryDistribution(new File(config?.target))
        }
        return distribution
    }

}