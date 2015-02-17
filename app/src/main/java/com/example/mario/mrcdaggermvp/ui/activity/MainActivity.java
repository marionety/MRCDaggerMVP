package com.example.mario.mrcdaggermvp.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.mario.mrcdaggermvp.R;
import com.example.mario.mrcdaggermvp.di.MainModule;
import com.example.mario.mrcdaggermvp.ui.common.BaseActivity;
import com.example.mario.mrcdaggermvp.ui.presenter.MainPresenter;
import com.example.mario.mrcdaggermvp.ui.view.MainView;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by mario on 17/02/2015.
 */
public class MainActivity extends BaseActivity implements MainView, AdapterView.OnItemClickListener {

    @Inject
    MainPresenter _presenter;

    @InjectView(R.id.list)
    ListView _listView;
    @InjectView(R.id.progress)
    ProgressBar _progresBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        _listView.setOnItemClickListener(this);
    }

    @Override
    protected List<Object> getModules() {
        return Arrays.<Object>asList(new MainModule(this));
    }

    @Override
    protected void onResume() {
        super.onResume();
        _presenter.onResume();
    }

    @Override
    public void showProgress() {
        _progresBar.setVisibility(View.VISIBLE);
        _listView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        _progresBar.setVisibility(View.INVISIBLE);
        _listView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setItems(List<String> items) {
        _listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items));
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        _presenter.onItemClicked(position);
    }
}
