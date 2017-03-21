package com.giuseppesorce.progetto.android.main.detail;


import com.giuseppesorce.progetto.android.debug.Dbg;
import com.giuseppesorce.progetto.android.interactors.maincomm.InteractorApi;
import com.giuseppesorce.progetto.android.main.MainPresenter;
import com.giuseppesorce.progetto.model.Friend;
import com.giuseppesorce.progetto.presenter.BaseView;

import java.io.IOException;

import okhttp3.ResponseBody;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * @author Giuseppe Sorce
 */

public class DetailPresenterImpl implements DetailPresenter {
    private final InteractorApi interactorApi;
    private DetailView view;

    public DetailPresenterImpl(InteractorApi interactorApi) {
        this.interactorApi= interactorApi;
    }

    @Override
    public void setView(BaseView view) {
        if (!(view instanceof DetailView)) {
            throw new IllegalArgumentException("View must extend DetailPresenter.View");
        }
        this.view = (DetailView) view;
    }

    @Override
    public void setup() {
        view.setup();

    }


}