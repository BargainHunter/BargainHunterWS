package com.bargainhunter.bargainhunterws.repositories;

import com.bargainhunter.bargainhunterws.models.entities.Company;
import com.bargainhunter.bargainhunterws.models.entities.Offer;
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

    @Autowired
    IStoreRepository storeRepository;

    @Autowired
    ICompanyRepository companyRepository;

    @Test
    @Transactional
    public void insertTest() {
        Company company = new Company("Masoutis", "Greece", "Athens", "Venizelou", "35", "12345");
        companyRepository.save(company);

        Calendar startDate = Calendar.getInstance();
        startDate.set(2014, Calendar.NOVEMBER, 11);
        Calendar expDate = Calendar.getInstance();
        expDate.set(2014, Calendar.NOVEMBER, 14);

        Offer offer = new Offer("Kreas", "-20% mosxarisio", 8, startDate.getTime(), expDate.getTime(), company);
        offerRepository.save(offer);

        Offer dbOffer = offerRepository.findOne(offer.getOfferId());
        Assert.assertNotNull(dbOffer);
        Assert.assertNotNull(dbOffer.getCompany());

        Assert.assertEquals(8, offer.getPrice(),1e-15);
        Assert.assertEquals("Kreas", offer.getTitle());
    }

    @Test
    public void testRepositoryIsNotNull() throws Exception {
        Assert.assertNotNull("The store repositories should be not-null.", this.offerRepository);
    }
}
