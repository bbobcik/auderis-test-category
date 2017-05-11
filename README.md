# auderis-test-category - Metadata for Java tests

This library provides rich metadata to JUnit4 tests and consists of two main parts:
  * Test metadata annotations
  * Test categories for test classification
   
These parts are explained below in detail.

[![Build Status](https://travis-ci.org/bbobcik/auderis-test-category.svg?branch=master)](https://travis-ci.org/bbobcik/auderis-test-category)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/cz.auderis/auderis-test-category/badge.svg)](https://maven-badges.herokuapp.com/maven-central/cz.auderis/auderis-test-category)


## Artifact dependency declaration

Maven:
```Maven POM
    <dependency>
        <groupId>cz.auderis</groupId>
        <artifactId>auderis-test-category</artifactId>
        <version>1.1.0</version>
        <scope>test</scope>
    </dependency>
```
   
Gradle:
```Gradle
    dependencies {
        compileTest: 'cz.auderis:auderis-test-category:1.1.0'
    }
```


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

```java
    public class NumericTest {
    
        @Test
        @VerifiesIssue( 'JIRA-739' )
        public void shouldPreventOverflowWhenValueIsLarge() throws Exception {
            // ...
        }
     
    }
```


## Test categories

[JUnit framework](http://junit.org) introduced a concept of
[test categorization](https://github.com/junit-team/junit4/wiki/categories) which can be easily exploited
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

For tests that target a specific OS platform, the following tests are available:

  * `PlatformTest` - tests that check platform dependent aspects
    * `LinuxPlatformTest` - tests targeting Linux
    * `WindowsPlatformTest` - tests targeting Windows
    * `OSXPlatformTest` - tests targeting OSX
    * `AndroidPlatformTest` - tests targeting Android

(Notice that generic `PlatformTest` category may be useful for global exclusion of platform-specific
tests from a test run.)

For more information, consult JavaDoc of individual categories (in package `cz.auderis.test.category`).

### Usage

JUnit tests can be tagged either on method level, or globally on test class level.
In the following example, test method `shouldConnectToDatabase` has 3 categories
assigned: `UnstableTest` (from class annotation), `DatabaseTest` (from method
annotation) and `IntegrationTest` (implicit ancestor of the database test category).

```java
    @Category( UnstableTest.class )
    public class SomeTests {
        @Test
        @Category( DatabaseTest.class )
        public void shouldConnectToDatabase() throws Exception {
            // ...
        }
    }
```

## License

The library is licensed under the [Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0).
In short, the software is distributed "as is", without any warranties. Please consult
included file `LICENSE` for details.


## History

* **1.1.0**
  * Categories for platform-oriented tests added

* **1.0.1**
  * Documentation expanded

* **1.0.0**
  * Initial public release
