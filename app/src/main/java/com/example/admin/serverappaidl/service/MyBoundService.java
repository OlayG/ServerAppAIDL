package com.example.admin.serverappaidl.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.admin.serverappaidl.Event;
import com.example.admin.serverappaidl.IEventbrite;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Admin on 9/9/2017.
 */

public class MyBoundService extends Service {

    private static final String TAG = "MyBoundService";
    private List<Event> events = new ArrayList<>();

    public MyBoundService(List<Event> events) {
        Log.i(TAG, "MyBoundService: constructor");
        this.events = events;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind: ");
        return new IEventbrite.Stub() {
            @Override
            public int getPid() throws RemoteException {
                return Process.myPid();
            }

            @Override
            public List<Event> getEvents() throws RemoteException {
                return events;
            }
        };
    }
}
