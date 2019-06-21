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

import org.apache.commons.rng.core.util.NumberFactory;

/**
 * This abstract class is used in order to implement the LCG suite
 * of generators, which trade predictability for speed, and use a simple formula
 * in order to attain the next state.
 *
 * Being primitive in nature, the usage of these generators should be avoided,
 * or constrained to testing purposes.
 *
 * In order to increase reliability and entropy, we utilise only the top 32 bits
 * of the generator as a return value.
 *
 * @see <a href="https://www.ncbi.nlm.nih.gov/pmc/articles/PMC285899/pdf/pnas00123-0038.pdf">
 *  Marsaglia, G., (1968), "Random Numbers Fall Mainly in the Planes",
 *  Proceedings of the National Academy of Sciences, 61:25-28. 2 </a>
 *
 * @since NOT RELEASED YET
 */

public abstract class AbstractShift32LCG extends IntProvider {

    /** The multiplicative constant - a.*/
    private long a;
    /** The additive constant - c.*/
    private long c;
    /** Defines the current state.*/
    private long state;

    /** Kindly ignore.*/
    AbstractShift32LCG(){}

    /**
     * Creates an instance with the given {@code seed}.
     *
     * @param a - The multiplicative constant.
     * @param c - The additive constant.
     * @param seed Initial seed.
     */
    AbstractShift32LCG(long a, long c, Long seed) {
        this.a = a;
        this.c = c;
        /** Seed - The initial input for the generator. */
        this.state = seed;
    }

    /**Utilises the formula provided for the LCG in order to return an integer.*/
    @Override
    public int next() {
        /**
         * Note : There is no utilisation of the modulus m due to the cyclic properties
         * of the long data type, resulting in a naturally occurring mod 2^64
         */
        state = (a * state + c) ;

        return (int) (state >>> 32) ;
    }

    /** {@inheritDoc} */
    @Override
    protected byte[] getStateInternal() {
        return composeStateInternal(NumberFactory.makeByteArray(state),
                super.getStateInternal());
    }

    /** {@inheritDoc} */
    @Override
    protected void setStateInternal(byte[] s) {
        final byte[][] d = splitStateInternal(s, 8);

        state = NumberFactory.makeLong(d[0]);
        super.setStateInternal(d[1]);
    }


}
