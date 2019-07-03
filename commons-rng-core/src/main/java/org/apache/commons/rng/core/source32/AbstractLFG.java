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
    private int short_lag;
    /** The long lag.*/
    private int long_lag;
    /** The word length.*/
    private int w;
    /** Defines the current state.*/
    private int state[];
    /** Provides current value in array used.*/
    private int i;

    /**
     * Creates an instance with the given {@code seed}.
     *
     * @param short_lag The short lag.
     * @param long_lag The long lag.
     * @param w Word length.
     * @param seed Initial seed.
     */
    AbstractLFG(int short_lag, int long_lag, int w, int[] seed) {
        //Note: Add means to switch length of lags if required.
        this.short_lag = short_lag;
        this.long_lag = long_lag;
        this.w = w;
        state = new int[this.long_lag];
        fillState(state, seed);
    }

    /**
     * Used to fill the LFG ring {@code state}.
     */
    void fill(){
        // two loops to avoid costly modulo operations
        {
            for(int j = 0; j < short_lag; ++j) {
                state[j] = (state[j] + state[j+(long_lag-short_lag)]) & w;}
        }
        for(int j = short_lag; j < long_lag; ++j) {
            state[j] = (state[j] + state[j-short_lag]) & w;}
        i = 0;
    }

    public int next()
    {
        if(i >= long_lag){
            fill();}
        return state[i++];
    }

    /* Make two implementations, one having pre filling taking place,
    *  and the other with filling performed simultaneously.
    */
}
