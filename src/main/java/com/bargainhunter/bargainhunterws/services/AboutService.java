package com.bargainhunter.bargainhunterws.services;

import com.bargainhunter.bargainhunterws.models.DTOs.AboutDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AboutService implements IAboutService {
    @Override
    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public AboutDTO about() {
        return new AboutDTO("0.0.3");
    }
}
