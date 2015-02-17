package com.example.mario.mrcdaggermvp.ui.view;

import java.util.List;

/**
 * Created by mario on 17/02/2015.
 */
public interface MainView {

    public void showProgress();

    public void hideProgress();

    public void setItems(List<String> items);

    public void showMessage(String message);
}
