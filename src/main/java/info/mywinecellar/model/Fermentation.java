/*
 * My-Wine-Cellar, copyright 2022
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 */

package info.mywinecellar.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Fermentation extends BaseEntity implements Comparable<Fermentation> {

    /**
     * Default constructor
     */
    public Fermentation() {
        super();
    }

    /**
     * Fermentation constructor
     *
     * @param days        days
     * @param temperature temperature
     */
    public Fermentation(Byte days, Float temperature) {
        super();
        this.days = days;
        this.temperature = temperature;
    }

    @NotNull
    @Column(name = "days")
    private Byte days;

    @Column(name = "temperature")
    private Float temperature;

    @OneToMany(mappedBy = "fermentation")
    private Set<GrapeComponent> grapes;

    @Override
    public int compareTo(Fermentation m) {
        int result = days.compareTo(m.getDays());

        if (result == 0) {
            return temperature.compareTo(m.getTemperature());
        }
        return result;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Fermentation)) {
            return false;
        }

        return super.equals(o);
    }

    @Override
    public String toString() {
        return "Fermentation(" + id + ")";
    }
}
