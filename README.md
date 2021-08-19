# Configuration Cache is Empty with a Plugin MVCE

While creating and running Gradle plugin projects using 7.+ we are seeing .configuration-cache directories created with a single empty file.

This project was created as an attempt to reproduce that behavior, but it currently does not reproduce.

Something must be different between our projects where we observe this and this project. We are working to isolate the issue and this has been published in case we need to collaborate on it more to reproduce.
