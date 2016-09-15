package com.domain.gfp.interactor;

import com.elconfidencial.domain.app.executor.PostExecutionThread;
import com.elconfidencial.domain.app.executor.ThreadExecutor;
import com.elconfidencial.domain.app.repository.TopNotificationsRepository;
import javax.inject.Inject;
import rx.Observable;

/**
 * Created by gfernandez on 1/07/16.
 */
public class GetNavigation extends BaseUseCase {
  private final TopNotificationsRepository mRepository;

  @Inject public GetNavigation(
      TopNotificationsRepository topNotificationsRepository, ThreadExecutor threadExecutor,
      PostExecutionThread postExecutionThread) {
    super(threadExecutor, postExecutionThread);
    this.mRepository = topNotificationsRepository;
  }

  @Override public Observable buildUseCaseObservable() {
    return this.mRepository.config();
  }
}
