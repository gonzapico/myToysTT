package com.gfp.data.repository;

import com.domain.gfp.model.NavigationEntriesModelDomain;
import com.domain.gfp.repository.NavigationRepositoryDomain;
import com.gfp.data.entity.mapper.NavigationEntityDataMapper;
import com.gfp.data.repository.datasource.NavigationDataStore;
import com.gfp.data.repository.datasource.NavigationDataStoreFactory;
import javax.inject.Inject;
import javax.inject.Singleton;
import rx.Observable;

/**
 * Created by gfernandez on 14/09/16.
 */
@Singleton public class NavigationRepository implements NavigationRepositoryDomain {

  private final NavigationDataStoreFactory navigationDataStoreFactory;
  private final NavigationEntityDataMapper navigationEntityDataMapper;

  @Inject public NavigationRepository(NavigationDataStoreFactory navigationDataStoreFactory, NavigationEntityDataMapper navigationEntityDataMapper) {
    this.navigationDataStoreFactory = navigationDataStoreFactory;
    this.navigationEntityDataMapper = navigationEntityDataMapper;

  }

  @SuppressWarnings("Convert2MethodRef") @Override
  public Observable<NavigationEntriesModelDomain> navigation() {
    final NavigationDataStore configDataStore =
        this.navigationDataStoreFactory.createCloudDataStore();
    return configDataStore.navigationList()
        .map(navigationEntries -> this.navigationEntityDataMapper.transformNavigationEntries(navigationEntries));
  }
}

