class StaticContentDistributionGrailsPlugin {
    // the plugin version
    def version = "0.1"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "2.2 > *"
    // the other plugins this plugin depends on
    def dependsOn = [resources:'1.1.6 > *']
    def loadAfter = ['resources']
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
        "grails-app/views/error.gsp"
    ]

    // TODO Fill in these fields
    def title = "Static Content Distribution Plugin" // Headline display name of the plugin
    def author = "CP Lim"
    def authorEmail = "c.p.lim@sensis.com.au"
    def description = '''\
This plugin hooks into the Distribution phase of the Resources Plugin and distributes the static resource to a specified
location.
'''

    // URL to the plugin's documentation
    def documentation = "http://grails.org/plugin/static-content-distribution"

    // Extra (optional) plugin metadata

    // License: one of 'APACHE', 'GPL2', 'GPL3'
    def license = "APACHE"

    // Details of company behind the plugin (if there is one)
    def organization = [ name: "Sensis", url: "http://developers.sensis.com.au" ]

    // Any additional developers beyond the author specified above.
    def developers = [ [ name: "CP Lim", email: "c.p.lim@sensis.com.au" ]]

    // Location of the plugin's issue tracker.
    def issueManagement = [ system: "GitHub", url: "https://github.com/Sensis/static-content-distribution/issues" ]

    // Online location of the plugin's browseable source code.
    def scm = [ url: "https://github.com/Sensis/static-content-distribution" ]
}
