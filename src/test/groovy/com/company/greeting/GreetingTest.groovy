package com.company.greeting

import org.gradle.testkit.runner.GradleRunner
import org.gradle.testkit.runner.BuildResult
import org.gradle.testkit.runner.TaskOutcome
import org.junit.rules.TemporaryFolder
import spock.lang.Shared
import spock.lang.Specification


class GreetingTest extends Specification {
    @Shared
    File outputDir
    TemporaryFolder testProjectDir

    def setupSpec() {
        String shortName = GreetingTest.toString().replaceFirst("class com.company.greeting.", "")
        outputDir = new File("build/test-output/" + shortName).getCanonicalFile()
        if (outputDir.exists()) {
            outputDir.deleteDir()
        }
        outputDir.mkdirs()
    }

    def setup() {
        testProjectDir = new TemporaryFolder(outputDir)
        testProjectDir.create()
    }

    void cleanup() {
        testProjectDir.delete()
    }

    def GreetingPluginTest() {
        when:
        List<String> args = new ArrayList<>()
        args.add("-PbuildDir=${testProjectDir.newFolder("build-output")}")
        args.add("--project-cache-dir=${testProjectDir.newFolder("project-cache")}")
        args.add("hello")
        List<String> stringArgs = new ArrayList<>()
        for (Object arg : args) {
            stringArgs.add((String) arg) // Some are GStrings
        }

        BuildResult result = GradleRunner.create()
                .withProjectDir(new File("src/test/resources/test-build"))
                .withArguments(stringArgs)
                .withTestKitDir(testProjectDir.newFolder("test-kit"))
                .withDebug(true)
                .withPluginClasspath()
                .forwardOutput()
                .build()

        then:
        result.task("hello").outcome == TaskOutcome.SUCCESS
    }
}
