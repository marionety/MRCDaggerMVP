package com.example.mario.mrcdaggermvp.interactor;

import android.os.Handler;

import com.example.mario.mrcdaggermvp.ui.listener.OnFinishedListener;

import java.util.Arrays;
import java.util.List;

/**
 * Created by mario on 17/02/2015.
 */
public class FindItemsInteractorImpl implements FindItemsInteractor {

    @Override public void findItems(final OnFinishedListener listener) {
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                listener.onFinished(createArrayList());
            }
        }, 2000);
    }

    private List<String> createArrayList() {
        return Arrays.asList(
                "Item 1",
                "Item 2",
                "Item 3",
                "Item 4",
                "Item 5",
                "Item 6",
                "Item 7",
                "Item 8",
                "Item 9",
                "Item 10"
        );
    }
}
