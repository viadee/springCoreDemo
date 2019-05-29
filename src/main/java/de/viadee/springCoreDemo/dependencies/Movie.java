package de.viadee.springCoreDemo.dependencies;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.BeanNameAware;

public class Movie implements BeanNameAware {

    private Set<Actor> actors = new HashSet<>();

    private String name;

    public Set<Actor> getActors() {
        return actors;
    }

    public void addActor(final Actor actor) {
        this.actors.add(actor);
    }

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
