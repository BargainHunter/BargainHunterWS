package com.bargainhunter.bargainhunterws.repositories;

import com.bargainhunter.bargainhunterws.models.entities.Branch;
import com.bargainhunter.bargainhunterws.models.entities.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOfferRepository extends JpaRepository<Offer, Long> {
    @Query(value = "SELECT DISTINCT * FROM offer WHERE branch_id = ?1 AND current_timestamp BETWEEN start_date AND exp_date", nativeQuery = true)
    List<Offer> findActiveOfBranch(Branch branch);
}
