package com.example.mario.mrcdaggermvp.ui.common;

import android.app.Activity;
import android.os.Bundle;

import com.example.mario.mrcdaggermvp.ui.App;

import java.util.List;

import dagger.ObjectGraph;

/**
 * Created by mario on 17/02/2015.
 */
public abstract class BaseActivity extends Activity {
    private ObjectGraph _activityGraph;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _activityGraph = ((App) getApplication()).createScopeGraph(getModules().toArray());
        _activityGraph.inject(this);
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        _activityGraph = null;
    }

    protected abstract List<Object> getModules();
}
