package com.gfp.data.di;

import com.gfp.data.repository.datasource.CloudNavigationDataStore;
import dagger.Component;
import javax.inject.Singleton;

/**
 * Created by gfernandez on 28/07/16.
 */
@Singleton @Component(modules = CloudModule.class) public interface CloudComponent {
  void inject(CloudNavigationDataStore cloudNewsDataStore);
}
