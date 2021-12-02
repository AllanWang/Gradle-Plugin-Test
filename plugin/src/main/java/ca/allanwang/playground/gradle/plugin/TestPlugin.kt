package ca.allanwang.playground.gradle.plugin

import com.android.build.gradle.BaseExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

class TestPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        println("Test plugin apply for ${project.name}")

        val androidPluginHandler = { _: Plugin<*> ->
            project.afterEvaluate {
                project.setupTestTasks()
            }
        }

        project.plugins.withId("com.android.application", androidPluginHandler)
        project.plugins.withId("com.android.library", androidPluginHandler)
    }

    private fun Project.setupTestTasks() {
        println("Test plugin setup for $name")

        val android = extensions.findByName("android") // as? BaseExtension

        if (android == null) {
            println("Not an android project")
            return
        }

        TestDelegate(
            project = this,
            name = "abc",
            packageName = "ca.allanwang.playground.gradle.testoutput"
        )
    }

}