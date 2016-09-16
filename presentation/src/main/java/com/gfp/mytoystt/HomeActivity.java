package com.gfp.mytoystt;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import com.gfp.mytoystt.di.HasComponent;
import com.gfp.mytoystt.di.components.DaggerNavigationComponent;
import com.gfp.mytoystt.di.components.NavigationComponent;
import com.gfp.mytoystt.loadNavigation.NavigationEntriesModel;
import com.gfp.mytoystt.loadNavigation.NavigationEntryModel;
import com.gfp.mytoystt.loadNavigation.NavigationPresenter;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class HomeActivity extends BaseMTActivity
    implements com.gfp.mytoystt.loadNavigation.NavigationView, HasComponent<NavigationComponent> {

  @Inject NavigationPresenter mNavigationPresenter;
  @BindView(R.id.wvMain) WebView wvMain;
  private NavigationComponent mNavigationComponent;

  private NavigationEntriesModel initMenu = null;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.initializeInjector();
    this.getComponent().inject(this);
    mNavigationPresenter.setmNavigationView(this);
    mNavigationPresenter.getNavigationItems();
    loadUrl("https://www.mytoys.de");
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
    initMenu = listOfEntries;
    List<NavigationEntryModel> listOfNavigation = new ArrayList<>();
    for (NavigationEntryModel navigationItem : listOfEntries.getNavigationEntryModelList()){
      listOfNavigation.add(navigationItem);
      for (NavigationEntryModel navigationElement : navigationItem.getChildren()){
        listOfNavigation.add(navigationElement);
      }
    }
    NavigationItemFragment navigationItemFragment =
        NavigationItemFragment.newInstance(1, listOfNavigation);
    navigationItemFragment.setOnRowListener(mNavigationPresenter);
    addFragment(R.id.fragmentContainer, navigationItemFragment);
    Log.d(String.valueOf(this), listOfEntries.getNavigationEntryModelList().size() + "");
    ((ImageView)findViewById(R.id.ivClose)).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        closeNavigator();

      }
    });
    hideBackArrow();
    //changeNavigationHeader("myToys");
    changeNavigationHeader("");
    showLogo();

  }

  @Override public void closeNavigator() {
    closeDrawer();
  }

  @Override public void loadUrl(String url) {
    wvMain.loadUrl(url);
  }

  @Override public void navigateToDeepLevel(NavigationEntryModel navigationEntryModel) {
    NavigationItemFragment navigationItemFragment =
        NavigationItemFragment.newInstance(1, navigationEntryModel.getChildren());
    navigationItemFragment.setOnRowListener(mNavigationPresenter);
    replaceFragment(R.id.fragmentContainer, navigationItemFragment);
  }

  @Override public void navigateToHighLevel() {
    popBackStack();
  }

  @Override public void changeNavigationHeader(String header) {

    ((TextView)findViewById(R.id.tvNavHeader)).setText(header);
  }

  @Override public void showBackArrow() {
    ((ImageView)findViewById(R.id.ivNavHeaderBack)).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        changeNavigationHeader(((TextView)findViewById(R.id.tvNavHeader)).getText().toString());
        popBackStack();
        if (shouldShowLogo()) {
          setUpInitStateOfMenu();
        }

      }
    });
    ((ImageView)findViewById(R.id.ivNavHeaderBack)).setVisibility(View.VISIBLE);
    hideLogo();
  }

  @Override public void hideBackArrow() {

    ((ImageView)findViewById(R.id.ivNavHeaderBack)).setVisibility(View.INVISIBLE);
  }

  @Override public void restartMenu() {
    removeAllFragments();
    setUpInitStateOfMenu();
  }

  public void setUpInitStateOfMenu(){
    showLogo();
    changeNavigationHeader("");
    hideBackArrow();
  }

  @Override public void showLogo() {
    ((ImageView)findViewById(R.id.ivLogo)).setVisibility(View.VISIBLE);
  }

  @Override public void hideLogo() {
    ((ImageView)findViewById(R.id.ivLogo)).setVisibility(View.GONE);
  }
}
