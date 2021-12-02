package ca.allanwang.playground.gradle.plugin

import org.gradle.api.Project
import java.io.File

internal class TestDelegate(
    val project: Project,
    var name: String,
    var packageName: String? = null,
) {

    init {
        val entries = entries()
        println("TestInput files $entries")

        entries.forEach { entry ->
            println("${entry.name}: ${entry.file.readText()}")
        }
    }

    private fun entries(): Collection<EntryInfo> {
        // Future usage will change from assets
        val baseDir = project.file("src/main/assets")
        return project.fileTree(baseDir).files.map { file ->
            EntryInfo(
                name = file.nameWithoutExtension,
                relativePath = file.toRelativeString(baseDir),
                file = file
            )
        }
    }

}

data class EntryInfo(val name: String, val relativePath: String, val file: File)