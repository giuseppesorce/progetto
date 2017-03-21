package com.giuseppesorce.progetto.android.main.detail;


import com.giuseppesorce.progetto.presenter.BaseView;
import com.giuseppesorce.progetto.presenter.Presenter;

/**
 * @author Giuseppe Sorce
 */

public interface DetailPresenter extends Presenter {

    void setup();

    interface DetailView extends BaseView {


        void setup();
    }
}