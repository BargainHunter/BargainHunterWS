package com.bargainhunter.bargainhunterws.repository;

import com.bargainhunter.bargainhunterws.Application;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Tommy on 11/9/2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class,
        loader = SpringApplicationContextLoader.class)
public class StoreRepositoryTests {
    @Autowired
    IStoreRepository storeRepository;

    @Test
    public void testStoreRepositoryEntriesCount() throws Exception {
        Assert.assertEquals(5, storeRepository.findAll().size());
    }

    @Test
    public void testRepositoryIsNotNull() throws Exception {
        Assert.assertNotNull("The store repository should be not-null.", this.storeRepository);
    }
}
