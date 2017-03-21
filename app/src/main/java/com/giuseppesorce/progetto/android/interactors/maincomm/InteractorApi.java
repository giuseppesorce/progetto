package com.giuseppesorce.progetto.android.interactors.maincomm;


import com.giuseppesorce.progetto.model.Friend;

import rx.Single;

/**
 * @author Giuseppe Sorce
 */

public interface InteractorApi {

    Single<Friend> getData(String data);

}
