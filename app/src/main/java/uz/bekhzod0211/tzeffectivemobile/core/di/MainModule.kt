package uz.bekhzod0211.tzeffectivemobile.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import uz.bekhzod0211.tzeffectivemobile.presentation.main.data.resource.network.CoursesApi
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
@InstallIn(SingletonComponent::class)
class MainModule {
    @Singleton
    @Provides
    fun provideOrderApi(retrofit: Retrofit): CoursesApi {
        return retrofit.create(CoursesApi::class.java)
    }

}