buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        val agpVersion = "8.5.0"
        classpath("com.android.tools.build:gradle:$agpVersion")
    }
}
tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}