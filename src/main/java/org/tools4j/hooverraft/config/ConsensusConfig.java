/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 hoover-raft (tools4j), Marco Terzer
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.tools4j.hooverraft.config;

import java.util.Optional;

public interface ConsensusConfig {
    long minElectionTimeoutMillis();
    long maxElectionTimeoutMillis();
    Optional<String> ipcMulticastChannel();
    int serverCount();
    ServerConfig serverConfig(int index);
    int sourceCount();
    SourceConfig sourceConfig(int index);
    ThreadingMode threadingMode();

    default ServerConfig serverConfigById(int id) {
        for (int i = 0; i < serverCount(); i++) {
            final ServerConfig config = serverConfig(i);
            if (config.id() == id) {
                return config;
            }
        }
        return null;
    }

    default SourceConfig sourceConfigById(int id) {
        for (int i = 0; i < sourceCount(); i++) {
            final SourceConfig config = sourceConfig(i);
            if (config.id() == id) {
                return config;
            }
        }
        return null;
    }
}
