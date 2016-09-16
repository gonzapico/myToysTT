package com.gfp.mytoystt.loadNavigation;

import android.support.annotation.NonNull;
import com.domain.gfp.interactor.BaseUseCase;
import com.domain.gfp.interactor.DefaultSubscriber;
import com.domain.gfp.model.NavigationEntriesModelDomain;
import com.gfp.mytoystt.OnListFragmentInteractionListener;
import com.gfp.mytoystt.di.PerActivity;
import com.gfp.mytoystt.loadNavigation.entities.NavigationEntriesModel;
import com.gfp.mytoystt.loadNavigation.entities.NavigationEntryModel;
import com.gfp.mytoystt.loadNavigation.mapper.DomainNavigationEntriesMapper;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by gfernandez on 15/09/16.
 */
@PerActivity public class NavigationPresenter implements OnListFragmentInteractionListener {
  public static final String SECTION = "section";
  public static final String NODO = "node";
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

  @Override public void onListFragmentInteraction(NavigationEntryModel mItem) {
    navigateTo(mItem);
  }

  private void navigateTo(NavigationEntryModel navigationEntryModel) {
    if ((navigationEntryModel.getType().contains(NODO))) {
      this.mNavigationView.navigateToDeepLevel(navigationEntryModel);
      this.mNavigationView.changeNavigationHeader(navigationEntryModel.getLabel());
      this.mNavigationView.showBackArrow();
    } else {
      this.mNavigationView.loadUrl(navigationEntryModel.getUrl());
      this.mNavigationView.closeNavigator();
      this.mNavigationView.restartMenu();
    }
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
