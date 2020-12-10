package com.raywenderlich.android.droidwiki.dagger

import com.raywenderlich.android.droidwiki.ui.homepage.HomepageActivity
import com.raywenderlich.android.droidwiki.ui.search.SearchActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
//Takes a list of modules as an input.
//It is used to connect objects to their dependencies.
@Component(modules = [
    AppModule::class,
    PresenterModule::class,
    NetworkModule::class,
    WikiModule::class])

interface AppComponent {

    //Tells Dagger that HomepageActivity will require injection from AppComponent
    fun inject(target: HomepageActivity)

    fun inject(target: SearchActivity)
}