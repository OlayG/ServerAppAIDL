package com.example.admin.serverappaidl.inject;

import com.example.admin.serverappaidl.view.MainActivityPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Admin on 9/9/2017.
 */
@Module
class MainActivityModule {

    @Provides
    MainActivityPresenter providesMainActivityPresenter(){
        return new MainActivityPresenter();
    }
}
