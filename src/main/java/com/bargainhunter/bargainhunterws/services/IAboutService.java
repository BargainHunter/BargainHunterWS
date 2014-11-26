package com.bargainhunter.bargainhunterws.services;

import com.bargainhunter.bargainhunterws.models.About;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Achilleas Naoumidis on 11/26/14.
 */
public interface IAboutService {
    @RequestMapping(value = "/about", method = RequestMethod.GET)
    About about();
}
