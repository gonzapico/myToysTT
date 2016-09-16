package com.gfp.data.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo") public class Child {

  @SerializedName("type") @Expose private String type;
  @SerializedName("label") @Expose private String label;
  @SerializedName("url") @Expose private String url;

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
   * @return The url
   */
  public String getUrl() {
    return url;
  }

  /**
   * @param url The url
   */
  public void setUrl(String url) {
    this.url = url;
  }
}
