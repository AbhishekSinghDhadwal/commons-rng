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
package org.apache.commons.rng.core.source64;

/**
 * A mixer based on the constants researched by Pelle Evensen with the design goal
 * of rendering random-looking output sequences with inputs of low entropy data.
 * It is an intermediate improvement over RrmxmxMix, although slightly slower,
 * doing 2 rotations instead of the shift in the middle of its predecessor.
 *
 * @see <a href="http://mostlymangling.blogspot.com/2019/01/better-stronger-mixer-and-test-procedure.html">
 * Original source code by Pelle Evensen</a>
 *
 * @since 1.3
 */
public class RrxmrrxmsxMix extends AbstractMix {
    /**
     * Creates a new instance.
     *
     * @param seed Initial seed.
     * If the length is larger than 2, only the first 2 elements will
     * be used; if smaller, the remaining elements will be automatically set.
     */
    public RrxmrrxmsxMix(long[] seed) {
        super(seed);
    }

    /** {@inheritDoc} */
    @Override
    public long mix(long input) {
        final long input1 = input ^ (Long.rotateRight(input, 25) ^ Long.rotateRight(input, 50));
        final long input2 = input1 * 0xA24BAED4963EE407L;
        final long input3 = input2 ^ (Long.rotateRight(input, 24) ^ Long.rotateRight(input, 49));
        final long input4 = input3 * 0x9FB21C651E98DF25L;
        return input4 ^ input4 >>> 28;
    }
}
