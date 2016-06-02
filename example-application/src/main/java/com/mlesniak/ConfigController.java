package com.mlesniak;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Control which server to use.
 *
 * @author Michael Lesniak (mlesniak@micromata.de)
 */
@RestController
public class ConfigController {
    private static final Logger LOG = LoggerFactory.getLogger(ConfigController.class);

    private Map<String, String> configuration = new HashMap<>();

    @RequestMapping("/")
    public Map<String, String> getTarget() {
        return configuration;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Map<String, String> setTarget(@RequestBody Map<String, String> updateConfiguration) {
        LOG.info("Updating configuration: {}", updateConfiguration);
        configuration.putAll(updateConfiguration);
        return configuration;
    }
}
