package com.domain.gfp.interactor;

import com.domain.gfp.executor.PostExecutionThread;
import com.domain.gfp.executor.ThreadExecutor;
import com.domain.gfp.repository.NavigationRepositoryDomain;
import javax.inject.Inject;
import rx.Observable;

/**
 * Created by gfernandez on 1/07/16.
 */
public class GetNavigation extends BaseUseCase {
  private final NavigationRepositoryDomain mRepository;

  @Inject public GetNavigation(
      NavigationRepositoryDomain topNotificationsRepository, ThreadExecutor threadExecutor,
      PostExecutionThread postExecutionThread) {
    super(threadExecutor, postExecutionThread);
    this.mRepository = topNotificationsRepository;
  }

  @Override public Observable buildUseCaseObservable() {
    return this.mRepository.navigation();
  }
}
