/**
 * 
 */
package de.viadee.springCoreDemo.lazyness;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.viadee.springCoreDemo.MyConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(MyConfiguration.class)
public class TestLazyClass {

    @Test
    public void testLazyInitialization() {
        // Given the spring context is fully initialized at this point,

        // when we examine the number of instances of the lazy class
        final long instances = LazyClass.instanceCounter;

        // then
        assertEquals("there should be no instances of the lazy class.", 0L, instances);
        // Since we do not need an instance right now, since no bean depends on it,
        // although a bean definition is part of the configuration
    }

}
