Static Content Distribution
===========================

This plugin hooks into the Grails Resources pipeline at the [Distribution phase](http://grails-plugins.github.io/grails-resources/guide/6.%20Creating%20custom%20mappers.html#6.2%20Mapper%20phases%20and%20priority) so that the bundled and/or minified content is ready to be distributed.  At the time of writing, it only supports copying the content to a directory (so that Apache can serve it out), but more distribution mechanisms will come in the future. There are some [known issues](#known-issues) at the moment.

Setup
=====

Install
-------
This plugin is hosted on Grails Plugins Central so add it to your BuildConfig.groovy file as follows:

```groovy
plugins {
    compile ':static-content-distribution:0.1'
}
```

Configuration
-------------
The plugin is enabled by default, but for it to work, you must configure a directory for the plugin to distribute the content to.  If this configuration is not present, the plugin will do nothing.

```
grails.resources.mappers.staticcontent.target = '/directory/to/distribute/content'
```

As mentioned the plugin is enabled by default, to disable it setup the following:

```
grails.resources.mappers.staticcontent.enabled = false
```

Known Issues
============
There is a current issue with this plugin working with the zipped-resources plugin.  Due to the fact that the zipped resources compressing the content, this plugin will only get the gzipped file, rather than the original.  The web server will then be unable to serve out the original file (without the .gz file extension), and it will fail.  The current work around is to disable the zipped-resources plugin if you want to use this plugin.
