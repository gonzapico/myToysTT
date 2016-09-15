package com.gfp.data.repository.datasource;

import com.gfp.data.ApplicationTestCase;
import com.gfp.data.entity.NavigationEntries;
import com.gfp.data.entity.mapper.NavigationEntityDataMapper;
import com.gfp.data.repository.NavigationRepository;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import rx.Observable;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

/**
 * Created by gfernandez on 14/09/16.
 */
public class NavigationDataStoreFactoryTest extends ApplicationTestCase {
  @Rule public ExpectedException expectedException = ExpectedException.none();

  private NavigationRepository navigationRepository;
  @Mock private NavigationDataStoreFactory mockNavigationDataStoreFactory;
  @Mock private NavigationEntityDataMapper mockNavigationEntityDataMapper;
  @Mock private NavigationDataStore mockNavigationDataStore;
  @Mock private NavigationEntries mockEntityNavigation;

  @Before public void setUp() {
    MockitoAnnotations.initMocks(this);
    navigationRepository =
        new NavigationRepository(mockNavigationDataStoreFactory, mockNavigationEntityDataMapper);

    given(mockNavigationDataStoreFactory.createCloudDataStore()).willReturn(
        mockNavigationDataStore);
  }

  @Test public void testGetConfigurationHappyCase() {
    NavigationEntries entityConfiguration = new NavigationEntries();
    given(mockNavigationDataStore.navigationList()).willReturn(
        Observable.just(entityConfiguration));

    navigationRepository.navigation();

    verify(mockNavigationDataStoreFactory).createCloudDataStore();
    verify(mockNavigationDataStore).navigationList();
  }
}