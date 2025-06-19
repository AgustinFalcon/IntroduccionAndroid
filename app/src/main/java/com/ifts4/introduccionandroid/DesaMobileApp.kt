package com.ifts4.introduccionandroid

import android.app.Application

class DesaMobileApp: Application() {

    companion object {
        lateinit var instance: DesaMobileApp
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}