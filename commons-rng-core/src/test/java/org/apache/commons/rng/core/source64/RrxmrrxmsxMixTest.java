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

import org.apache.commons.rng.core.RandomAssert;
import org.junit.Test;

public class RrxmrrxmsxMixTest {
    @Test
    public void testReferenceCode() {

        final long[] expectedSequence = {
            0x5537ddb4c9e7f96fL, 0x537fcf93ff1ebe15L, 0xcd8aa9fbac8a9429L, 0x16c07e7e9be51224L,
            0x10e59386a0ea1fc9L, 0xfc3faebf7930d506L, 0x2ced515dc001a00dL, 0xc248a706c29ca758L,
            0x9f526e8e8da3f4d3L, 0x20301b3731a2030cL, 0xc72d472a6fca5cfeL, 0xac9ea8ad9b85a707L,
            0x713b69b2ea45fae4L, 0x472dfda313440176L, 0xaf505d37ed22314bL, 0x3ca8142a817e0c8cL,
            0xc4a1eb54f978aca0L, 0x683a744645f8f0fdL, 0xd0352952aa036dbaL, 0xa9d4faf4bdd3742bL,
        };
        RandomAssert.assertEquals(expectedSequence, new RrxmrrxmsxMix(new long[] {
            0x012de1babb3c4104L, 0xc8161b4202294965L
        }));
    }
}
