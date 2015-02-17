package com.example.mario.mrcdaggermvp.ui;

import android.app.Application;

import com.example.mario.mrcdaggermvp.domain.AnalyticsManager;
import com.example.mario.mrcdaggermvp.di.AppModule;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import dagger.ObjectGraph;

/**
 * Created by mario on 17/02/2015.
 */
public class App extends Application {

    private ObjectGraph _objectGraph;
    @Inject
    AnalyticsManager _analyticsManager;

    @Override public void onCreate() {
        super.onCreate();
        _objectGraph = ObjectGraph.create(getModules().toArray());
        _objectGraph.inject(this);
        _analyticsManager.registerAppEnter();
    }

    private List<Object> getModules() {
        return Arrays.<Object>asList(new AppModule(this));
    }

    public ObjectGraph createScopeGraph(Object... modules) {
        return _objectGraph.plus(modules);
    }
}
