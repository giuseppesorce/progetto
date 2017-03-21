package com.giuseppesorce.progetto.android.storage;


import android.text.TextUtils;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Giuseppe Sorce
 */
@Module
public class EnvironmentModule {



  private String baseUrl;
  private String pushtoken;


  public EnvironmentModule(String baseUrl) {
    this.baseUrl = baseUrl;

  }

  @Provides
  @Singleton
  public Environment provideEnvironment() {
    if (baseUrl == null || TextUtils.isEmpty(baseUrl)) {
      baseUrl = "";
    }
    return new Environment(baseUrl) ;
  }
}
