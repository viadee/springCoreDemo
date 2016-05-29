package de.viadee.springCoreDemo.dependencies;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.viadee.springCoreDemo.MyConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(MyConfiguration.class)
public class TestBeanQualification {

    @Autowired(required = false)
    private Movie lordOfTheRings;

    @Autowired(required = false)
    @Qualifier("elijahWood")
    private Actor a;

    @Autowired(required = false)
    @Qualifier("ianMcKellen")
    private Actor b;

    @Test
    public void testBasicSetupWithQualifiers() {
        // Given the bean factory wired all dependencies here
        // The movie should be injected
        assertNotNull("Desired movie is not initialized.", lordOfTheRings);
        // Two different actors should be injected
        assertNotNull("Frodo is missing.", a);
        assertNotNull("Gandalf is missing.", b);
        // Both are part of the movie
        assertTrue("Frodo must be part of the movie.", lordOfTheRings.getActors().contains(a));
        assertTrue("Gandalf must be part of the movie.", lordOfTheRings.getActors().contains(b));
    }
}
