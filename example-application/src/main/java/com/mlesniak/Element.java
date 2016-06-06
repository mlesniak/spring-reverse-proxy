package com.mlesniak;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * Minimal entity to have an example for different SQL update techniques.
 *
 * @author Michael Lesniak (mlesniak@micromata.de)
 */
@Entity
public class Element {
    @Id
    private String key;

    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedAt;

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

    public Date getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    @PrePersist
    @PreUpdate
    public void updateTimestamp() {
        modifiedAt = new Date();
    }
}
