import com.moowork.gradle.node.task.NodeTask
import org.jetbrains.kotlin.gradle.tasks.Kotlin2JsCompile


plugins {
    id("kotlin2js") version "1.3.21"
    id("com.moowork.node") version "1.2.0"
}

repositories {
    mavenCentral()
}

tasks.withType<Kotlin2JsCompile> {
    kotlinOptions {
        moduleKind = "umd"
    }
}

dependencies {
    compile(kotlin("stdlib-js"))
}

task<Copy>("assembleJsLib") {
    configurations.compile.get().resolve().forEach { file: File ->
        from(zipTree(file.absolutePath), {
            includeEmptyDirs = false
            include { fileTreeElement ->
                val path = fileTreeElement.path
                (path.endsWith(".js") || path.endsWith(".js.map")) && (path.startsWith("META-INF/resources/") ||
                        !path.startsWith("META-INF/"))
            }
        })
    }
    from(tasks.withType<ProcessResources>().map { it.destinationDir })
    into("$buildDir/js")

    dependsOn("classes")
}

task<NodeTask>("webpack") {
    dependsOn("npm_install")
    setScript(File("$projectDir/node_modules/webpack/bin/webpack"))
}

tasks {
    named("webpack") { dependsOn("assembleJsLib") }
    assemble { dependsOn("webpack") }
}

node {
    download = true
}
