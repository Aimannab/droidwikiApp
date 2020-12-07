package com.raywenderlich.android.droidwiki.dagger

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

//Tells Dagger that that AppModule class will provide dependencies for a part of the application
@Module
class AppModule(private val app: Application) {
    //Tells Dagger that the method provides a certain type of dependency. Looks at the return type.
    //In this case, a Context object.
    @Provides
    //Part of javax package. Tells dagger that there should be only a single instance of this dependency.
    @Singleton
    fun provideContext(): Context = app
}