package com.gfp.mytoystt.loadNavigation.mapper;

import com.domain.gfp.model.NavigationEntriesModelDomain;
import com.domain.gfp.model.NavigationEntryModelDomain;
import com.gfp.mytoystt.loadNavigation.NavigationEntriesModel;
import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

/**
 * Created by gfernandez on 16/09/16.
 */
public class DomainNavigationEntriesMapperTest extends TestCase {
  private DomainNavigationEntriesMapper domainNavigationEntriesMapper;

  @Override protected void setUp() throws Exception {
    super.setUp();
    domainNavigationEntriesMapper = new DomainNavigationEntriesMapper();
  }

  @Test public void transform() throws Exception {
    NavigationEntryModelDomain mockNavigationEntryModelOne = mock(NavigationEntryModelDomain.class);
    NavigationEntryModelDomain mockNavigationEntryModelTwo = mock(NavigationEntryModelDomain.class);

    List<NavigationEntryModelDomain> navigationEntryModels =
        new ArrayList<NavigationEntryModelDomain>(5);
    navigationEntryModels.add(mockNavigationEntryModelOne);
    navigationEntryModels.add(mockNavigationEntryModelTwo);

    NavigationEntriesModelDomain navigationEntriesModelDomain = new NavigationEntriesModelDomain();
    navigationEntriesModelDomain.setNavigationEntryModelDomainList(navigationEntryModels);

    NavigationEntriesModel navigationEntriesModel =
        domainNavigationEntriesMapper.transform(navigationEntriesModelDomain);

    assertThat(navigationEntriesModel, is(instanceOf(NavigationEntriesModel.class)));
    assertThat(navigationEntriesModel.getNavigationEntryModelList().size(), is(2));
  }
}