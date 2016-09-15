package com.gfp.mytoystt.loadNavigation;

import com.domain.gfp.model.ChildModelDomain;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gfernandez on 15/09/16.
 */

public class NavigationEntryModel {

  private String type = "";
  private String label = "";
  private String url = "";
  private List<NavigationEntryModel> children = new ArrayList<>();

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public List<NavigationEntryModel> getChildren() {
    return children;
  }

  public void setChildren(List<NavigationEntryModel> children) {
    this.children = children;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }
}
