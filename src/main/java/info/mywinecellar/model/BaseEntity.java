/*
 * My-Wine-Cellar, copyright 2022
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 */

package info.mywinecellar.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity implements Serializable {

    /**
     * Long ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    /**
     * No args constructor
     */
    public BaseEntity() {
    }

    /**
     * ID
     *
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id
     *
     * @param newValue newValue
     */
    public void setId(Long newValue) {
        if (id != null && !id.equals(newValue)) {
            throw new RuntimeException("Class: " + this.getClass().getName() + ", Id: " + id + ", NewValue" + newValue);
        }
        id = newValue;
    }

    /**
     * Checks to see if this id is new
     *
     * @return true
     */
    public boolean isNew() {
        return id == null;
    }

    @Override
    public int hashCode() {
        return id == null ? super.hashCode() : id.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof BaseEntity)) {
            return false;
        }

        if (this.getClass() != o.getClass()) {
            return false;
        }

        if (id == null) {
            return super.equals(o);
        }

        return id == ((BaseEntity) o).getId();
    }
}
