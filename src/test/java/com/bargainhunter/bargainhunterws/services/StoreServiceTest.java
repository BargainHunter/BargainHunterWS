package com.bargainhunter.bargainhunterws.services;

import com.bargainhunter.bargainhunterws.repository.StoreRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Achilleas Naoumidis on 11/9/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/application-context.xml",
        loader = SpringApplicationContextLoader.class)
public class StoreServiceTest {
    @Autowired
    StoreRepository storeRepository;

    @Before
    public void setUp() throws Exception {
//        List<Store> stores = new ArrayList<>();
//        stores.add(new Store("Greece", "Serres", "Komninon", 1, "62123", 42.123456, 21.32155));
//        stores.add(new Store("Greece", "Serres", "Irakleias", 2, "62123", 42.323456, 21.12155));
//
//        storeRepository.save(stores);
    }

    @After
    public void tearDown() throws Exception {
        storeRepository.deleteAll();
    }

    @Test
    public void testGetAllStores() throws Exception {
    }
}
