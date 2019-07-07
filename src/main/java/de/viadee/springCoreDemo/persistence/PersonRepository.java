package de.viadee.springCoreDemo.persistence;

import org.springframework.data.repository.CrudRepository;

/**
 * A token interface that is not explicitly implemented in user code. The spring data framework provides an
 * implementation.
 */
public interface PersonRepository extends CrudRepository<Person, Long> {

}
