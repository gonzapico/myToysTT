package com.gfp.mytoystt;

import android.app.Application;
import android.os.StrictMode;
import com.gfp.mytoystt.di.components.ApplicationComponent;
import com.gfp.mytoystt.di.components.DaggerApplicationComponent;
import com.gfp.mytoystt.di.modules.ApplicationModule;

/**
 * Created by gfernandez on 15/09/16.
 */

public class BaseMTApplication extends Application {
  private ApplicationComponent applicationComponent;

  @Override public void onCreate() {
    this.initializeStrictMode();
    super.onCreate();
    this.initializeInjector();
  }

  private void initializeInjector() {
    this.applicationComponent =
        DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
  }

  public ApplicationComponent getApplicationComponent() {
    return this.applicationComponent;
  }

  private void initializeStrictMode() {
    if (BuildConfig.DEBUG) {
      StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads()
          .detectDiskWrites()
          .detectNetwork()
          .penaltyLog()
          .build());
      StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectLeakedSqlLiteObjects()
          .detectLeakedClosableObjects()
          .penaltyLog()
          .penaltyDeath()
          .build());
    }
  }
}
