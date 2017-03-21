package com.giuseppesorce.progetto.android.interactors.maincomm;


import com.giuseppesorce.progetto.model.Friend;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Single;

/**
 * @author Giuseppe Sorce
 */

public interface RetrofitFriendsApi {


    @GET("/snippet/sm.php")
    Single<Friend> getData(@Query("p") String p);

}


