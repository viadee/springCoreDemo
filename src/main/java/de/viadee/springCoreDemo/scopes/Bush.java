package de.viadee.springCoreDemo.scopes;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

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
    @SafeVarargs
    public Bush(final T... berryArray) {
        this.berries = Arrays.stream(berryArray).collect(Collectors.toSet());
    }

    /**
     * @return All berries on the bush
     */
    public Set<T> getBerries() {
        return berries;
    }
}
