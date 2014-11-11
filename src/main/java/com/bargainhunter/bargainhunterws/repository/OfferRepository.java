package com.bargainhunter.bargainhunterws.repository;

import com.bargainhunter.bargainhunterws.models.Offer;
import com.bargainhunter.bargainhunterws.models.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Johnny on 11/9/2014.
 */
@Repository
public interface OfferRepository extends JpaRepository<Offer, Long>{

}
