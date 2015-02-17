package com.example.mario.mrcdaggermvp.ui.presenter;

import com.example.mario.mrcdaggermvp.interactor.FindItemsInteractor;
import com.example.mario.mrcdaggermvp.ui.listener.OnFinishedListener;
import com.example.mario.mrcdaggermvp.ui.view.MainView;

import java.util.List;

/**
 * Created by mario on 17/02/2015.
 */
public class MainPresenterImpl implements MainPresenter, OnFinishedListener {

    private MainView _mainView;
    private FindItemsInteractor _findItemsInteractor;

    public MainPresenterImpl(MainView mainView, FindItemsInteractor findItemsInteractor) {
        this._mainView = mainView;
        this._findItemsInteractor = findItemsInteractor;
    }

    @Override
    public void onResume() {
        _mainView.showProgress();
        _findItemsInteractor.findItems(this);
    }

    @Override
    public void onItemClicked(int position) {
        _mainView.showMessage(String.format("Position %d clicked", position + 1));
    }

    @Override
    public void onFinished(List<String> items) {
        _mainView.setItems(items);
        _mainView.hideProgress();
    }
}
