package com.example.uxindividualassignment2

import android.app.Application

class App : Application() {
    val game = Game()

    override fun onCreate() {
        super.onCreate()
    }
}