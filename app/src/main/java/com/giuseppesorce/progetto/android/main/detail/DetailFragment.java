package com.giuseppesorce.progetto.android.main.detail;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.giuseppesorce.progetto.R;
import com.giuseppesorce.progetto.android.ProgettoApplication;

import butterknife.ButterKnife;

/**
 * @author Giuseppe Sorce #@copyright xxxx 2017.
 *         <p>......</p>
 */

public class DetailFragment extends Fragment implements  DetailPresenter.DetailView{

    private DetailPresenter presenter;

    public static DetailFragment createInstance() {
        DetailFragment frag = new DetailFragment();
        Bundle init = new Bundle();
        frag.setArguments(init);
        return frag;
    }


    public DetailFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_layout, container, false);
        ButterKnife.bind(this, view);
        presenter= ProgettoApplication.appComponent.detailPresenter();
        presenter.setView(this);
        presenter.setup();
        return view;
    }

    @Override
    public void setup() {

    }
}
