package com.bargainhunter.bargainhunterws.repositories;

import com.bargainhunter.bargainhunterws.models.entities.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISubcategoryRepository extends JpaRepository<Subcategory, Long> {
}
