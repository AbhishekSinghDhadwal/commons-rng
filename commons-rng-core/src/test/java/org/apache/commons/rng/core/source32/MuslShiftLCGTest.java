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

import org.apache.commons.rng.core.RandomAssert;
import org.junit.Test;

public class MuslShiftLCGTest {
    @Test
    public void testReferenceCode() {
        final int[] expectedSequence = {
            0xf41850d2, 0x41097a8f, 0x986e0448, 0x84dab95b,
            0x1e66dea8, 0x1eb878c8, 0x9891ab76, 0x5881236e,
            0x29372b00, 0xc9d204aa, 0x8e5c9bd7, 0xd10bd016,
            0xd831ed20, 0xe5173925, 0xed0d31e9, 0xd92ebac6,
            0x069266bd, 0xa2a63f76, 0x2ed3003f, 0xf7cb7352,
            0x0dae5d37, 0x5ad54224, 0xcebb1933, 0x3a7599f4,
            0x4e6eeaf9, 0xfb801a5e, 0xe05d5572, 0x55f1641a,
            0xe6c8090c, 0xc8e5b5a1, 0x4488e426, 0x2fedd0df,
            0xa669f5f9, 0xd7073f0a, 0xc1fb1f3c, 0xa8f30730,
            0x7bbf4adc, 0xa2efb9d7, 0x889a8094, 0x20e50ff7,
        };

        RandomAssert.assertEquals(expectedSequence, new MuslShiftLCG(0x12DE1BAL));
    }
}

