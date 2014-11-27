package com.bargainhunter.bargainhunterws.services;

import com.bargainhunter.bargainhunterws.models.About;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Achilleas Naoumidis on 11/26/14.
 */
@RestController
public class AboutService implements IAboutService {
    @Override
    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public About about() {
        return new About("0.0.3");
    }
}
