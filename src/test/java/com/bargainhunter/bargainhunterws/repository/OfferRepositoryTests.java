package com.bargainhunter.bargainhunterws.repository;

import com.bargainhunter.bargainhunterws.models.Offer;
import com.bargainhunter.bargainhunterws.models.Store;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.util.Calendar;

/**
 * Created by Johnny on 11/9/2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/META-INF/test-context.xml",
        loader = SpringApplicationContextLoader.class)
public class OfferRepositoryTests {
    @Autowired
    IOfferRepository offerRepository;

    @Test
    @Transactional
    public void insertTest(){
        Calendar startDate = Calendar.getInstance();
        startDate.set(2014, Calendar.NOVEMBER, 11);
        Calendar expDate = Calendar.getInstance();
        expDate.set(2014, Calendar.NOVEMBER, 14);

        Store myStore = new Store("Greece","Thessaloniki","Aristotelous",56,"54452",32.5674,28.5653);
        Offer offer = new Offer("Kreas", "-20% mosxarisio", 8, startDate.getTime(), expDate.getTime());
        offer.setStore(myStore);

        offerRepository.save(offer);

        Offer dbOffer = offerRepository.findOne(offer.getOfferId());
        Assert.assertNotNull(dbOffer);
        Assert.assertNotNull(dbOffer.getStore());

        Assert.assertEquals(8, offer.getPrice(),1e-15);
        Assert.assertEquals("Kreas", offer.getTitle());
    }

    @Test
    public void testRepositoryIsNotNull() throws Exception {
        Assert.assertNotNull("The store repository should be not-null.", this.offerRepository);
    }
}
