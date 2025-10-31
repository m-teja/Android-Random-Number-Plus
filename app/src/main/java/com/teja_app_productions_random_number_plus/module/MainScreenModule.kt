package com.teja_app_productions_random_number_plus.module

import com.teja_app_productions_random_number_plus.main.MainScreenModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object MainScreenModule {

    @Provides
    fun provideMainScreenModelFactory(): MainScreenModelFactory {
        return MainScreenModelFactory()
    }
}