package com.gfp.data.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo") public class NavigationEntries {

  @SerializedName("navigationEntries") @Expose private List<NavigationEntry> navigationEntries =
      new ArrayList<NavigationEntry>();

  /**
   * @return The navigationEntries
   */
  public List<NavigationEntry> getNavigationEntries() {
    return navigationEntries;
  }

  /**
   * @param navigationEntries The navigationEntries
   */
  public void setNavigationEntries(List<NavigationEntry> navigationEntries) {
    this.navigationEntries = navigationEntries;
  }
}
