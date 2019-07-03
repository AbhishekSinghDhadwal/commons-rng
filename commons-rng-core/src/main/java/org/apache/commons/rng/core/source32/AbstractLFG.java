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

public abstract class AbstractLFG extends IntProvider {

    /** The short lag.*/
    private int shortlag;
    /** The long lag.*/
    private int longlag;
    /** The word length.*/
    private int w;
    /** Defines the current state.*/
    private int[] state;
    /** Provides current value in array used.*/
    private int i;
    /** Used to mask the output result.*/
    private final int mask;
    /**
     * Creates an instance with the given {@code seed}.
     *
     * @param shortlag The short lag.
     * @param longlag The long lag.
     * @param w Word length.
     * @param seed Initial seed.
     */
    AbstractLFG(int shortlag, int longlag, int w, int[] seed) {
        //Note: Add means to switch length of lags if required.
        longlag = Math.abs(longlag);
        shortlag = Math.abs(shortlag);
        this.shortlag = Math.min(longlag, shortlag);
        this.longlag = Math.max(longlag, shortlag);
        this.w = Math.abs(w);
        state = new int[this.longlag];
        fillState(state, seed);
        mask = (1 << this.w) - 1;
    }

    /**
     * Used to fill the LFG ring {@code state}.
     */
    void fill() {
        // two loops to avoid costly modulo operations
        for (int j = 0; j < shortlag; ++j) {
            state[j] = (state[j] + state[j + (longlag - shortlag)]) & mask; }

        for (int j = shortlag; j < longlag; ++j) {
            state[j] = (state[j] + state[j - shortlag]) & mask; }
        i = 0;
    }

    /**
     * Returns next value of ring as long as i is less than longlag.
     * Else it shall refresh the ring and return the first value.
     * @return state[i++]
     */
    public int next() {
        if (i >= longlag) {
            fill();
        }
        return state[i++]; }

}
