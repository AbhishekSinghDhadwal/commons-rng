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

public class KnuthLewisLCGTest {
    @Test
    public void testReferenceCode() {
        final int[] expectedSequence = {
                0x3c6ef35f, 0x47502932, 0xd1ccf6e9, 0xaaf95334,
                0x6252e503, 0x9f2ec686, 0x57fe6c2d, 0xa3d95fa8,
                0x81fdbee7, 0x94f0af1a,
        };

        RandomAssert.assertEquals(expectedSequence, new KnuthLewisLCG(0));
    }
}

