package com.example.admin.serverappaidl.view;

import android.util.Log;

import com.example.admin.serverappaidl.model.EventBriteCategory;
import com.example.admin.serverappaidl.retrofit.RetrofitHelper;
import com.example.admin.serverappaidl.service.MyBoundService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Admin on 9/9/2017.
 */

public class MainActivityPresenter implements MainActivityContract.presenter {

    private static final String TAG = "MainActivityPresenter";
    MainActivityContract.view view;

    public void attachView(MainActivityContract.view view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void fetchEventbriteEvents() {

        retrofit2.Call<EventBriteCategory> callCategory = RetrofitHelper.callEventBriteCategory();
        callCategory.enqueue(new Callback<EventBriteCategory>() {
            @Override
            public void onResponse(Call<EventBriteCategory> call, Response<EventBriteCategory> response) {
                Log.d(TAG, "onResponse: " + response.body().getEvents().toString());
                //MyBoundService boundService = new MyBoundService(response.body().getEvents());
            }

            @Override
            public void onFailure(Call<EventBriteCategory> call, Throwable t) {

            }
        });

    }
}
