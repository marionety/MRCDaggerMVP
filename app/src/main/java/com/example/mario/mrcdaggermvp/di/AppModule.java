package com.example.mario.mrcdaggermvp.di;

import android.app.Application;

import com.example.mario.mrcdaggermvp.ui.App;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mario on 17/02/2015.
 */
@Module (
        injects = App.class,
        includes = {
                DomainModule.class,
                InteractorModule.class
        }
)
public class AppModule {

    private App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Provides
    public Application provideApplication() {
        return this.app;
    }
}
