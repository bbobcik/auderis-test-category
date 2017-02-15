auderis-test-categories
=======================

Better classification of JUnit tests by means of
[categories](https://github.com/junit-team/junit4/wiki/categories).

The category mechanism allows easy and coherent selection of subset of tests
that are scheduled for a test session run. Despite being still labeled as
experimental JUnit feature, categories are supported by many build frameworks
(Maven, Gradle) as well as IDEs, significantly increasing their usefulness.


## Available categories

This tiny library defines a hierarchy of test categories in the form of marker
interfaces. The following sections describe available categories. Notice the
hierarchical relationships - for example, tagging a test with `DatabaseTest`
category implies that this test has `IntegrationTest` category assigned as well. 

### Test operation mode
* `UnitTest` - for basic unit tests
* `IntegrationTest` - for tests that verify multi-component interactions
  * `DatabaseTest` - tests of interactions between code and databases
  * `NetworkTest` - tests oriented at network communications
* `SanityTest` - tests that verify the build environment
* `RegressionTest` - tests that check for bugs introduced by code changes during
  QA phase
* `PerformanceTest` - tests that verify performance aspects of code

### Platform specific tests
* `PlatformTest` - tests that check platform dependent aspects
  * `LinuxPlatformTest` - tests targeting Linux
  * `WindowsPlatformTest` - tests targeting Windows
  * `OSXPlatformTest` - tests targeting OSX
  * `AndroidPlatformTest` - tests targeting Android

### Other test aspects
* `UserInterfaceTest` - tests targeted at user interface
* `DetailedTest` - tests of inner code behaviour that are not necessary for normal
  test runs
* `UnstableTest` - incomplete or misbehaving tests
* `SlowTest` - tests that can run for a significant time
  * `VerySlowTest` - tests that can run for a very long time


## Usage

JUnit tests can be tagged either on method level, or globally on test class level.
In the following example, test method `shouldConnectToDatabase` has 3 categories
assigned: `UnstableTest` (from class annotation), `DatabaseTest` (from method
annotation) and `IntegrationTest` (implicit ancestor of the database test category).

    @Category( UnstableTest.class )
    public class SomeTests {
        @Test
        @Category( DatabaseTest.class )
        public void shouldConnectToDatabase() throws Exception {
            ...
        }
    }


## History

### 1.0.1
* Documentation expanded
* Categories for platform-oriented tests added

### 1.0.0
* Initial public release
