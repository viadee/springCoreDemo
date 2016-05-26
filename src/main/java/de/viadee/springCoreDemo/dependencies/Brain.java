/**
 * 
 */
package de.viadee.springCoreDemo.dependencies;

public class Brain {

    private boolean awake = false;

    public boolean isAwake() {
        return awake;
    }

    public void wakeUp() {
        this.awake = true;
    }

    public String thinkAbout(final String question) {
        if (awake) {
            return "42";
        } else {
            return "Zzz";
        }
    }

}
