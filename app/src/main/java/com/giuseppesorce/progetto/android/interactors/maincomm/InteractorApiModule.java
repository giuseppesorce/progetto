package com.giuseppesorce.progetto.android.interactors.maincomm;




import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * @author Giuseppe Sorce
 */
@Module
public class InteractorApiModule {

  //TODO improve this singleton, try to delete.. @giuseppesorce
  @Provides
  @Singleton
  RetrofitFriendsApi provideRetrofitFriendsApi(Retrofit retrofit) {
    return retrofit.create(RetrofitFriendsApi.class);
  }

  //TODO improve this singleton, try to delete.. @giuseppesorce
  @Provides
  @Singleton
  InteractorApi provideUserApi(RetrofitFriendsApi retrofitFriendsApi) {
    return new InteractorApiImpl(retrofitFriendsApi);
  }
}
