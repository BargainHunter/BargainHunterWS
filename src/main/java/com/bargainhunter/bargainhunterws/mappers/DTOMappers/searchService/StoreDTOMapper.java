package com.bargainhunter.bargainhunterws.mappers.DTOMappers.searchService;

import com.bargainhunter.bargainhunterws.mappers.IMapper;
import com.bargainhunter.bargainhunterws.models.DTOs.searchService.StoreDTO;
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
        target.setLatitude(source.getCoordinates().getX());
        target.setLongitude(source.getCoordinates().getY());

        return target;
    }
}
