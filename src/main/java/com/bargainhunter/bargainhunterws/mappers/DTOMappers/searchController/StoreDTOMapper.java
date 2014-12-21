package com.bargainhunter.bargainhunterws.mappers.DTOMappers.searchController;

import com.bargainhunter.bargainhunterws.mappers.IMapper;
import com.bargainhunter.bargainhunterws.models.DTOs.searchController.StoreDTO;
import com.bargainhunter.bargainhunterws.models.entities.Store;
import org.springframework.stereotype.Component;

@Component
public class StoreDTOMapper implements IMapper<Store, StoreDTO> {
    @Override
    public StoreDTO map(Store source, StoreDTO target) {
        target.setStoreId(source.getStoreId());
        target.setStoreName(source.getBranch().getBranchName());
        target.setCity(source.getCity());
        target.setAddress(source.getAddress());
        target.setAddressNo(source.getAddressNo());
        target.setLatitude(source.getLatitude());
        target.setLongitude(source.getLongitude());

        return target;
    }
}
