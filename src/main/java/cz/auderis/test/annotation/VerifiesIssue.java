/*
 * Copyright 2016 Boleslav Bobcik - Auderis
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
package cz.auderis.test.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Denotes that a test class or even a specific test method verifies that the provided issues
 * were correctly resolved. This may be useful in continuous integration environments where
 * a list of existing issues must be "ticked off" in order to allow building a release.
 * <p>
 * Example:
 * <pre>
 *     public class AdditionTest {
 *        {@literal @}Test
 *        {@literal @}VerifiesIssue( "JIRA-0943" )
 *         public void shouldPreventNumericOverflow() throws Exception {
 *             ...
 *         }
 *     }
 * </pre>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface VerifiesIssue {

    /**
     * Defines one or more issue IDs (such as JIRA codes) that pertain to the respective test
     * (or tests, if the annotation is attached to a test class).
     */
    String[] value();

    /**
     * Provides an optional commentary to the relation between the listed issues and the test.
     */
    String comment() default "";

}
