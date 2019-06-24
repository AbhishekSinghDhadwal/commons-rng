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
 * This class implements an LCG based on the constants utilised by
 * the <a href="https://www.musl-libc.org/"> Musl C Standard Library </a>
 * as displayed in
 * <a href="https://en.wikipedia.org/wiki/Linear_congruential_generator#Parameters_in_common_use">
 * Wikipedia</a>.
 *
 * @since NOT RELEASED YET
 */

public class MuslShiftLCG extends AbstractShift32LCG {

    /**
     * Creates a new random number generator.
     *
     * @param seed Initial seed.
     */
    public MuslShiftLCG(Long seed) {
        super(6364136223846793005L, 1, seed);
    }

}
