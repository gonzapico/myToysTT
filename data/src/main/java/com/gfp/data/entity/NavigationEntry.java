package com.gfp.data.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo") public class NavigationEntry {

  @SerializedName("type") @Expose private String type;
  @SerializedName("label") @Expose private String label;
  @SerializedName("children") @Expose private List<Child> children = new ArrayList<Child>();

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
  public List<Child> getChildren() {
    return children;
  }

  /**
   * @param children The children
   */
  public void setChildren(List<Child> children) {
    this.children = children;
  }
}
