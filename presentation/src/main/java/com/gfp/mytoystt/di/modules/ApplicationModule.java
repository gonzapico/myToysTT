package com.gfp.mytoystt.di.modules;
/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.content.Context;
import com.domain.gfp.executor.PostExecutionThread;
import com.domain.gfp.executor.ThreadExecutor;
import com.domain.gfp.repository.NavigationRepositoryDomain;
import com.gfp.data.executor.JobExecutor;
import com.gfp.data.repository.NavigationRepository;
import com.gfp.mytoystt.BaseMTApplication;
import com.gfp.mytoystt.UIThread;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Dagger module that provides objects which will live during the application lifecycle.
 */
@Module public class ApplicationModule {
  private final BaseMTApplication application;

  public ApplicationModule(BaseMTApplication application) {
    this.application = application;
  }

  @Provides @Singleton Context provideApplicationContext() {
    return this.application;
  }

  @Provides @Singleton ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
    return jobExecutor;
  }

  @Provides @Singleton PostExecutionThread providePostExecutionThread(UIThread uiThread) {
    return uiThread;
  }

  @Provides @Singleton NavigationRepositoryDomain provideNavigationRepository(NavigationRepository navigationRepository){
    return navigationRepository;
  }

}
