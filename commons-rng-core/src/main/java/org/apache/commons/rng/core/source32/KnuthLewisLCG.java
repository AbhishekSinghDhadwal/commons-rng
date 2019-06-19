/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.commons.rng.core.source32;

/**
 * This class implements an LCG based on the constants attained from
 * <a href="https://e-maxx.ru/bookz/files/numerical_recipes.pdf">
 * Numerical Recipes</a> as displayed in
 * <a href="https://en.wikipedia.org/wiki/Linear_congruential_generator#Parameters_in_common_use">
 * Wikipedia</a>.
 *
 * @since NOT RELEASED YET
 */

public class KnuthLewisLCG extends AbstractLCG {

    /**
     * Creates a new random number generator.
     *
     * @param seed Initial seed.
     */
    public KnuthLewisLCG(Integer seed) {

        super(1664525, 1013904223, 4294967296L, seed);

    }

}
