package de.viadee.springCoreDemo.scopes;

import java.util.HashSet;
import java.util.Set;

public class Bush<T> {

    /**
     * A bush can have a set of individual berries.
     */
    private final Set<T> berries;

    /**
     * Bushes an be initialized with an arbitrary number of berries.
     * 
     * @param berryArray
     */
    public Bush(final T... berryArray) {
        this.berries = new HashSet<T>();
        for (final T berry : berryArray) {
            berries.add(berry);
        }
    }

    /**
     * @return All berries on the bush
     */
    public Set<T> getBerries() {
        return berries;
    }
}
