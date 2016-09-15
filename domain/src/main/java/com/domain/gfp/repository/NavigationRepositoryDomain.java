package com.domain.gfp.repository;

import com.domain.gfp.model.NavigationEntriesModelDomain;
import rx.Observable;

/**
 * Created by gfernandez on 14/09/16.
 */

public interface NavigationRepositoryDomain {
  /**
   * Get an {@link rx.Observable} which will emit a {@link NavigationEntriesModelDomain}.
   */
  Observable<NavigationEntriesModelDomain> navigation();
}