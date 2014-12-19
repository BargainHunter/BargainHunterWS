package com.bargainhunter.bargainhunterws.services;

import com.bargainhunter.bargainhunterws.models.DTOs.AboutDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@RestController
public class AboutService implements IAboutService {
    @Override
    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public AboutDTO about() {
        Properties properties = new Properties();
        InputStream inputStream = getClass().getResourceAsStream("/project.properties");

        AboutDTO aboutDTO = new AboutDTO();

        try {
            properties.load(inputStream);
            inputStream.close();
        } catch (IOException e) {
            // Do nothing...
        } finally {
            aboutDTO.setName(properties.getProperty("project.name", "BargainHunterWS"));
            aboutDTO.setVersion(properties.getProperty("project.version", ""));
            aboutDTO.setApiVersion(properties.getProperty("api.version", ""));
        }

        return aboutDTO;
    }
}
