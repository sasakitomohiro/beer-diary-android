package monster.sasakisan.beer_diary_android.di

import android.content.Context
import dagger.Module
import dagger.Provides
import monster.sasakisan.beer_diary_android.App
import javax.inject.Singleton

@Module
internal object AppModule {
  @Singleton
  @Provides
  @JvmStatic
  fun provideContext(application: App): Context = application
}
