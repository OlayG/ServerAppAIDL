package com.example.admin.serverappaidl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.admin.serverappaidl.inject.DaggerMainActivityComponent;
import com.example.admin.serverappaidl.service.MyBoundService;
import com.example.admin.serverappaidl.view.MainActivityContract;
import com.example.admin.serverappaidl.view.MainActivityPresenter;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainActivityContract.view {

    @Inject
    MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerMainActivityComponent.create().inject(this);
        presenter.fetchEventbriteEvents();

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void showError(String error) {

    }
}
