package com.bargainhunter.bargainhunterws.repository;

import com.bargainhunter.bargainhunterws.models.Store;
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
@ContextConfiguration(locations = "classpath:META-INF/test-context.xml",
        loader = SpringApplicationContextLoader.class)
public class StoreRepositoryTests {
    @Autowired
    StoreRepository storeRepository;

    @Test
    public void testRepositoryIsNotNull() throws Exception {
        Assert.assertNotNull("The store repository should be not-null.", this.storeRepository);
    }

    @Test
    @Transactional
    public void insertStoreToRepositoryTest() throws Exception {
        Store store = new Store("Greece", "Serres", "Edessis", 18, "62100", 41.546556, 35.345345);
        storeRepository.save(store);

        Store dbStore = storeRepository.findOne(store.getStoreId());

        Assert.assertNotNull(dbStore);
        Assert.assertEquals("Greece", dbStore.getCountry());
        Assert.assertEquals("Serres", dbStore.getCity());
        Assert.assertEquals(18, dbStore.getAddressNo());
        Assert.assertEquals("62100", dbStore.getZip());
        Assert.assertEquals(41.546556, dbStore.getLatitude(), 1e-15);
        Assert.assertEquals(35.345345, dbStore.getLongitude(), 1e-15);
    }

    @Test
    @Transactional
    public void insertStoresWithSameValuesTest() throws Exception {
        Store firstStore = new Store("Greece", "Serres", "Edessis", 18, "62100", 41.546556, 35.345345);
        Store secondStore = new Store("Greece", "Serres", "Edessis", 18, "62100", 41.546556, 35.345345);

        storeRepository.save(firstStore);
        storeRepository.save(secondStore);

        Store dbFirstStore = storeRepository.findOne(firstStore.getStoreId());
        Store dbSecondStore = storeRepository.findOne(secondStore.getStoreId());

        Assert.assertNotNull(dbFirstStore);
        Assert.assertNotNull(dbSecondStore);

        Assert.assertEquals("Greece", dbFirstStore.getCountry());
        Assert.assertEquals("Greece", dbSecondStore.getCountry());
        Assert.assertEquals("Serres", dbFirstStore.getCity());
        Assert.assertEquals("Serres", dbSecondStore.getCity());
        Assert.assertEquals(18, dbFirstStore.getAddressNo());
        Assert.assertEquals(18, dbSecondStore.getAddressNo());
        Assert.assertEquals("62100", dbFirstStore.getZip());
        Assert.assertEquals("62100", dbSecondStore.getZip());
        Assert.assertEquals(41.546556, dbFirstStore.getLatitude(), 1e-15);
        Assert.assertEquals(41.546556, dbSecondStore.getLatitude(), 1e-15);
        Assert.assertEquals(35.345345, dbFirstStore.getLongitude(), 1e-15);
        Assert.assertEquals(35.345345, dbSecondStore.getLongitude(), 1e-15);
        Assert.assertNotEquals(dbFirstStore.getStoreId(), dbSecondStore.getStoreId());
    }
}
