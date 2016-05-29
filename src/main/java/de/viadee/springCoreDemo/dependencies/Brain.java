
package de.viadee.springCoreDemo.dependencies;

/**
 * This is a sample object that can perform sophisticated philosophy operations, as long as it is initialized properly.
 */
public class Brain {

    private boolean awake;

    public boolean isAwake() {
        return awake;
    }

    public void wakeUp() {
        this.awake = true;
    }

    public String thinkAbout(final String question) {
        String result = "Zzz";
        if (awake) {
            result = "42";
        }
        return result;
    }

}
