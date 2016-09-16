package com.domain.gfp.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gfernandez on 14/09/16.
 */

public class NavigationEntriesModelDomain {

  List<NavigationEntryModelDomain> navigationEntryModelDomainList = new ArrayList<>();

  public List<NavigationEntryModelDomain> getNavigationEntryModelDomainList() {
    return navigationEntryModelDomainList;
  }

  public void setNavigationEntryModelDomainList(
      List<NavigationEntryModelDomain> navigationEntryModelDomainList) {
    this.navigationEntryModelDomainList = navigationEntryModelDomainList;
  }
}
