package com.giuseppesorce.progetto.android.interactors.maincomm;


import com.giuseppesorce.progetto.model.Friend;

import rx.Single;

/**
 * @author Giuseppe Sorce
 */
public class InteractorApiImpl implements InteractorApi {

    private RetrofitFriendsApi retrofitFriendsApi;

    public InteractorApiImpl(RetrofitFriendsApi retrofitFriendsApi) {
        this.retrofitFriendsApi = retrofitFriendsApi;
    }

    @Override
    public Single<Friend> getData(String data) {
        return retrofitFriendsApi.getData(data);
    }

}
