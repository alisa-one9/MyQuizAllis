package com.example.myquizallis.di
import com.example.myquizallis.domain.Repository
import org.koin.core.module.Module
import org.koin.dsl.module
val repoModules: Module = module {
    single { Repository(get()) }
}