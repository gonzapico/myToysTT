package com.gfp.data.repository.datasource;

import com.gfp.data.ApplicationTestCase;
import com.gfp.data.entity.NavigationEntries;
import com.gfp.data.repository.NavigationRepository;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import retrofit2.Call;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

/**
 * Created by gfernandez on 14/09/16.
 */
public class NavigationDataStoreFactoryTest extends ApplicationTestCase {
  //@Rule public ExpectedException expectedException = ExpectedException.none();
  //
  //private NavigationRepositoryDomain navigationRepository;
  //@Mock private NavigationDataStoreFactory mockNavigationDataStoreFactory;
  //@Mock private ConfigEntityDataMapper mockConfigEntityDataMapper;
  //@Mock private NavigationDataStore mockNavigationDataStore;
  //@Mock private NavigationEntries mockEntityNavigation;
  //@Mock private TopNotification mockTopNotification;
  //
  //@Before public void setUp() {
  //  MockitoAnnotations.initMocks(this);
  //  navigationRepository = new NavigationRepositoryDomain(mockNavigationDataStoreFactory, mockConfigEntityDataMapper);
  //
  //  given(mockNavigationDataStoreFactory.createCloudDataStore()).willReturn(mockConfigDataStore);
  //}
  //
  //@Test public void testGetConfigurationHappyCase() {
  //  NavigationEntries entityConfiguration = new NavigationEntries();
  //  given(mockNavigationDataStore.navigationList()).willReturn(Call<NavigationEntries>.just(entityConfiguration));
  //
  //  navigationRepository.
  //
  //  verify(mockNavigationDataStoreFactory).createCloudDataStore();
  //  verify(mockNavigationDataStore).navigationList();
  //}
}