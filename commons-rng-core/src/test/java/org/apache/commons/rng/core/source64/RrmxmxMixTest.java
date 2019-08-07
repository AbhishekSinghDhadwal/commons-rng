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

public class RrmxmxMixTest {
    @Test
    public void testReferenceCode() {

        final long[] expectedSequence = {
            0xc04b2f5004c04b5fL, 0xc74bee788f929015L, 0xef3a60d1f0ede139L, 0x05a9f608242787c4L,
            0xfdf635f904cb8343L, 0xd53fd2ea6b8894caL, 0x3f8dbae35a3f3faaL, 0xf5343e0ad7cc8605L,
            0x0c37eb9d4a706944L, 0x34ff14983043e3e3L, 0xd3efcf34dcea7386L, 0xc77ade2c5e20d0f7L,
            0x96544881d5fefa3cL, 0xcb6cdbdb66ea2c56L, 0x46a60805edbf46a5L, 0x96b96e822a9e3e31L,
            0xe1a1f84a0645ad1eL, 0xe0bf3ee9e3962ca7L, 0xfc21e28e1487a398L, 0x1a06be9489ac8badL,
        };
        RandomAssert.assertEquals(expectedSequence, new RrmxmxMix(new long[] {
            0x012de1babb3c4104L, 0xc8161b4202294965L
        }));
    }
}
