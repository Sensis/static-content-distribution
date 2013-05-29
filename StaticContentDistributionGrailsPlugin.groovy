class StaticContentDistributionGrailsPlugin {
    def version = "0.1"
    def grailsVersion = "2.0 > *"
    def loadAfter = ['resources']

    def title = "Static Content Distribution Plugin"
    def description = 'This plugin hooks into the Distribution phase of the Resources Plugin and distributes the static resource to a specified location.'

    def documentation = "http://grails.org/plugin/static-content-distribution"

    def license = "APACHE"
    def organization = [ name: "Sensis", url: "http://developers.sensis.com.au" ]
    def developers = [ [ name: "CP Lim", email: "c.p.lim@sensis.com.au" ]]
    def issueManagement = [ system: "GitHub", url: "https://github.com/Sensis/static-content-distribution/issues" ]
    def scm = [ url: "https://github.com/Sensis/static-content-distribution" ]
}
