package com.bargainhunter.bargainhunterws.services;

import com.bargainhunter.bargainhunterws.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Achilleas Naoumidis on 11/9/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class,
        loader = SpringApplicationContextLoader.class)
public class StoreServiceTest {
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testStoreService() throws Exception {
    }
}
