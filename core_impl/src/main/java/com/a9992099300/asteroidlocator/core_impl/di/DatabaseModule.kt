package com.a9992099300.asteroidlocator.core_impl.di

import android.content.Context
import androidx.room.Room
import com.a9992099300.asteroidlocator.core_impl.db.AsteroidLocalSource
import com.a9992099300.asteroidlocator.core_impl.db.AsteroidLocalSourceImpl
import com.a9992099300.asteroidlocator.core_impl.db.AsteroidsDao
import com.a9992099300.asteroidlocator.core_impl.db.DatabaseService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable
import javax.inject.Qualifier
import javax.inject.Singleton

private const val ASTEROID_DATABASE_NAME = "ASTEROID_DB"

@Module
abstract class DatabaseModule {

//    @Qualifier
//    @MustBeDocumented
//    @Retention(AnnotationRetention.RUNTIME)
//    internal annotation class DatabaseName

    companion object {

        //      @Provides
//        @DatabaseScope
//        @DatabaseName
//        fun provideDatabaseName() = "asteroid.db"

        @Provides
        @DatabaseScope
        fun provideDatabaseService(context: Context): DatabaseService {
            return Room.databaseBuilder(context,
                DatabaseService::class.java,
                ASTEROID_DATABASE_NAME
            ).build()
        }

        @Provides
        @DatabaseScope
        fun provideAsteroidsDao(databaseService: DatabaseService): AsteroidsDao {
            return databaseService.getAsteroidsDao()
        }
    }


}
