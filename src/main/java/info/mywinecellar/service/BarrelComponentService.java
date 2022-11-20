/*
 * My-Wine-Cellar, copyright 2022
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 */

package info.mywinecellar.service;

import info.mywinecellar.model.BarrelComponent;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class BarrelComponentService extends AbstractService<BarrelComponent> {

    /**
     * Constructor
     */
    public BarrelComponentService() {
        super(BarrelComponent.class);
    }

    /**
     * Save all BarrelComponents
     * @param barrels barrels
     */
    @Transactional
    public void saveAll(List<BarrelComponent> barrels) {
        try {
            barrels.forEach(barrel -> em.persist(barrel));
        } catch (Exception e) {
            System.out.println(barrels.getClass());
            System.out.println(e.getMessage());
            e.printStackTrace(System.out);
        }
    }
}
