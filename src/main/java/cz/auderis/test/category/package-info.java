/*
 * Copyright 2015 Boleslav Bobcik - Auderis
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * Defines marker interfaces that serve as JUnit category tags. The following tag interfaces are available:
 * <ul>
 * <li><b>Test operation mode</b>
 * <ul>
 * <li>{@link cz.auderis.test.category.UnitTest} - for basic unit tests</li>
 * <li>{@link cz.auderis.test.category.IntegrationTest} - for tests that verify multi-component
 * interactions
 * <ul>
 * <li>{@link cz.auderis.test.category.DatabaseTest} - tests of interactions between code and databases</li>
 * <li>{@link cz.auderis.test.category.NetworkTest} - tests oriented at network communications</li>
 * </ul>
 * </li>
 * <li>{@link cz.auderis.test.category.SanityTest} - tests that verify the build environment</li>
 * <li>{@link cz.auderis.test.category.RegressionTest} - tests that check for bugs introduced
 * by code changes during QA phase</li>
 * <li>{@link cz.auderis.test.category.PerformanceTest} - tests that verify performance aspects of code</li>
 * </ul>
 * <li><b>Other test aspects</b>
 * <ul>
 * <li>{@link cz.auderis.test.category.UserInterfaceTest} - tests targeted at user interface</li>
 * <li>{@link cz.auderis.test.category.DetailedTest} - tests of inner code behaviour that are
 * not necessary for normal test runs</li>
 * <li>{@link cz.auderis.test.category.UnstableTest} - incomplete or misbehaving tests</li>
 * <li>{@link cz.auderis.test.category.SlowTest} - tests that can run for a significant time
 * <ul>
 * <li>{@link cz.auderis.test.category.VerySlowTest} - tests that can run for a very long time</li>
 * </ul>
 * </li>
 * </ul>
 * </li>
 * </ul>
 */
package cz.auderis.test.category;