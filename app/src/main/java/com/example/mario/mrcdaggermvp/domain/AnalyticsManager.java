package com.example.mario.mrcdaggermvp.domain;

import android.app.Application;
import android.widget.Toast;

/**
 * Created by mario on 17/02/2015.
 */
public class AnalyticsManager {

    private Application app;

    public AnalyticsManager(Application app) {
        this.app = app;
    }

    public void registerAppEnter() {
        Toast.makeText(app, "App enter", Toast.LENGTH_SHORT).show();
    }
}
