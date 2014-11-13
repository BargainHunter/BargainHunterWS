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
    public void testName() throws Exception {
        Store store = new Store("Greece", "Serres", "Edessis", 18, "62100", 41.546556, 35.345345);
        storeRepository.save(store);

        Store dbStore = storeRepository.findOne(store.getStoreId());

    }


}
