package com.gfp.data.entity.mapper;

import com.domain.gfp.model.ChildModelDomain;
import com.domain.gfp.model.NavigationEntriesModelDomain;
import com.domain.gfp.model.NavigationEntryModelDomain;
import com.gfp.data.entity.Child;
import com.gfp.data.entity.NavigationEntries;
import com.gfp.data.entity.NavigationEntry;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by gfernandez on 14/09/16.
 */

@Singleton public class NavigationEntityDataMapper {

  @Inject public NavigationEntityDataMapper() {
  }

  public NavigationEntriesModelDomain transformNavigationEntries(NavigationEntries navigationEntries){
    NavigationEntriesModelDomain tranformation = new NavigationEntriesModelDomain();

    tranformation.setNavigationEntryModelDomainList(transformNavigationEntries(navigationEntries.getNavigationEntries()));

    return tranformation;
  }

  private List<NavigationEntryModelDomain> transformNavigationEntries(List<NavigationEntry> navigationEntries) {
    List<NavigationEntryModelDomain> transformation = new ArrayList<>();
    for (NavigationEntry navigationEntry : navigationEntries){
      NavigationEntryModelDomain navigationEntryModelDomain = new NavigationEntryModelDomain();

      navigationEntryModelDomain.setChildren(transformListOfChild(navigationEntry.getChildren()));
      navigationEntryModelDomain.setLabel(navigationEntry.getLabel());
      navigationEntryModelDomain.setType(navigationEntry.getType());
      navigationEntryModelDomain.setUrl(navigationEntry.getUrl());
      transformation.add(navigationEntryModelDomain);
    }

    return transformation;
  }

  private List<NavigationEntryModelDomain> transformListOfChild(List<NavigationEntry> children) {
    List<NavigationEntryModelDomain> transformation = new ArrayList<>();
    for (NavigationEntry child : children){
      NavigationEntryModelDomain childModelDomain = new NavigationEntryModelDomain();

      childModelDomain.setType(child.getType());
      childModelDomain.setLabel(child.getLabel());
      childModelDomain.setUrl(child.getUrl());
      childModelDomain.setChildren(transformListOfChild(child.getChildren()));

      transformation.add(childModelDomain);
    }

    return transformation;
  }
}
