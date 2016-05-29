/**
 * 
 */
package de.viadee.springCoreDemo.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.viadee.springCoreDemo.MyConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(MyConfiguration.class)
public class TestAutoconfiguredPersistenceFeatures {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void testPeristenceAutoconfig() {
        // Given a the autoconfig features of spring boot
        // and the h2-jar on the classpath

        // a datasource should be configured and accessible via a template
        assertNotNull(dataSource);
        assertNotNull(jdbcTemplate);
    }

    @Test
    public void testSchemaAutoConfig() {
        // Given a the autoconfig features of spring boot
        // and the h2-jar on the classpath

        // the Person-Entity should be found and an empty table should be created
        // at this point
        assertEquals("something went wrong with hbm2dd and the creation of the person table.", Integer.valueOf(0),
                jdbcTemplate.queryForObject("SELECT count(*) FROM person", Integer.class));
    }

    @Test
    public void testJPARepositoryOperations() {
        // Given the automatically configured data source and empty table and the automaticaly generated repository
        // implementation

        // When we insert a new person
        personRepository.save(new Person("Elijah", "Wood"));

        // The total number of persons in the database should be one
        assertEquals("There should be one person in the db.", Long.valueOf(1), Long.valueOf(personRepository.count()));

        // The same person we saved should be read from the database
        final Iterable<Person> allPersons = personRepository.findAll();
        final Person firstPerson = allPersons.iterator().next();
        assertEquals("We got the wrong person back from the database.", "Wood", firstPerson.getLastName());
    }

    @Test
    public void testIndependencyOfTests() {
        // Given the transactional execution of other tests
        // When we query all persons here
        // Then the number of entries in the person table should be zero
        assertEquals("There should be one person in the db.", Long.valueOf(0), Long.valueOf(personRepository.count()));
    }

    @Test
    public void testFurtherEntities() {
        // The Movie class is a typical entity class
        // Provide some movies in the database to query here

        assertNotEquals("This database knows nothing about movies.", Integer.valueOf(0),
                jdbcTemplate.queryForObject("SELECT count(*) FROM movie", Integer.class));
    }
}
