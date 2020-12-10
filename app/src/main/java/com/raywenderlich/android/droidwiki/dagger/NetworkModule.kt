package com.raywenderlich.android.droidwiki.dagger

import com.raywenderlich.android.droidwiki.network.WikiApi
import com.raywenderlich.android.droidwiki.utils.Const
import dagger.Module
import dagger.Provides
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import okhttp3.OkHttpClient
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetworkModule {

    companion object {
        private const val NAME_BASE_URL = "NAME_BASE_URL"
    }

    @Provides
    //Provided by javax. Injects String object of a specific string
    //Can also be used with your own types if you need multiple variation injected
    @Named(NAME_BASE_URL)
    fun providesBaseUrlString() = "${(Const.PROTOCOL)}://${(Const.LANGUAGE)}.${(Const.BASE_URL)}"

    @Provides
    @Singleton
    fun providesHttpClient() = OkHttpClient()

    @Provides
    @Singleton
    fun providesRequestBuilder(@Named(NAME_BASE_URL) baseUrl: String) =
            baseUrl.toHttpUrlOrNull()?.newBuilder()

    @Provides
    @Singleton
    fun providesWikiApi(client: OkHttpClient, requestBuilder: HttpUrl.Builder?) =
            WikiApi(client, requestBuilder)
}