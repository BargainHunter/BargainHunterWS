package com.bargainhunter.bargainhunterws.repositories;

import com.bargainhunter.bargainhunterws.models.entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStoreRepository extends JpaRepository<Store, Long> {
    @Query(value = "SELECT DISTINCT * FROM store WHERE earth_box(ll_to_earth(?1, ?2), ?3) @> ll_to_earth(latitude, longitude)", nativeQuery = true)
    List<Store> findAllInRadius(Double latitude, Double longitude, Double radius);
}
