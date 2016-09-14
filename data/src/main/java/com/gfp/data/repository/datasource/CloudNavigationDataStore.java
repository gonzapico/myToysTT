package com.gfp.data.repository.datasource;

import android.content.Context;
import com.gfp.data.MyToysAPIService;
import com.gfp.data.di.CloudModule;
import com.gfp.data.di.DaggerCloudComponent;
import com.gfp.data.entity.NavigationEntries;
import javax.inject.Inject;
import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * Created by gfernandez on 16/08/16.
 */
public class CloudNavigationDataStore implements NavigationDataStore {

  @Inject Retrofit retrofit;
  private MyToysAPIService restApi;
  private Context context;

  /**
   * Construct a {@link NavigationDataStore} based on connections to the api (Cloud).
   */
  @Inject public CloudNavigationDataStore(Context context) {
    this.context = context;
    initDagger();
    initRetrofit();
  }

  private void initRetrofit() {
    restApi = retrofit.create(MyToysAPIService.class);
  }

  private void initDagger() {
    DaggerCloudComponent.builder()
        // list of modules that are part of this component need to be created here too
        .cloudModule(new CloudModule(com.gfp.data.Config.API_URL_SECURE, this.context))
        .build()
        .inject(this);
  }

  @Override public Call<NavigationEntries> navigationList() {
    return restApi.navigation();
  }
}
