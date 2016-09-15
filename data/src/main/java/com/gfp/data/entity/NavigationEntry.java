package com.gfp.data.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo") public class NavigationEntry {

  @SerializedName("type") @Expose private String type;
  @SerializedName("label") @Expose private String label;
  @SerializedName("url") @Expose private String url;
  @SerializedName("children") @Expose private List<NavigationEntry> children = new ArrayList<NavigationEntry>();

  /**
   * @return The type
   */
  public String getType() {
    return type;
  }

  /**
   * @param type The type
   */
  public void setType(String type) {
    this.type = type;
  }

  /**
   * @return The label
   */
  public String getLabel() {
    return label;
  }

  /**
   * @param label The label
   */
  public void setLabel(String label) {
    this.label = label;
  }

  /**
   * @return The children
   */
  public List<NavigationEntry> getChildren() {
    return children;
  }

  /**
   * @param children The children
   */
  public void setChildren(List<NavigationEntry> children) {
    this.children = children;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }
}
