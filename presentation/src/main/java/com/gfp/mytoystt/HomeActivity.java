package com.gfp.mytoystt;

import android.os.Bundle;
import com.gfp.mytoystt.loadNavigation.NavigationEntriesModel;
import java.util.List;

public class HomeActivity extends BaseMTActivity implements
    com.gfp.mytoystt.loadNavigation.NavigationView {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override protected int getLayoutResource() {
    return R.layout.activity_home;
  }

  @Override public void loadNavigationDrawer(List<NavigationEntriesModel> listOfEntries) {

  }
}
