package com.a9992099300.asteroidlocator.core_impl.di

import android.content.Context
import androidx.room.Room
import com.a9992099300.asteroidlocator.core_impl.db.AsteroidsDao
import com.a9992099300.asteroidlocator.core_impl.db.DatabaseService
import dagger.Module
import dagger.Provides
import dagger.Reusable

private const val ASTEROID_DATABASE_NAME = "ASTEROID_DB"

@Module
internal class DatabaseModule {

        @Provides
        @Reusable
        fun provideDatabaseService(context: Context): DatabaseService {
            return Room.databaseBuilder(context,
                DatabaseService::class.java,
                ASTEROID_DATABASE_NAME
            ).build()
        }

        @Provides
        @Reusable
        fun provideAsteroidsDao(databaseService: DatabaseService): AsteroidsDao {
            return databaseService.getAsteroidsDao()
        }

}
