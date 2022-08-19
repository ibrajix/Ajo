package com.ibrajix.ajo.di

import com.ibrajix.ajo.ui.validation.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthModule {

    @Provides
    @Singleton
    fun providesValidateCountry() = ValidateCountry()


    @Provides
    @Singleton
    fun providesValidateFirstName() = ValidateFirstName()

    @Provides
    @Singleton
    fun providesValidateLastName() = ValidateLastName()

    @Provides
    @Singleton
    fun providesValidatePassword() = ValidatePassword()

    @Provides
    @Singleton
    fun providesValidateNumber() = ValidateNumber()

}