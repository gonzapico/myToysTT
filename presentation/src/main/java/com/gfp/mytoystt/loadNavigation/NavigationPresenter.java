package com.gfp.mytoystt.loadNavigation;

import com.domain.gfp.interactor.DefaultSubscriber;
import com.domain.gfp.interactor.GetNavigation;

/**
 * Created by gfernandez on 15/09/16.
 */

public class NavigationPresenter {
  private NavigationView mNavigationView;
  private GetNavigation mGetNavigation;

  NavigationPresenter() {

  }

  NavigationPresenter(NavigationView navigationView) {
    this.mNavigationView = navigationView;
  }

  public NavigationView getmNavigationView() {
    return mNavigationView;
  }

  public void setmNavigationView(NavigationView mNavigationView) {
    this.mNavigationView = mNavigationView;
  }

  public void getNavigationItems(){
    mGetNavigation.execute(new NavigationSuscriber());
  }

  private final class NavigationSuscriber extends DefaultSubscriber<NavigationEntriesModel>{
    
  }
}
