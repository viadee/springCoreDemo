package de.viadee.springCoreDemo.lazyness;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import de.viadee.springCoreDemo.MyConfiguration;

/**
 * Test lazy loading of beans.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyConfiguration.class)
public class TestLazyClass { // NOPMD

    @Test
    public void testLazyInitialization() { // NOPMD
        // Given the spring context is fully initialized at this point,

        // when we examine the number of instances of the lazy class
        final long instances = LazyClass.instanceCounter;

        // then
        assertEquals("There should be no instances of the lazy class.", 0L, instances);
        // Since we do not need an instance right now, since no bean depends on it,
        // although a bean definition is part of the configuration
    }

}
