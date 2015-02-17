package com.example.mario.mrcdaggermvp.di;

import com.example.mario.mrcdaggermvp.interactor.FindItemsInteractor;
import com.example.mario.mrcdaggermvp.interactor.FindItemsInteractorImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mario on 17/02/2015.
 */
@Module (
        library = true
)
public class InteractorModule {

    @Provides
    public FindItemsInteractor provideFindItemsInteractor() {
        return new FindItemsInteractorImpl();
    }

}
