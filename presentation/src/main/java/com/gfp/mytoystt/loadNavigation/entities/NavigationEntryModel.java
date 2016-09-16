package com.gfp.mytoystt.loadNavigation.entities;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gfernandez on 15/09/16.
 */

public class NavigationEntryModel implements Parcelable {

  public static final Parcelable.Creator<NavigationEntryModel> CREATOR =
      new Parcelable.Creator<NavigationEntryModel>() {
        @Override public NavigationEntryModel createFromParcel(Parcel source) {
          return new NavigationEntryModel(source);
        }

        @Override public NavigationEntryModel[] newArray(int size) {
          return new NavigationEntryModel[size];
        }
      };
  private String type = "";
  private String label = "";
  private String url = "";
  private List<NavigationEntryModel> children = new ArrayList<>();

  public NavigationEntryModel() {
  }

  protected NavigationEntryModel(Parcel in) {
    this.type = in.readString();
    this.label = in.readString();
    this.url = in.readString();
    this.children = new ArrayList<NavigationEntryModel>();
    in.readList(this.children, NavigationEntryModel.class.getClassLoader());
  }

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

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(this.type);
    dest.writeString(this.label);
    dest.writeString(this.url);
    dest.writeList(this.children);
  }
}
