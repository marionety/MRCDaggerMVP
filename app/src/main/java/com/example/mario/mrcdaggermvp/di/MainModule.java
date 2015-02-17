package com.example.mario.mrcdaggermvp.di;

import com.example.mario.mrcdaggermvp.interactor.FindItemsInteractor;
import com.example.mario.mrcdaggermvp.ui.activity.MainActivity;
import com.example.mario.mrcdaggermvp.ui.presenter.MainPresenter;
import com.example.mario.mrcdaggermvp.ui.presenter.MainPresenterImpl;
import com.example.mario.mrcdaggermvp.ui.view.MainView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mario on 17/02/2015.
 */
@Module (
        injects = MainActivity.class,
        addsTo = AppModule.class
)
public class MainModule {

    private MainView _view;

    public MainModule(MainView view) {
        this._view = view;
    }

    @Provides
    @Singleton
    public MainView provideView() {
        return this._view;
    }

    @Provides
    @Singleton
    public MainPresenter providePresenter(MainView mainView, FindItemsInteractor findItemsInteractor) {
        return new MainPresenterImpl(mainView, findItemsInteractor);
    }
}
