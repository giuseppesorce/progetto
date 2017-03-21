package com.giuseppesorce.progetto.android.main;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

import com.giuseppesorce.progetto.R;
import com.giuseppesorce.progetto.android.ProgettoApplication;
import com.giuseppesorce.progetto.android.main.detail.DetailFragment;
import com.giuseppesorce.progetto.model.Friend;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainPresenter.MainView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tvTitleToolbar)
    TextView tvTitleToolbar;
    private MainPresenter presenter;
    private DetailFragment fragmentDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
           ButterKnife.bind(this);
        presenter = ProgettoApplication.appComponent.mainPresenter();
        presenter.setView(this);
        presenter.setup();
    }

    @Override
    public void setupToolBar() {
        setTitle("");
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_ha_menu);
        }
        tvTitleToolbar.setText("Main");
        toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
    }

    @Override
    public void showDetail(Friend friend) {
        Toast.makeText(this, "Friend: "+friend.name, Toast.LENGTH_SHORT).show();
        if(fragmentDetail ==null) {
            fragmentDetail = DetailFragment.createInstance();
        }
        showFragment(fragmentDetail, "fragmentDetail", R.id.fmContainer, 0);
    }


    protected void showFragment(Fragment frag, String tag, int container,  int action) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
               if (action == 0) {
            ft.replace(container, frag, tag);
        } else if (action ==1){
            ft.add(container, frag, tag);
        }else if(action == 2){
            ft.remove(frag);
        }
        ft.addToBackStack(null);
        try {
            ft.commitAllowingStateLoss();
        } catch (Exception ex) {
           // Crashlytics.logException(new Exception("NOCRASH: showFragment.showFragment: " + ex.getLocalizedMessage()));
        }
    }
}
