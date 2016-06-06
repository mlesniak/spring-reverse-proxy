package com.mlesniak;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Minimal entity to have an example for different SQL update techniques.
 *
 * @author Michael Lesniak (mlesniak@micromata.de)
 */
@Entity
public class Element {
    @Id
    @GeneratedValue
    private String key;

    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
