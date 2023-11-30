/*
 * Copyright © 2019 Dominokit
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.dominokit.pages.client.views.ui;

import java.util.function.Supplier;

import static java.util.Objects.isNull;

/**
 * LazyChild class.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class LazyProvider<T> {

  private T element;
  private final Supplier<T> supplier;

  public static <T> LazyProvider<T> of(Supplier<T> supplier) {
    return new LazyProvider<>(supplier);
  }

  public LazyProvider(Supplier<T> supplier) {
    this.supplier = supplier;
  }

  public T get() {
    if(isNull(element)){
      this.element = supplier.get();
    }
    return element;
  }
}
