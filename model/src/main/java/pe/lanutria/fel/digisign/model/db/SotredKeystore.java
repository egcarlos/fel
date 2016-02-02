/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.lanutria.fel.digisign.model.db;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author carlosecheverria
 */
@Entity
@Table(name = "DS_KEYSTORE")
public class SotredKeystore implements Serializable {

    @Id
    private String identifier;

    @Lob
    @Column(name = "MATERIAL", updatable = false)
    private byte[] keystoreMaterial;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "INSERTED_IN", updatable = false)
    private Date inserted;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "CHKVAL", updatable = false)
    private String checkValue;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.identifier);
        hash = 47 * hash + Arrays.hashCode(this.keystoreMaterial);
        hash = 47 * hash + Objects.hashCode(this.inserted);
        hash = 47 * hash + (this.enabled ? 1 : 0);
        hash = 47 * hash + Objects.hashCode(this.checkValue);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SotredKeystore other = (SotredKeystore) obj;
        if (this.enabled != other.enabled) {
            return false;
        }
        if (!Objects.equals(this.identifier, other.identifier)) {
            return false;
        }
        if (!Objects.equals(this.checkValue, other.checkValue)) {
            return false;
        }
        if (!Arrays.equals(this.keystoreMaterial, other.keystoreMaterial)) {
            return false;
        }
        if (!Objects.equals(this.inserted, other.inserted)) {
            return false;
        }
        return true;
    }

     
    
    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public byte[] getKeystoreMaterial() {
        return keystoreMaterial;
    }

    public void setKeystoreMaterial(byte[] keystoreMaterial) {
        this.keystoreMaterial = keystoreMaterial;
    }

    public Date getInserted() {
        return inserted;
    }

    public void setInserted(Date inserted) {
        this.inserted = inserted;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getCheckValue() {
        return checkValue;
    }

    public void setCheckValue(String checkValue) {
        this.checkValue = checkValue;
    }

}
