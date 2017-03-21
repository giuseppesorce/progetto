package com.giuseppesorce.progetto.android.main;


import com.giuseppesorce.progetto.model.Friend;
import com.giuseppesorce.progetto.presenter.BaseView;
import com.giuseppesorce.progetto.presenter.Presenter;

/**
 * @author Giuseppe Sorce
 */

public interface MainPresenter extends Presenter {

    void setup();

    interface MainView extends BaseView {

        void setupToolBar();

        void showDetail(Friend friend);
    }
}