package com.puzzlebench.clean_marvel_kotlin

import android.app.Application
import android.util.Log
import io.realm.Realm
import io.realm.RealmConfiguration

class MarvelApplication: Application() {

    val REALM_DATABASE_NAME = "db_character"

    override fun onCreate() {
        super.onCreate()

        val realmConfiguration = RealmConfiguration.Builder(applicationContext)
                .name(REALM_DATABASE_NAME)
                .build()
        Realm.setDefaultConfiguration(realmConfiguration)

        Log.d("Realm", "Realm path " + realmConfiguration.path)
    }
}
