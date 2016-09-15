package com.gfp.mytoystt.di.components;

import com.gfp.mytoystt.HomeActivity;
import com.gfp.mytoystt.di.PerActivity;
import com.gfp.mytoystt.di.modules.ActivityModule;
import com.gfp.mytoystt.di.modules.NavigationModule;
import dagger.Component;

/**
 * Created by gfernandez on 15/09/16.
 */
@PerActivity @Component(dependencies = ApplicationComponent.class, modules = { ActivityModule.class,
    NavigationModule.class})
public interface NavigationComponent extends ActivityComponent {
  void inject(HomeActivity homeActivity);
}
