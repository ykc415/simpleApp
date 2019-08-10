package com.example.simpleapp.di

import android.content.Context
import androidx.room.Room
import com.example.simpleapp.data.DataSource
import com.example.simpleapp.data.Repository
import com.example.simpleapp.data.local.SimpleDatabase
import com.example.simpleapp.data.local.SimpleLocalDataSource
import com.example.simpleapp.data.remote.SimpleRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier
import javax.inject.Singleton
import kotlin.annotation.AnnotationRetention.RUNTIME

@Module(includes = [ApplicationModuleBinds::class])
object ApplicationModule {

    @Qualifier
    @Retention(RUNTIME)
    annotation class RemoteDataSource

    @Qualifier
    @Retention(RUNTIME)
    annotation class LocalDataSource


    @JvmStatic
    @Singleton
    @Provides
    fun provideRemoteDataSource(): DataSource {
        return SimpleRemoteDataSource
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideLocalDataSource(
        database: SimpleDatabase,
        ioDispatcher: CoroutineDispatcher
    ): DataSource {
        return SimpleLocalDataSource(database.postDao(), ioDispatcher)
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideDataBase(context: Context): SimpleDatabase {
        return Room.databaseBuilder(context.applicationContext, SimpleDatabase::class.java, "simple.db")
            .build()
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideIoDispatcher() = Dispatchers.IO



}


@Module
abstract class ApplicationModuleBinds {

    @Singleton
    @Binds
    abstract fun bindRepository(repo: Repository): Repository
}