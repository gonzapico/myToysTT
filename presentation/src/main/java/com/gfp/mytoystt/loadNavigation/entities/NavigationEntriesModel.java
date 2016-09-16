package com.gfp.mytoystt.loadNavigation.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gfernandez on 15/09/16.
 */

public class NavigationEntriesModel {

  List<NavigationEntryModel> navigationEntryModelDomainList = new ArrayList<>();

  public List<NavigationEntryModel> getNavigationEntryModelList() {
    return navigationEntryModelDomainList;
  }

  public void setNavigationEntryModelList(
      List<NavigationEntryModel> navigationEntryModelDomainList) {
    this.navigationEntryModelDomainList = navigationEntryModelDomainList;
  }
}
