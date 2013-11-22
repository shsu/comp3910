# COMP3910 A3 Android

##System Requirements:

* JDK 1.6 or higher
* Maven 3.1.1 or higher
* Android SDK r21.1 or higher
* Set environment variable `ANDROID_HOME` to the path of your installed Android SDK. See example below:

        export ANDROID_HOME=$HOME/tools/android-sdk
        export PATH=$ANDROID_HOME/tools:$ANDROID_HOME/platform-tools:$PATH

##Building the Project:
1. In root directory of android project:

        mvn clean install

This will build a APK and place it in the `target` folder.
