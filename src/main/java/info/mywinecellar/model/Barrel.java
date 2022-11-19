/*
 * My-Wine-Cellar, copyright 2022
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 */

package info.mywinecellar.model;

import java.util.Set;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Barrel extends BaseEntity implements Comparable<Barrel> {

    /**
     * Default constructor
     */
    public Barrel() {
        super();
    }

    /**
     * Barrel constructor
     *
     * @param name        name
     * @param description description
     * @param weblink     weblink
     */
    public Barrel(String name, String description, String weblink) {
        super();
        this.name = name;
        this.description = description;
        this.weblink = weblink;
    }

    @NotNull
    @Column(name = "name")
    private String name;

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "description", length = 8192)
    private String description;

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "weblink")
    private String weblink;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "barrel")
    private Set<BarrelComponent> barrelComponents;

    @Override
    public int compareTo(Barrel b) {
        return name.compareTo(b.getName());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Barrel)) {
            return false;
        }

        return super.equals(o);
    }

    @Override
    public String toString() {
        return "Barrel(" + id + ")";
    }
}
