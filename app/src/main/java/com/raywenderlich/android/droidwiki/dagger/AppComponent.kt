package com.raywenderlich.android.droidwiki.dagger

import com.raywenderlich.android.droidwiki.ui.homepage.HomepageActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
//Takes a list of modules as an input.
//It is used to connect objects to their dependencies.
@Component(modules = [AppModule::class])
interface AppComponent {

}