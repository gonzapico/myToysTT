package com.gfp.mytoystt;

/**
 * Created by gfernandez on 14/09/16.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;
import com.gfp.mytoystt.di.components.ApplicationComponent;
import com.gfp.mytoystt.di.modules.ActivityModule;

/***
 * Base Activity from where other Activities will extend
 */
public abstract class BaseMTActivity extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener {

  @BindView(R.id.toolbar) Toolbar mToolbar;
  @BindView(R.id.fab) FloatingActionButton mFab;
  @BindView(R.id.drawer_layout) DrawerLayout mDrawerLayout;
  @BindView(R.id.nav_view) NavigationView mNavigationView;
  @Optional @OnClick(R.id.ivClose) void closeDrawer(){
    if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
      mDrawerLayout.closeDrawer(GravityCompat.START);
    }
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(getLayoutResource());

    ButterKnife.bind(this);

    if (mToolbar != null) {
      setSupportActionBar(mToolbar);
    }

    setupDrawerLayout();
  }

  protected abstract int getLayoutResource();

  private void setupDrawerLayout() {
    ActionBarDrawerToggle toggle =
        new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open,
            R.string.navigation_drawer_close);
    mDrawerLayout.setDrawerListener(toggle);
    toggle.syncState();

    mNavigationView.setNavigationItemSelectedListener(this);
  }

  @SuppressWarnings("StatementWithEmptyBody") @Override
  public boolean onNavigationItemSelected(MenuItem item) {
    // Handle navigation view item clicks here.
    int id = item.getItemId();

    if (id == R.id.nav_camera) {
      // Handle the camera action
    } else if (id == R.id.nav_gallery) {

    } else if (id == R.id.nav_slideshow) {

    } else if (id == R.id.nav_manage) {

    } else if (id == R.id.nav_share) {

    } else if (id == R.id.nav_send) {

    }

    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    drawer.closeDrawer(GravityCompat.START);
    return true;
  }

  @Override public void onBackPressed() {
    if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
      mDrawerLayout.closeDrawer(GravityCompat.START);
    } else {
      super.onBackPressed();
    }
  }

  private void closeNavigation(){
    if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
      mDrawerLayout.closeDrawer(GravityCompat.START);
    }
  }

  /**
   * Get the Main Application component for dependency injection.
   *
   * @return {@link ApplicationComponent}
   */
  protected ApplicationComponent getApplicationComponent() {
    return ((BaseMTApplication) getApplication()).getApplicationComponent();
  }

  /**
   * Get an Activity module for dependency injection.
   *
   * @return {@link ActivityModule}
   */
  protected ActivityModule getActivityModule() {
    return new ActivityModule(this);
  }

}
