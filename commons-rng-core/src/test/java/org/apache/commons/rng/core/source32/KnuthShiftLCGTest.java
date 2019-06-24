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

public class KnuthShiftLCGTest {
    @Test
    public void testReferenceCode() {
        final int[] expectedSequence = {
            0x081dcc51, 0x02c07473, 0x72b2ef9a, 0x1fdaddfe,
            0xb998fa58, 0x7ddc9cfb, 0x8bd4e132, 0x19171b84,
            0x54a62cea, 0x909ba579, 0xc47967ce, 0xa5bb65bb,
            0x302dc2ee, 0x8d5ca474, 0x2de54960, 0x0e482b06,
            0xff13a177, 0x27ff441f, 0x58347be0, 0xeadac791,
            0x7bb1a368, 0xaaf57be9, 0x02d6d17b, 0x124d4d56,
            0x033ad2af, 0xc1346a10, 0x096fc2a5, 0x57551b32,
            0xed7e940b, 0x72b293f9, 0x55b79d0e, 0x063ceb28,
            0x81c44bd2, 0x8e159074, 0x9976835e, 0xb06173ad,
            0xf51ffac8, 0xdb11245d, 0x1391baa7, 0xc7ce971d,
        };

        RandomAssert.assertEquals(expectedSequence, new KnuthShiftLCG(0x12DE1B9L));
    }
}

