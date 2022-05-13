package com.example.quwi.core.di

import kotlinx.coroutines.Dispatchers
import org.koin.core.qualifier.named
import org.koin.dsl.module

object DispatchersName {
    const val IO = "DispatcherIO"
    const val Main = "DispatcherMain"
    const val Immediate = "DispatcherImmediate"
}

val coroutineModule = module {

    single(named(DispatchersName.IO)) { Dispatchers.IO }

    single(named(DispatchersName.Main)) { Dispatchers.Main }

    single(named(DispatchersName.Immediate)) { Dispatchers.Main.immediate }

}