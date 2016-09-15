package com.gfp.mytoystt.loadNavigation;

/**
 * Created by gfernandez on 15/09/16.
 */

public interface NavigationView {

  void loadNavigationDrawer(NavigationEntriesModel listOfEntries);

  void closeNavigator();

  void loadUrl(String url);

  void navigateToDeepLevel(NavigationEntryModel navigationEntryModel);

  void navigateToHighLevel();

  void changeNavigationHeader(String header);

  void showBackArrow();

  void hideBackArrow();

  void restartMenu();
}
