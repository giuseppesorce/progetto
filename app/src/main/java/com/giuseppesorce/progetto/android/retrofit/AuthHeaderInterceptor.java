package com.giuseppesorce.progetto.android.retrofit;



import com.giuseppesorce.progetto.android.storage.Environment;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author GiuseppeSorce
 */
@Singleton
public final class AuthHeaderInterceptor implements Interceptor {


  private Environment environment;

  @Inject
  public AuthHeaderInterceptor(Environment environment) {
    this.environment = environment;
  }

  @Override
  public Response intercept(Chain chain) throws IOException {
    Request request = chain.request();
    Request.Builder builder = request.newBuilder();
//    builder.addHeader("X-CLIENT",environment.getClient());
//    builder.addHeader("X-SID", environment.getSessionId());
//    builder.addHeader("X-TOKEN",environment.getToken());
     return chain.proceed(builder.build());
  }
}
