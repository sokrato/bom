group = "io.github.sokrato"
version = "0.1.0-SNAPSHOT"

plugins {
    `java-platform`
    `maven-publish`
}

repositories {
    jcenter()
    mavenCentral()
    maven("https://clojars.org/repo/")
}

dependencies {
    constraints {
        // google utils
        api("com.google.guava:guava:29.0-jre")
        api("com.google.inject:guice:4.2.3")
        api("com.google.code.findbugs:jsr305:3.0.2")
        api("javax.inject:javax.inject:1")

        // logging
        api("org.slf4j:slf4j-api:1.7.30")
        api("ch.qos.logback:logback-classic:1.2.3")

        // JVM Language
        // clojure
        api("nrepl:nrepl:0.7.0")
        api("org.clojure:clojure:1.10.1")
        // see https://github.com/jruby/jruby/wiki/RedBridge
        // for embedding ruby in JVM
        api("org.jruby:jruby:9.2.13.0")
        // groovy
        api("org.codehaus.groovy:groovy-all:2.5.8")
        api("org.spockframework:spock-core:1.3-groovy-2.5")
        api("org.spockframework:spock-spring:1.3-groovy-2.5")

        // networking
        api("io.lettuce:lettuce-core:5.2.0.RELEASE")
        api("io.netty:netty-all:4.1.51.Final")
        api("io.projectreactor:reactor-core:3.3.9.RELEASE")
        api("io.projectreactor:reactor-test:3.3.9.RELEASE")
        api("io.vertx:vertx-core:3.9.2")
        api("com.squareup.okhttp3:okhttp:4.8.1")
        // SSH
        api("com.jcraft:jsch:0.1.55")

        // json
        api("com.fasterxml.jackson.core:jackson-databind:2.11.0")
        api("com.google.code.gson:gson:2.8.6")

        // database
        api("com.zaxxer:HikariCP:3.4.5")
        api("org.postgresql:postgresql:42.2.16")
        api("org.xerial:sqlite-jdbc:3.32.3.2")
        api("mysql:mysql-connector-java:8.0.20")
        api("org.mybatis:mybatis:3.5.5")
        api("org.hibernate.javax.persistence:hibernate-jpa-2.1-api:1.0.2.Final")
        api("org.hibernate:hibernate-core:5.4.21.Final")
        api("com.github.gwenn:sqlite-dialect:0.1.0")

        // testing
        api("org.junit.jupiter:junit-jupiter:5.6.2")
        api("org.testng:testng:7.3.0")
        api("org.mockito:mockito-core:3.5.10")

        // CLI
        api("commons-cli:commons-cli:1.4")
        api("jline:jline:3.0.0.M1")
        api("org.jline:jline:3.16.0")

        // others
        api("org.javassist:javassist:3.27.0-GA")
        api("org.ow2.asm:asm:8.0")
        api("org.projectlombok:lombok:1.18.12")

        // crypto
        api("org.encryptor4j:encryptor4j:0.1.2")
    }
}

// https://docs.gradle.org/current/userguide/publishing_maven.html#publishing_maven:publications
// https://docs.gradle.org/current/userguide/publishing_setup.html#sec:basic_publishing
// https://docs.gradle.org/current/userguide/java_platform_plugin.html
// run: gradle publishToMavenLocal
publishing {
    publications {
        create<MavenPublication>("bom") {
            from(components["javaPlatform"])
        }
    }

    repositories {
        maven {
            name = "local"
            url = uri("file:///~/.m2/repository")
        }
    }
}
