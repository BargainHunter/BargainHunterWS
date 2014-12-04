package com.bargainhunter.bargainhunterws.repositories;

import com.bargainhunter.bargainhunterws.models.entities.Company;
import com.bargainhunter.bargainhunterws.models.entities.Store;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

/**
 * Created by Tommy on 11/9/2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/testContext.xml",
        loader = SpringApplicationContextLoader.class)
public class StoreRepositoryTests {
//    @Autowired
//    IStoreRepository storeRepository;
//
//    @Autowired
//    ICompanyRepository companyRepository;
//
//    @Test
//    public void testRepositoryIsNotNull() throws Exception {
//        Assert.assertNotNull("The store repositories should be not-null.", this.storeRepository);
//    }

    @Test
    @Transactional
    public void insertStoreToRepositoryTest() throws Exception {
//        Company company = new Company("Diamantis Masoutis AE", "Greece", "Athens", "Venizelou", "35", "12345");
//        companyRepository.save(company);
//        Store store = new Store("Masoutis", "Greece", "Serres", "Edessis", "18", "62100", 41.546556, 35.345345, company);
//        storeRepository.save(store);
//
//        Store dbStore = storeRepository.getOne(store.getStoreId());
//
//        Assert.assertNotNull(dbStore);
//        Assert.assertEquals("Greece", dbStore.getCountry());
//        Assert.assertEquals("Serres", dbStore.getCity());
//        Assert.assertEquals("18", dbStore.getAddressNo());
//        Assert.assertEquals("62100", dbStore.getZip());
//        Assert.assertEquals(41.546556, dbStore.getLatitude(), 1e-15);
//        Assert.assertEquals(35.345345, dbStore.getLongitude(), 1e-15);
//
//        companyRepository.delete(company);
//        storeRepository.delete(store);
    }

//    @Test
//    @Transactional
//    public void insertStoresWithSameValuesTest() throws Exception {
//        Company company = new Company("Masoutis", "Greece", "Athens", "Venizelou", "35", "12345");
//        companyRepository.save(company);
//
//        Store firstStore = new Store("Masoutis", "Greece", "Serres", "Edessis", "18", "62100", 41.546556, 35.345345, company);
//        Store secondStore = new Store("Masoutis", "Greece", "Serres", "Edessis", "18", "62100", 41.546556, 35.345345, company);
//
//        storeRepository.save(firstStore);
//        storeRepository.save(secondStore);
//
//        Store dbFirstStore = storeRepository.getOne(firstStore.getStoreId());
//        Store dbSecondStore = storeRepository.getOne(secondStore.getStoreId());
//
//        Assert.assertNotNull(dbFirstStore);
//        Assert.assertNotNull(dbSecondStore);
//
//        Assert.assertEquals("Greece", dbFirstStore.getCountry());
//        Assert.assertEquals("Greece", dbSecondStore.getCountry());
//        Assert.assertEquals("Serres", dbFirstStore.getCity());
//        Assert.assertEquals("Serres", dbSecondStore.getCity());
//        Assert.assertEquals("18", dbFirstStore.getAddressNo());
//        Assert.assertEquals("18", dbSecondStore.getAddressNo());
//        Assert.assertEquals("62100", dbFirstStore.getZip());
//        Assert.assertEquals("62100", dbSecondStore.getZip());
//        Assert.assertEquals(41.546556, dbFirstStore.getLatitude(), 1e-15);
//        Assert.assertEquals(41.546556, dbSecondStore.getLatitude(), 1e-15);
//        Assert.assertEquals(35.345345, dbFirstStore.getLongitude(), 1e-15);
//        Assert.assertEquals(35.345345, dbSecondStore.getLongitude(), 1e-15);
//        Assert.assertNotEquals(dbFirstStore.getStoreId(), dbSecondStore.getStoreId());
//
//        companyRepository.delete(company);
//        storeRepository.delete(firstStore);
//        storeRepository.delete(secondStore);
//    }
}
