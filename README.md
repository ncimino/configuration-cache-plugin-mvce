# Configuration Cache is Empty with a Plugin MVCE

While creating and running Gradle plugin projects using 7.+ we are seeing .configuration-cache directories created with a single empty file.

This project is an attempt to reproduce that behavior, but it currently does not reproduce.

Something must be different between our projects where we observe this and this project. We are working to isolate the issue and this has been published in case we need to collaborate on it more to reproduce.

# To Reproduce

It is expected that the following would reproduce:

    ./gradlew test

After running the above if the problem presented a `configuration-cache` directory would exist; However, when the following is run:

    $ ls ./src/test/resources/test-build/ -la
    total 12
    drwxr-xr-x 2 nikc hd 4096 Aug 19 17:16 .
    drwxr-xr-x 3 nikc hd 4096 Aug 19 15:46 ..
    -rw-r--r-- 1 nikc hd  100 Aug 19 17:16 build.gradle
    -rw-r--r-- 1 nikc hd   31 Aug 19 15:46 settings.gradle

... that directory does not exist.