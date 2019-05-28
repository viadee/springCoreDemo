package de.viadee.springCoreDemo.scopes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;

import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import de.viadee.springCoreDemo.MyConfiguration;
import de.viadee.springCoreDemo.SampleController;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyConfiguration.class)
public class TestPrototypeScoping {

    @Autowired(required = false)
    private Bush<Strawberry> bush;

    @Autowired(required = false)
    private List<Strawberry> oneBerryFromEachBeanDeclaration;

    @Autowired
    private SampleController sampleController1;

    @Autowired
    private SampleController sampleController2;

    @Test
    public void testPrototypeBeanInjection() {
        // Given the spring context is fully initialized at this point,

        // when we examine the berries on a strawberry bush
        final Set<Strawberry> berries = bush.getBerries();

        // then
        assertEquals("There should be two berries on the bush.", 2, berries.size());
        // This implies, that there are two instances of Strawberry.
        // Hence, the berries can not be in singleton scope.

        // We receive a new berry each time, a berry is declared as a dependency, if berries are in prototype scope
        assertEquals("There should be only one bean declaration for strawberries.", 1,
                oneBerryFromEachBeanDeclaration.size());

        // Therefore, the sample berry is - again - a different one.
        assertFalse("The sample berry directly injected here can not be on the bush.",
                berries.contains(oneBerryFromEachBeanDeclaration.get(0)));
    }

    @Test
    public void testSingletonBeanInjection() {
        // Given the controller is a singleton as per default
        // When we inject it twice
        // The the same object should arrive
        assertSame("Controller is not in singleton scope.", sampleController1, sampleController2);
    }
}
