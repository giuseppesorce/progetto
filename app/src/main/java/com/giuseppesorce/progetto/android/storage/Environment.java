package com.giuseppesorce.progetto.android.storage;





import com.giuseppesorce.progetto.BuildConfig;

import javax.inject.Inject;
import javax.inject.Singleton;


/**
 * @author Giuseppe Sorce @copyright AmasingApps.com  2016.
 */

@Singleton
public class Environment {


  private String baseUrl;


  @Inject
  public Environment(String baseUrl) {
    this.baseUrl = baseUrl;


  }


  public String getBaseUrl() {
    return baseUrl.isEmpty() ? BuildConfig.BASE_URL : baseUrl;

  }

  public void setBaseUrl(String baseUrl) {
    this.baseUrl = baseUrl;
  }



}
