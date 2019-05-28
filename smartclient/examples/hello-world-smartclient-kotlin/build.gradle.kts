import org.jetbrains.kotlin.gradle.frontend.webpack.WebPackExtension
import org.jetbrains.kotlin.gradle.tasks.Kotlin2JsCompile

plugins {
    id("kotlin2js") version "1.3.21"
    id("org.jetbrains.kotlin.frontend") version "0.0.45"
}

repositories {
    jcenter()
    mavenCentral()
    maven {
        url = uri("https://dl.bintray.com/dvekeman/kotlin-typings")
    }
}

dependencies {
    implementation(kotlin("stdlib-js"))
    implementation(group = "dvekeman", name = "kotlin-smartclient", version = "0.0.1-pre.2-kotlin-1.3.31")
}

kotlinFrontend {
    npm {
        dependency("style-loader")
        devDependency("karma")
    }

    bundle<WebPackExtension>("webpack") {
        this as WebPackExtension
        bundleName = "hello"
        sourceMapEnabled = true
        contentPath = file("./")
        mode = "development"

    }
}

tasks {

    "compileKotlin2Js"(Kotlin2JsCompile::class) {
        kotlinOptions {
            languageVersion = "1.3"
            moduleKind = "umd"
            sourceMap = true
            metaInfo = true
            main = "call"
        }
    }

    register("checkSmartClientRuntime") {
        doLast {
            if (!file("isomorphic/system/modules").exists() || !file("isomorphic/skins").exists()) {
                val msg = "Ensure that you have copied the SmartClient Runtime into the `isomorphic` directory.\n" +
                        "To download a trial: Go to https://www.smartclient.com/product/download.jsp\n" +
                        "Then copy the content of the `isomorphic` directory (modules, skins, ...) to this project.\n" +
                        "Example: `cp -R smartclientRuntime/isomorphic/* ./isomorphic/`"
                throw RuntimeException (msg)
            } else {
                project.logger.info("Isomorphic content found!")
            }
        }
    }

}
tasks["compileKotlin2Js"].dependsOn("checkSmartClientRuntime")

