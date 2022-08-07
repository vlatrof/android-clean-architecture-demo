package com.example.cleanarchitecture.presentation

import android.app.Application

class App : Application() {

    companion object {

        const val APP_SHARED_PREFERENCES_NAME = "APP_SHARED_PREFERENCES_NAME"
        const val APP_SHARED_PREFERENCES_NOTE_TAG = "APP_SHARED_PREFERENCES_NOTE_TAG"
        const val APP_SHARED_PREFERENCES_NOTE_DEFAULT_VALUE = "APP_SHARED_PREFERENCES_NOTE_DEFAULT_VALUE"

    }

}