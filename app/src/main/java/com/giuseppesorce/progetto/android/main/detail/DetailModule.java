package com.giuseppesorce.progetto.android.main.detail;


import com.giuseppesorce.progetto.android.interactors.maincomm.InteractorApi;
import com.giuseppesorce.progetto.android.main.MainPresenter;
import com.giuseppesorce.progetto.android.main.MainPresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * @author Giuseppe Sorce
 */
@Module
public class DetailModule {

  @Provides
  DetailPresenter provideDetailPresenter(InteractorApi interactorApi) {
    return new DetailPresenterImpl(interactorApi);
  }
}
