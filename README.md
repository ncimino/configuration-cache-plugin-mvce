# Configuration Cache is Empty with a Plugin MVCE

While creating and running Gradle plugin projects using 7.+ we are seeing `.gradle/configuration-cache/gc.properties`
created which is an empty file.

This project is an attempt to reproduce that behavior, but it currently does not reproduce.

Something must be different between our projects where we observe this and this project. We are working to isolate the 
issue and this has been published in case we need to collaborate on it more to reproduce.

# To Reproduce

The following should reproduce, but it doesn't:

    ./gradlew test

When the problem manifests itself a `.gradle/configuration-cache/gc.properties` file is created in the PWD; However, 
after running the test flow for this project the PWD where the test-kit launched the run does not contain this folder:

    $ ls ./src/test/resources/test-build/ -la
    total 12
    drwxr-xr-x 2 user group 4096 Aug 19 17:16 .
    drwxr-xr-x 3 user group 4096 Aug 19 15:46 ..
    -rw-r--r-- 1 user group  100 Aug 19 17:16 build.gradle
    -rw-r--r-- 1 user group   31 Aug 19 15:46 settings.gradle

... that directory does not exist.