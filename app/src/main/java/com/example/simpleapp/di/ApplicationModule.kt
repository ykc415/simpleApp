package com.example.simpleapp.di

import android.content.Context
import android.util.Log
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.simpleapp.data.local.CommentDao
import com.example.simpleapp.data.local.PostDao
import com.example.simpleapp.data.local.SimpleDatabase
import com.example.simpleapp.data.local.SimpleLocalDataSource
import com.example.simpleapp.data.remote.SimpleApi
import com.example.simpleapp.data.remote.SimpleRemoteDataSource
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier
import javax.inject.Singleton
import kotlin.annotation.AnnotationRetention.RUNTIME

@Module
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
    fun provideRemoteDataSource(api: SimpleApi, ioDispatcher: CoroutineDispatcher): SimpleRemoteDataSource {
        return SimpleRemoteDataSource(api, ioDispatcher)
    }



    @JvmStatic
    @Singleton
    @Provides
    fun provideLocalDataSource(
        postDao: PostDao,
        commentDao: CommentDao,
        ioDispatcher: CoroutineDispatcher
    ): SimpleLocalDataSource {
        return SimpleLocalDataSource(postDao, commentDao, ioDispatcher)
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideDataBase(context: Context): SimpleDatabase {
        return Room.databaseBuilder(context.applicationContext, SimpleDatabase::class.java, "simple.db")
            .addCallback(object: RoomDatabase.Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    Log.d("Room", "db Created")
                }
            })
            .build()
    }

    @JvmStatic
    @Singleton
    @Provides
    fun providePostDao(database: SimpleDatabase): PostDao {
        return database.postDao()
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideCommentDao(database: SimpleDatabase): CommentDao {
        return database.commentDao()
    }


    @JvmStatic
    @Singleton
    @Provides
    fun provideIoDispatcher() = Dispatchers.IO

}


