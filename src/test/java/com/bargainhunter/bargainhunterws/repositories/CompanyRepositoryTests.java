package com.bargainhunter.bargainhunterws.repositories;

import com.bargainhunter.bargainhunterws.models.entities.Company;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

/**
 * Created by Achilleas Naoumidis on 11/9/2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/testContext.xml",
        loader = SpringApplicationContextLoader.class)
public class CompanyRepositoryTests {
    @Autowired
    ICompanyRepository companyRepository;

    @Test
    public void testRepositoryIsNotNull() throws Exception {
        Assert.assertNotNull("The store repositories should be not-null.", this.companyRepository);
    }

    @Test
    @Transactional
    public void insertStoreToRepositoryTest() throws Exception {
        Company company = new Company("Masoutis", "Greece", "Athens", "Venizelou", "35", "12345");
        companyRepository.save(company);

        Company dbCompany = companyRepository.getOne(company.getCompanyId());

        Assert.assertNotNull(dbCompany);
        Assert.assertEquals("Greece", dbCompany.getCountry());
        Assert.assertEquals("Athens", dbCompany.getCity());
        Assert.assertEquals("35", dbCompany.getAddressNo());
        Assert.assertEquals("12345", dbCompany.getZip());
    }
}
