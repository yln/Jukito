/**
 * Copyright 2011 ArcBees Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package org.jukito;

import com.google.inject.Module;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation can be used on a test class together with
 * {@code @RunWith(JukitoRunner.class)} to use the bindings contained
 * in the specified modules for the test.
 * <p/>
 * Example:
 * <pre>
 * {@literal @}RunWith(JukitoRunner.class)
 * {@literal @}UseModules({ FooModule.class, BarModule.class}
 * public class MyTest {
 *   {@literal @}Test
 *   public void someTest(TypeBoundInFooModule a, TypeBoundInBarModule b) {
 *   }
 * }</pre>
 * 
 * The example is equivalent to the following <i>inner static module</i>
 * approach.
 * <pre>
 * {@literal @}RunWith(JukitoRunner.class)
 * public class MyTest {
 *   static class Module extends JukitoModule {
 *     {@literal @}Override
 *     protected void configureTest() {
 *       install(new FooModule());
 *       install(new BarModule());
 *     }
 *   }
 *   // Test methods
 * }</pre>
 * 
 * @author Julian Lettner
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface UseModules {
  Class<? extends Module>[] value();
}
