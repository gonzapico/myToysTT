package com.gfp.mytoystt.di.modules;

import com.domain.gfp.interactor.BaseUseCase;
import com.domain.gfp.interactor.GetNavigation;
import com.gfp.mytoystt.di.PerActivity;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;

/**
 * Created by gfernandez on 15/09/16.
 */
@Module
public class NavigationModule {

  public NavigationModule(){

  }

  @Provides @PerActivity @Named("getNavigation") BaseUseCase provideNavigation(
      GetNavigation getNavigation) {
    return getNavigation;
  }
}