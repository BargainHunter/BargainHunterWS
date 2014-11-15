package com.bargainhunter.bargainhunterws.repositories;

import com.bargainhunter.bargainhunterws.models.entities.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Johnny on 11/9/2014.
 */
@Repository
public interface IOfferRepository extends JpaRepository<Offer, Long> {
}
