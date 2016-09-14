package com.gfp.data.repository.datasource;

import com.gfp.data.entity.NavigationEntries;
import retrofit2.Call;

/**
 * Created by gfernandez on 16/08/16.
 */
public interface NavigationDataStore {

  /***
   * Get this information from the API
   *
   * @return a list of {@link NavigationEntries}
   */
  Call<NavigationEntries> navigationList();
}
