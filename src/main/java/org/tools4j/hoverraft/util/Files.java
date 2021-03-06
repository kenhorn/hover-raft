/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2016-2017 hover-raft (tools4j), Marco Terzer
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
package org.tools4j.hoverraft.util;

import net.openhft.chronicle.Chronicle;
import net.openhft.chronicle.ChronicleQueueBuilder;
import net.openhft.chronicle.VanillaChronicle;
import org.agrona.ExpandableArrayBuffer;
import org.tools4j.hoverraft.command.Command;
import org.tools4j.hoverraft.command.CommandLog;
import org.tools4j.hoverraft.transport.chronicle.ChronicleCommandLog;

import java.io.IOException;

/**
 * File names and locations.
 */
public class Files {

    private static final int INITIAL_BUFFER_SIZE = 1024;

    public static final String SYS_PROP_FILE_DIR = "org.tools4j.hoverraft.FileDir";

    public static final String defaultFileDirectory() {
        return System.getProperty("java.util.tmpdir");
    }

    public static final String fileDirectory() {
        return System.getProperty(SYS_PROP_FILE_DIR, defaultFileDirectory());
    }

    public static final String fileName(final int serverId, final String name) {
        return "hover-raft_" + serverId + "_" + name;
    }

    public static final CommandLog commandLog(final int serverId, final String name) throws IOException {
        final String path = Files.fileDirectory();
        final String child = Files.fileName(serverId, name);
        final Chronicle chronicle = ChronicleQueueBuilder.vanilla(path, child).build();
        return new ChronicleCommandLog((VanillaChronicle)chronicle, new ExpandableArrayBuffer(INITIAL_BUFFER_SIZE));
    }
}
