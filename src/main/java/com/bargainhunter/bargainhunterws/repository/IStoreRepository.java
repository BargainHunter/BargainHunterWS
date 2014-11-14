package com.bargainhunter.bargainhunterws.repository;

import com.bargainhunter.bargainhunterws.models.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Tommy on 11/9/2014.
 */
@Repository
public interface IStoreRepository extends JpaRepository<Store, Long> {
}
