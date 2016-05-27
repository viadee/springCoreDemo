/**
 * 
 */
package de.viadee.springCoreDemo.scopes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.viadee.springCoreDemo.MyConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(MyConfiguration.class)
public class TestPrototypeScoping {

    @Autowired
    Bush<Strawberry> bush;

    @Autowired
    List<Strawberry> oneBerryFromEachBeanDeclaration;

    @Test
    public void testPrototypeBeanInjection() {
        // Given the spring context is fully initialized at this point,

        // when we examine the berries on a strawberry bush
        final Set<Strawberry> berries = bush.getBerries();

        // then
        assertEquals("there should be two berries on the bush.", 2, berries.size());
        // This implies, that there are two instances of Strawberry.
        // Hence, the berries can not be in singleton scope.

        // We receive a new berry each time, a berry is declared as a dependency, if berries are in prototype scope
        assertEquals("there should be only one bean declaration for strawberries.", 1,
                oneBerryFromEachBeanDeclaration.size());

        // Therefore, the sample berry is - again - a different one.
        assertFalse("the sample berry directly injected here can not be on the bush.",
                berries.contains(oneBerryFromEachBeanDeclaration.get(0)));
    }

}
