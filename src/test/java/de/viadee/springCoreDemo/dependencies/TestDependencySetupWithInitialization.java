/**
 * 
 */
package de.viadee.springCoreDemo.dependencies;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.viadee.springCoreDemo.MyConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(MyConfiguration.class)
public class TestDependencySetupWithInitialization {

    @Autowired
    private AnsweringService answeringService;

    @Autowired
    private Brain brain;

    @Test
    public void testSettingUpADependency() {
        // Given an initialized spring context
        // when an answeringService is declared as a bean,
        // then it should be injected here
        assertNotNull("there should be an answeringService injected.", answeringService);
    }

    @Test
    public void testTransitiveDependency() {
        // Given we have an answeringService injected
        // when the bean factory created it,
        // then its own dependency should have been injected
        assertNotNull("the answering service needs a brain to work", answeringService.getBrain());
    }

    @Test
    public void testSingletonProperty() {
        // Given brain is defined as a singleton bean (default)
        // when we inject it here again,
        // then we should receive the identical object
        assertTrue("the brain is not defined as a singleton", answeringService.getBrain() == this.brain);
    }

    @Test
    public void testBeanInitialization() {
        // Given brain is initialized by the bean factory
        // when we inspect it after injection
        // then it should be awake
        assertTrue("the brain is not awake, it should have been initialized through spriong configuration means",
                this.brain.isAwake());
    }

    @Test
    public void testUsingTheService() {
        // Given the brain is awake
        // when we ask the service for an answer
        final String answer = answeringService.answerQuestion("Life, the universe and everything");

        // then it should return 42
        assertEquals("the answer is wrong - maybe the brain is not awake?", "42", answer);
    }

}
