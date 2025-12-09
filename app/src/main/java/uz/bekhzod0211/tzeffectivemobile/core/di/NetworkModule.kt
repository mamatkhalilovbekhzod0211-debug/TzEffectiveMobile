package uz.bekhzod0211.tzeffectivemobile.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provide(
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://drive.usercontent.google.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}