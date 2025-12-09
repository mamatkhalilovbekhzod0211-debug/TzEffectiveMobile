package uz.bekhzod0211.tzeffectivemobile.core.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.bekhzod0211.tzeffectivemobile.presentation.main.domain.MainRepository
import uz.bekhzod0211.tzeffectivemobile.presentation.main.domain.impl.MainRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindMainRepository(
        impl: MainRepositoryImpl
    ): MainRepository
}