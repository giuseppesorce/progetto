package com.giuseppesorce.progetto.android;

import android.content.Context;

import com.giuseppesorce.progetto.android.persistence.MyRealmMigration;
import com.google.gson.Gson;

import java.io.FileNotFoundException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.exceptions.RealmMigrationNeededException;

/**
 * @author Giuseppe Sorce
 */

@Module
public class AppModule {

    private final Context context;
    private final MyRealmMigration myMigration;

    public AppModule(Context context) {
        this.context = context;
        this.myMigration = new MyRealmMigration();
    }

    @Provides
    @Singleton
    Context provideContext() {
        return context;
    }


    @Provides
    @Singleton
    Gson proviceGson() {
        return new Gson();
    }


    @Provides
    @Singleton
    ProgettoApplication provideSMApplication() {
        return (ProgettoApplication) context;
    }


    @Provides
    @Singleton
    Realm provideRealm() {
        Realm.init(context);

        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder().schemaVersion(1).name("db1")
                .migration(myMigration)
                .build();
        try {
            Realm.setDefaultConfiguration(realmConfiguration);
        } catch (RealmMigrationNeededException e) {
            try {
                Realm.migrateRealm(realmConfiguration, new MyRealmMigration());
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
        }

        return Realm.getDefaultInstance();
    }


}


















