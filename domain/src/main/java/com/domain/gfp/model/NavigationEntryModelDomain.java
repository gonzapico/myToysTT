package com.domain.gfp.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gfernandez on 14/09/16.
 */

public class NavigationEntryModelDomain {

  private String type = "";
  private String label = "";
  private String url = "";
  private List<NavigationEntryModelDomain> children = new ArrayList<>();

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

  public List<NavigationEntryModelDomain> getChildren() {
    return children;
  }

  public void setChildren(List<NavigationEntryModelDomain> children) {
    this.children = children;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }
}
