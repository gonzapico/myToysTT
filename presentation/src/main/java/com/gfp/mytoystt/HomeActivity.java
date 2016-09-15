package com.gfp.mytoystt;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import butterknife.BindView;
import com.gfp.mytoystt.di.HasComponent;
import com.gfp.mytoystt.di.components.DaggerNavigationComponent;
import com.gfp.mytoystt.di.components.NavigationComponent;
import com.gfp.mytoystt.loadNavigation.NavigationEntriesModel;
import com.gfp.mytoystt.loadNavigation.NavigationPresenter;
import javax.inject.Inject;

public class HomeActivity extends BaseMTActivity
    implements com.gfp.mytoystt.loadNavigation.NavigationView, HasComponent<NavigationComponent> {

  @Inject NavigationPresenter mNavigationPresenter;
  private NavigationComponent mNavigationComponent;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.initializeInjector();
    this.getComponent().inject(this);
    mNavigationPresenter.setmNavigationView(this);
    mNavigationPresenter.getNavigationItems();
  }

  @Override protected int getLayoutResource() {
    return R.layout.activity_home;
  }

  @Override public NavigationComponent getComponent() {
    return mNavigationComponent;
  }

  private void initializeInjector() {
    this.mNavigationComponent = DaggerNavigationComponent.builder()
        .applicationComponent(getApplicationComponent())
        .activityModule(getActivityModule())
        .build();
  }

  @Override public void loadNavigationDrawer(NavigationEntriesModel listOfEntries) {
    Log.d(String.valueOf(this), listOfEntries.getNavigationEntryModelList().size() + "");
  }
}
