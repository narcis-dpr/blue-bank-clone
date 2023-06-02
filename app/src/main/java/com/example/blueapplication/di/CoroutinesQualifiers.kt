package com.example.blueapplication.di

import javax.inject.Qualifier


@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class IoDispatcher


@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class MainDispatcher

