/**
 * 
 */
package de.viadee.springCoreDemo;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(MyConfiguration.class)
public class BasicDependenciesTest {

    @Autowired
    String hey;

    @Test
    public void test() {
        fail(hey);
    }

}
