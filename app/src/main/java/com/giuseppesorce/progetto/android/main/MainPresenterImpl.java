package com.giuseppesorce.progetto.android.main;


import com.giuseppesorce.progetto.android.debug.Dbg;
import com.giuseppesorce.progetto.android.interactors.maincomm.InteractorApi;
import com.giuseppesorce.progetto.model.Friend;
import com.giuseppesorce.progetto.presenter.BaseView;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.ResponseBody;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * @author Giuseppe Sorce
 */

public class MainPresenterImpl implements MainPresenter {
    private final InteractorApi interactorApi;
    private MainView view;

    public MainPresenterImpl(InteractorApi interactorApi) {
        this.interactorApi = interactorApi;
    }

    @Override
    public void setView(BaseView view) {
        if (!(view instanceof MainPresenter.MainView)) {
            throw new IllegalArgumentException("View must extend MainPresenter.View");
        }
        this.view = (MainPresenter.MainView) view;
    }

    @Override
    public void setup() {
        view.setupToolBar();
        loadData();
    }

    private void loadData() {

        interactorApi.getData("friend").
                subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<Friend>() {
            @Override
            public void call(Friend friend) {


                view.showDetail(friend);

            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {


                if (throwable instanceof IOException) {

                }
                Dbg.p("Error: " + throwable.getLocalizedMessage());

            }
        });
    }
}