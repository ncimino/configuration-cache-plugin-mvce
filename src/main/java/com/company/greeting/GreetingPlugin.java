
package com.company.greeting;

import org.gradle.api.*;
import org.gradle.api.provider.Property;

class GreetingPlugin implements Plugin<Project> {
    public void apply(Project project) {
        GreetingPluginExtension extension = project.getExtensions().create("greeting", GreetingPluginExtension.class);
        HelloTask hello = project.getTasks().create("hello", HelloTask.class);
/*
        hello.doLast({
            println("${extension.message.get()} from ${extension.greeter.get()}");
        });
*/
    }
}
