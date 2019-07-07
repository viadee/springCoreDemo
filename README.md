Purpose
=======
This is an introductory example into Spring Core and dependency injection, including e.g. simple REST-style services.
It contains a number of unit tests that, in the sense of test-driven development, currently fail. They can, however, easily
be fixed by extending the Spring configuration, which we plan to do in a university workshop at Münster, Germany.

Requirements
============
- Java 8+ and an understanding of the java language and basic patterns such as the singleton and the factory pattern
- Maven 3+ or an IDE that includes appropriate support for maven builds

Rules and hints
===============
- You do not need to change the tests to make them pass
- Spring Java-Config only, no XML required
- Autowired dependencies are acceptable only in test classes
- Prefer centralised constructor injection over setter-injection or annotation based DI configurations
- All tests can be started (and passed) independently
- Tests may not interfere with each other
- Do not access the bean factory or context classes directly (i.e. using anything along the lines of a getBean(..)-Statement is prohibited)

License
=======
To the extent possible under law, Frank Köhne (viadee Unternehmensberatung GmbH) has waived all copyright and related or neighboring rights to the springCoreDemo published here.
For more information see http://creativecommons.org/publicdomain/zero/1.0/
