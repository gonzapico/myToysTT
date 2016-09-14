package com.gfp.data.repository.datasource;

import android.content.Context;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Factory that creates different implementations of {@link NavigationDataStore}.
 */
@Singleton public class NavigationDataStoreFactory {

  private final Context context;

  @Inject public NavigationDataStoreFactory(Context context) {
    if (context == null) {
      throw new IllegalArgumentException("Constructor parameters cannot be null!!!");
    }
    this.context = context.getApplicationContext();
  }

  /**
   * Create {@link NavigationDataStore} to retrieve data from the Cloud.
   */
  public NavigationDataStore createCloudDataStore() {

    return new CloudNavigationDataStore(context);
  }
}
