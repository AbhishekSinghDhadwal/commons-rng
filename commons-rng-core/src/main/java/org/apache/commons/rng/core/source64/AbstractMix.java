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

import org.apache.commons.rng.core.util.NumberFactory;

/**
 * This abstract class is a base for the generation of random outputs from various 64 bit mixers.
 *
 * @since 1.3
 */
abstract class AbstractMix extends LongProvider {
    /** Size of the seed array. */
    private static final int SEED_SIZE = 2;

    /** The state of the LCG. */
    private long state;

    /** The gamma of the LCG. */
    private long gamma;

    /**
     * Creates a new instance.
     *
     * @param seed Initial seed.
     * If the length is larger than 2, only the first 2 elements will
     * be used; if smaller, the remaining elements will be automatically set.
     */
    AbstractMix(long[] seed) {
        if (seed.length < SEED_SIZE) {
            final long[] tmp = new long[SEED_SIZE];
            fillState(tmp, seed);
            setSeedInternal(tmp);
        } else {
            setSeedInternal(seed);
        }
    }

    /**
     * Seeds the RNG.
     *
     * @param seed Seed.
     */
    private void setSeedInternal(long[] seed) {
        // Ensure the gamma is odd to provide a maximal period.
        this.gamma = (seed[1] << 1) | 1;
        this.state = seed[0];
    }

    /**
     * Passes the 64-bit state of the generator through a mixer in order to generate a 64 bit output.
     * The transformation function shall vary with respect to different generators.
     *
     * @param input State.
     * @return the output.
     */
    public abstract long mix(long input);

    /** {@inheritDoc} */
    @Override
    public long next() {
        final long x = state;
        state += gamma;
        return mix(x);
    }

    /**
     * A reference gamma generator that may be utilised in order to provide proper
     * constants leading to maximal generator utilisation.
     *
     * @see <a href="https://mostlymangling.blogspot.com/2018/07/on-mixing-functions-in-fast-splittable.html">
     * Source for the gamma function. </a>
     * @param z input.
     * @return Gamma.
     */
    static long mixGamma(long z) {
        // MurmurHash3 mix constants   z = (z ^ (z >>> 33)) * 0xff51afd7ed558ccdL;
        final long y = (z ^ (z >>> 33)) * 0xc4ceb9fe1a85ec53L;
        final long x = (y ^ (y >>> 33)) | 1L; // force to be odd
        final int n = Long.bitCount(x ^ (x >>> 1)); // ensure enough transitions
        return (n < 24) ? x ^ 0xaaaaaaaaaaaaaaaaL : x;
    }

    /** {@inheritDoc} */
    @Override
    protected byte[] getStateInternal() {
        // The gamma is divided by 2 before saving. This transform prevents restoring from
        // a byte state a non-odd gamma that results in a sub-maximal period generator.
        return composeStateInternal(NumberFactory.makeByteArray(
                new long[] {state, gamma >>> 1}),
                super.getStateInternal());
    }

    /** {@inheritDoc} */
    @Override
    protected void setStateInternal(byte[] s) {
        final byte[][] c = splitStateInternal(s, SEED_SIZE * 8);
        final long[] tempseed = NumberFactory.makeLongArray(c[0]);
        state = tempseed[0];
        // Reverse the transform performed during getState to make the gamma odd again.
        gamma = tempseed[1] << 1 | 1;
        super.setStateInternal(c[1]);
    }
}