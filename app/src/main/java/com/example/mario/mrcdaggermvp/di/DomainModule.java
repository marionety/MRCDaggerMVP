package com.example.mario.mrcdaggermvp.di;

import android.app.Application;

import com.example.mario.mrcdaggermvp.domain.AnalyticsManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mario on 17/02/2015.
 */
@Module(
        complete = false,
        library = true
)
public class DomainModule {

    @Provides
    @Singleton
    public AnalyticsManager provideAnalyticsManager(Application app) {
        return new AnalyticsManager(app);
    }
}
