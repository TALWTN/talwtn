This project provides a demo of audio and video calls for the Android platform.

With this project, you can experience the audio and video effects of WTN and learn about the best practices for using WTN by reading the source code.

## Prerequisites

- Android Studio 3.0+.
- A real device running Android 5.0+.

## Running the Demo

### Step 1: Sync the Project

1. Open the project in Android Studio. Sync the project to download the required third-party libraries, such as `jwt`.

2. Configure the project.

The configuration file is located at `app/src/main/java/com/eaydu/talwtn/demo/utils//CommonConfig.java`.

> Open this file and select the `AppID` and `AppKey` for your project. The default values have time and other limitations, but they are suitable for simple testing.

### Step 2: Build and Run

1. Connect your Android device to your computer. Once connected, the device name will appear at the top of the screen, as shown below.

![AS](./docs/as_app_img.png)

2. Run the project. The project will install the WTN app on your connected Android device and launch it.

> Note that your Android device may intercept the installation process. If you see any related pop-ups, select "Continue installation".

## Using the App

![App](./docs/app_screenshot.jpg)

### Testing the Publishing Function

To test the publishing function, follow these steps:

1. Open the app on your Android device and go to the home page.

2. Enter a stream name for publishing. The default is `123456`.

3. Click "Publish" to start the test.

### Testing the Subscription Function

To test the subscription function, follow these steps:

1. Open the app on your Android device and go to the home page.

2. Enter a stream name for subscription. The default is `123456`.

3. Click "Subscribe" to start the test.