package de.viadee.springCoreDemo.lazyness;

/**
 * A lazy class that does nothing besides tracking the number of existing instances.
 */
public class LazyClass {

    public static long instanceCounter;

    public LazyClass() {
        instanceCounter++;
    }

}
