package com.gfp.data.entity.mapper;

import com.domain.gfp.model.NavigationEntriesModelDomain;
import com.domain.gfp.model.NavigationEntryModelDomain;
import com.gfp.data.entity.NavigationEntries;
import com.gfp.data.entity.NavigationEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by gfernandez on 15/09/16.
 */
public class NavigationEntityDataMapperTest {
  private NavigationEntityDataMapper navigationEntityDataMapper;

  private Random random;

  @Before
  public void setUp() throws Exception {
    navigationEntityDataMapper = new NavigationEntityDataMapper();
    random = new Random();
    random.setSeed((long) 2);
  }

  @Test
  public void testTransformNavigation() {
    NavigationEntriesModelDomain navigationEntriesModelDomain = navigationEntityDataMapper.transformNavigationEntries(createFakeNavigationEntries());

    assertThat(navigationEntriesModelDomain, is(instanceOf(NavigationEntriesModelDomain.class)));
    NavigationEntryModelDomain navigationEntry = navigationEntriesModelDomain.getNavigationEntryModelDomainList().get(0);
    assertThat(navigationEntry.getLabel(), notNullValue());
    assertThat(navigationEntry.getType(), notNullValue());
    assertThat(navigationEntry.getUrl(), notNullValue());
  }

  private NavigationEntries createFakeNavigationEntries() {
    NavigationEntries navigationEntries = new NavigationEntries();

    navigationEntries.setNavigationEntries(createFakeListOfNavigationEntries());
    return navigationEntries;
  }

  private List<NavigationEntry> createFakeListOfNavigationEntries() {
    List<NavigationEntry> fakeList = new ArrayList<>();

    fakeList.add(createFakeNavigationEntry());

    return fakeList;
  }

  private NavigationEntry createFakeNavigationEntry() {
    NavigationEntry navigationEntry = new NavigationEntry();

    navigationEntry.setUrl("http://www.marca.es");
    navigationEntry.setLabel("fake");


    switch (random.nextInt()){
      case 0:
        navigationEntry.setType("node");
        break;
      case 1:
        navigationEntry.setType("section");
        break;
      case 2:
        navigationEntry.setType("link");
        break;
      default:
        navigationEntry.setType("node");
        break;
    }
    for (int i = 0; i < random.nextInt(); i++){
      navigationEntry.getChildren().add(createFakeNavigationEntry());
    }

    return navigationEntry;
  }
}