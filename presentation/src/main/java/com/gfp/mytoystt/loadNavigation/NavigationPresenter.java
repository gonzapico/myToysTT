package com.gfp.mytoystt.loadNavigation;

import android.support.annotation.NonNull;
import com.domain.gfp.interactor.BaseUseCase;
import com.domain.gfp.interactor.DefaultSubscriber;
import com.domain.gfp.model.NavigationEntriesModelDomain;
import com.gfp.mytoystt.di.PerActivity;
import com.gfp.mytoystt.loadNavigation.mapper.DomainNavigationEntriesMapper;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by gfernandez on 15/09/16.
 */
@PerActivity public class NavigationPresenter {
  private NavigationView mNavigationView;
  private DomainNavigationEntriesMapper mNavigationMapper;

  private BaseUseCase mGetNavigationUseCase;

  @Inject public NavigationPresenter(@Named("getNavigation") BaseUseCase useCase,
      DomainNavigationEntriesMapper navigationEntityDataMapper) {
    this.mGetNavigationUseCase = useCase;
    this.mNavigationMapper = navigationEntityDataMapper;
  }

  public NavigationView getmNavigationView() {
    return mNavigationView;
  }

  public void setmNavigationView(@NonNull NavigationView mNavigationView) {
    this.mNavigationView = mNavigationView;
  }

  public void getNavigationItems() {
    mGetNavigationUseCase.execute(new NavigationSuscriber());
  }

  private void showItemsOnNavigatorView(NavigationEntriesModelDomain navigationEntriesModelDomain) {
    final NavigationEntriesModel listOfNavigationEntries =
        this.mNavigationMapper.transform(navigationEntriesModelDomain);
    this.mNavigationView.loadNavigationDrawer(listOfNavigationEntries);
  }

  private final class NavigationSuscriber extends DefaultSubscriber<NavigationEntriesModelDomain> {
    @Override public void onCompleted() {

    }

    @Override public void onError(Throwable e) {
    }

    @Override public void onNext(NavigationEntriesModelDomain navigationEntriesModelDomain) {
      NavigationPresenter.this.showItemsOnNavigatorView(navigationEntriesModelDomain);
    }
  }
}
