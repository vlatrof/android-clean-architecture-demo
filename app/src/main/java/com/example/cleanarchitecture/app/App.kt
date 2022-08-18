package com.example.cleanarchitecture.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

// with @HiltAndroidApp annotation Hilt will generate base class for App that extends Application
// class tree will be look like this:
// App -extends-> [Generated class by Hilt] -extends-> Application
@HiltAndroidApp
class App : Application() {}