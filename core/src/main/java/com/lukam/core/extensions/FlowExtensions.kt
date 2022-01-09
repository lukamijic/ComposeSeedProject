package com.lukam.core.extensions

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

fun <T> mutableShareFlow() = MutableSharedFlow<T>()

fun <T> mutableStateFlow(initial: T) = MutableStateFlow(initial)

fun <T> Flow<T>.shareReplayLatest(sharingStarted: SharingStarted = SharingStarted.WhileSubscribed(1000L)) =
    shareIn(CoroutineScope(Dispatchers.Default), sharingStarted, replay = 1)
