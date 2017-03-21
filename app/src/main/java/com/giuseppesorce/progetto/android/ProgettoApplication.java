package com.giuseppesorce.progetto.android;

import android.app.Application;

import com.giuseppesorce.progetto.AppComponent;
import com.giuseppesorce.progetto.DaggerAppComponent;
import com.giuseppesorce.progetto.android.retrofit.RetrofitModule;
import com.giuseppesorce.progetto.android.storage.EnvironmentModule;

import java.io.File;

/**
 * @author Giuseppe Sorce #@copyright xxxx 2017.
 *         <p>......</p>
 */

public class ProgettoApplication extends Application{

    public static AppComponent appComponent;
    private ProgettoApplication instannce;


    @Override
    public void onCreate() {
        super.onCreate();

        instannce = this;
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).
                retrofitModule(new RetrofitModule(new File(getCacheDir() + "/cache"),
                        10 * 1024 * 1024)).environmentModule(new EnvironmentModule( ""))
                .build();
    }
}
