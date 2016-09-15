package com.gfp.mytoystt.loadNavigation.mapper;

import com.domain.gfp.model.NavigationEntriesModelDomain;
import com.domain.gfp.model.NavigationEntryModelDomain;
import com.gfp.mytoystt.di.PerActivity;
import com.gfp.mytoystt.loadNavigation.NavigationEntriesModel;
import com.gfp.mytoystt.loadNavigation.NavigationEntryModel;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by gfernandez on 12/08/16.
 *
 * Mapper to transform classes from domain layer to the same on the presentation layer.
 */
@PerActivity public class DomainNavigationEntriesMapper {

  @Inject public DomainNavigationEntriesMapper() {

  }

  /***
   * Transform a {@link NavigationEntriesModelDomain} into an {@link NavigationEntriesModel}
   *
   * @param navigationEntriesModelDomain Object to be transformed.
   * @return {@link NavigationEntriesModel}
   */
  public NavigationEntriesModel transform(
      NavigationEntriesModelDomain navigationEntriesModelDomain) {

    if (navigationEntriesModelDomain == null) {
      throw new IllegalArgumentException("Cannot transform a null value");
    }
    NavigationEntriesModel navigationEntriesModel = new NavigationEntriesModel();
    navigationEntriesModel.setNavigationEntryModelList(transformListOfNavigationEntries(
        navigationEntriesModelDomain.getNavigationEntryModelDomainList()));
    return navigationEntriesModel;
  }

  private List<NavigationEntryModel> transformListOfNavigationEntries(
      List<NavigationEntryModelDomain> navigationEntryModelDomainList) {
    if (navigationEntryModelDomainList == null) {
      throw new IllegalArgumentException("Cannot transform a null value");
    }

    List<NavigationEntryModel> transformation = new ArrayList<>();
    for (NavigationEntryModelDomain navigationEntryModelDomain : navigationEntryModelDomainList) {
      NavigationEntryModel navigationEntryModel = new NavigationEntryModel();

      navigationEntryModel.setLabel(navigationEntryModelDomain.getLabel());
      navigationEntryModel.setType(navigationEntryModelDomain.getType());
      navigationEntryModel.setUrl(navigationEntryModelDomain.getUrl());
      navigationEntryModel.setChildren(
          transformListOfChild(navigationEntryModelDomain.getChildren()));
      transformation.add(navigationEntryModel);
    }

    return transformation;
  }

  private List<NavigationEntryModel> transformListOfChild(
      List<NavigationEntryModelDomain> children) {
    if (children == null) {
      throw new IllegalArgumentException("Cannot transform a null value");
    }

    List<NavigationEntryModel> resultOfTransformation = new ArrayList<>();
    for (NavigationEntryModelDomain childModelDomain : children) {
      NavigationEntryModel childModel = new NavigationEntryModel();
      childModel.setType(childModelDomain.getType());
      childModel.setLabel(childModelDomain.getLabel());
      childModel.setUrl(childModelDomain.getUrl());
      childModel.setChildren(transformListOfChild(childModelDomain.getChildren()));
      resultOfTransformation.add(childModel);
    }

    return resultOfTransformation;
  }
}
