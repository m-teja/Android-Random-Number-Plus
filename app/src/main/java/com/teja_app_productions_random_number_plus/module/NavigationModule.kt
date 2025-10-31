package com.teja_app_productions_random_number_plus.module

import android.content.Context
import com.teja_app_productions_random_number_plus.navigation.NavigationController
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext

@Module
@InstallIn(ActivityComponent::class)
object NavigationModule {

    @Provides
    fun provideNavigationController(@ActivityContext context: Context): NavigationController {
        return NavigationController(context)
    }
}