package com.gfp.data.cloud;

import com.gfp.data.Config;
import com.gfp.data.entity.NavigationEntries;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by gfernandez on 14/09/16.
 */

public interface MyToysAPIService {

  @Headers("x-api-key:" + Config.API_KEY) @GET(Config.API_URL_SECURE + "/api/navigation")
  Call<NavigationEntries> navigation();
}
