package com.giuseppesorce.progetto.android.main;


import com.giuseppesorce.progetto.android.interactors.maincomm.InteractorApi;

import dagger.Module;
import dagger.Provides;

/**
 * @author Giuseppe Sorce
 */
@Module
public class MainModule {

  @Provides
  MainPresenter provideMainPresenter(InteractorApi interactorApi) {
    return new MainPresenterImpl(interactorApi);
  }
}
