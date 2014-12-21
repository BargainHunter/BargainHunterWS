package com.bargainhunter.bargainhunterws.mappers.DTOMappers.searchController;

import com.bargainhunter.bargainhunterws.mappers.IMapper;
import com.bargainhunter.bargainhunterws.models.DTOs.searchController.BranchDTO;
import com.bargainhunter.bargainhunterws.models.DTOs.searchController.OfferDTO;
import com.bargainhunter.bargainhunterws.models.DTOs.searchController.StoreDTO;
import com.bargainhunter.bargainhunterws.models.entities.Branch;
import com.bargainhunter.bargainhunterws.models.entities.Offer;
import com.bargainhunter.bargainhunterws.models.entities.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BranchDTOMapper implements IMapper<Branch, BranchDTO> {
    @Autowired
    private IMapper<Store, StoreDTO> storeDTOMapper;

    @Autowired
    private IMapper<Offer, OfferDTO> offerDTOMapper;

    @Override
    public BranchDTO map(Branch source, BranchDTO target) {
        target.setBranchId(source.getBranchId());

        for (Store store : source.getStores()) {
            target.getStores().add(storeDTOMapper.map(store, new StoreDTO()));
        }

        for (Offer offer : source.getOffers()) {
            target.getOffers().add(offerDTOMapper.map(offer, new OfferDTO()));
        }

        return target;
    }
}
