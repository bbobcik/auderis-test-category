# auderis-test-categories

This library provides rich metadata to JUnit tests and consists of two main parts:
  * Test metadata annotations
  * Test categories for test classification
   
These parts are explained below in detail.

Artifact dependency declaration:

    Maven:
    <dependency>
        <groupId>cz.auderis</groupId>
        <artifactId>auderis-test-category</artifactId>
        <version>1.0.1</version>
        <scope>test</scope>
    </dependency>
    
    Gradle:
    dependencies {
        compileTest: 'cz.auderis:auderis-test-category:1.0.1'
    }



## Metadata annotations

### `@VerifiesIssue` - binding issues with tests

Often a release version of a software product is characterized by a list of issues (bugs, feature requests etc.) that
were resolved since the last release. These issues are typically registered in a issue tracking system and in most
cases, they are assigned unique IDs (for example, `JIRA-739`).

In order to automatically validate the correctness of a release candidate, we need to make sure that each issue
is processed and its result (a bug fix or new code) is testable. Considering the normal workflow (an issue is
opened and assigned to a developer, who then resolves it), we feel that the most convenient place to define
the issue-test relation is through the use of Java annotation at the test source level.

Example:

    public class NumericTest {
    
        @Test
        @VerifiesIssue( 'JIRA-739' )
        public void shouldPreventOverflowWhenValueIsLarge() throws Exception {
            ...
        }
     
    }



## Test categories

[JUnit framework](http://junit.org) introduced a concept of test categorization which can be easily exploited
by build tools and/or test runners. Categories are expressed in terms of Java classes (allowing inheritance
relationships between categories). This library provides a rich set of generic, often needed categories,
where the ones with the widest scope being:

  * `UnitTest` for basic unit testing
  * `AcceptanceTest` - important QA tests that correspond with software requirements
  * `SanityTest` - tests that verify the build environment
    * `SmokeTest` - tests designed to reveal simple but severe defects
  * `RegressionTest` - tests that check for bugs introduced by code changes during QA phase
  * `PerformanceTest` - tests that verify performance aspects of code

Among other provided categories are those that declare certain properties of a test, such as its relationship
to a certain subsystem, its expected performance or test maturity:

  * `IntegrationTest` - for tests that verify multi-component interactions
    * `DatabaseTest` - tests of interactions between code and databases
    * `NetworkTest` - tests oriented at network communications
  * `UserInterfaceTest` - tests targeted at user interface
  * `SecurityTest` - tests that validate security properties
  * `SlowTest` - tests that can run for a significant time
    * `VerySlowTest` - tests that can run for a very long time
  * `DetailedTest` - tests of inner code behaviour that are not necessary for normal test runs
  * `UnstableTest` - incomplete or misbehaving tests

For more information, consult JavaDoc of individual categories (in package `cz.auderis.test.category`).
