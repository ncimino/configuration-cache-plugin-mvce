package com.company.greeting;

import org.gradle.api.file.RegularFileProperty;
import org.gradle.api.tasks.*;
import org.gradle.api.*;

public abstract class HelloTask extends DefaultTask {
    @TaskAction
    void greet() {
        GreetingPluginExtension extension = getProject().getExtensions().getByType(GreetingPluginExtension.class);
        System.out.println(extension.getMessage().get() + " from " + extension.getGreeter().get());
    }
}

