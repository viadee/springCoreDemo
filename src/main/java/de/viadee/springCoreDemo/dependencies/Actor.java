/**
 * 
 */
package de.viadee.springCoreDemo.dependencies;

import org.springframework.beans.factory.BeanNameAware;

public class Actor implements BeanNameAware {

    private String name;

    public String getName() {
        return name;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.beans.factory.BeanNameAware#setBeanName(java.lang.String)
     */
    @Override
    public void setBeanName(final String name) {
        this.name = name;
    }
}
