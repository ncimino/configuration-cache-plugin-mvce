
package com.company.greeting;

import org.gradle.api.provider.Property;

interface GreetingPluginExtension {
    Property<String> getMessage();
    Property<String> getGreeter();
}
