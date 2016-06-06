package com.mlesniak;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Control which server to use.
 *
 * @author Michael Lesniak (mlesniak@micromata.de)
 */
@RestController
public class ConfigController {
    private static final Logger LOG = LoggerFactory.getLogger(ConfigController.class);

    @Autowired
    private StorageRepository repository;

    @RequestMapping("/")
    public Map<String, String> getTarget() {
        Map<String, String> values = new HashMap<>();
        Iterator<Element> it = repository.findAll().iterator();
        while (it.hasNext()) {
            Element element = it.next();
            values.put(element.getKey(), element.getValue());
        }

        return values;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Map<String, String> setTarget(@RequestBody Map<String, String> updateConfiguration) {
        LOG.info("Updating configuration: {}", updateConfiguration);

        for (Map.Entry<String, String> entry : updateConfiguration.entrySet()) {
            Element element = new Element();
            element.setKey(entry.getKey());
            element.setValue(entry.getValue());
            repository.save(element);
        }

        return getTarget();
    }
}
