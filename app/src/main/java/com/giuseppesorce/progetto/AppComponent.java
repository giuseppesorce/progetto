package com.giuseppesorce.progetto;

import android.content.Context;


import com.giuseppesorce.progetto.android.AppModule;
import com.giuseppesorce.progetto.android.interactors.maincomm.InteractorApiModule;
import com.giuseppesorce.progetto.android.main.MainModule;
import com.giuseppesorce.progetto.android.main.MainPresenter;
import com.giuseppesorce.progetto.android.main.detail.DetailModule;
import com.giuseppesorce.progetto.android.main.detail.DetailPresenter;
import com.giuseppesorce.progetto.android.retrofit.RetrofitModule;
import com.giuseppesorce.progetto.android.storage.Environment;
import com.giuseppesorce.progetto.android.storage.EnvironmentModule;

import javax.inject.Singleton;

import dagger.Component;
import io.realm.Realm;
import retrofit2.Retrofit;


/**
 * @author Giuseppe Sorce
 */
@Singleton
@Component(modules = {AppModule.class, MainModule.class,
        EnvironmentModule.class, RetrofitModule.class, InteractorApiModule.class, DetailModule.class

})
public interface AppComponent {

    Context context();

    MainPresenter mainPresenter();

    DetailPresenter detailPresenter();

    Environment enviroment();

    Retrofit retrofit();

    Realm realm();

}
