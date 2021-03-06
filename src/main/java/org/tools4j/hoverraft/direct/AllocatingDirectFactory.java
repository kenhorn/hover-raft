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
package org.tools4j.hoverraft.direct;

import org.agrona.ExpandableArrayBuffer;
import org.agrona.MutableDirectBuffer;
import org.tools4j.hoverraft.command.Command;
import org.tools4j.hoverraft.command.CommandKey;
import org.tools4j.hoverraft.command.DirectLogEntry;
import org.tools4j.hoverraft.command.LogEntry;
import org.tools4j.hoverraft.message.*;
import org.tools4j.hoverraft.message.direct.*;

public class AllocatingDirectFactory implements DirectFactory {

    private MutableDirectBuffer newBuffer(final int initialCapacity) {
        return new ExpandableArrayBuffer(initialCapacity);
    }

    @Override
    public AppendRequest appendRequest() {
        final DirectAppendRequest directAppendRequest = new DirectAppendRequest();
        directAppendRequest.wrap(newBuffer(DirectAppendRequest.EMPTY_LOG_BYTE_LENGTH), 0);
        return directAppendRequest;
    }

    @Override
    public AppendResponse appendResponse() {
        final DirectAppendResponse directAppendResponse = new DirectAppendResponse();
        directAppendResponse.wrap(newBuffer(DirectAppendResponse.BYTE_LENGTH), 0);
        return directAppendResponse;
    }

    @Override
    public VoteRequest voteRequest() {
        final DirectVoteRequest directVoteRequest = new DirectVoteRequest();
        directVoteRequest.wrap(newBuffer(DirectVoteRequest.BYTE_LENGTH), 0);
        return directVoteRequest;
    }

    @Override
    public VoteResponse voteResponse() {
        final DirectVoteResponse directVoteResponse = new DirectVoteResponse();
        directVoteResponse.wrap(newBuffer(DirectVoteResponse.BYTE_LENGTH), 0);
        return directVoteResponse;
    }

    @Override
    public TimeoutNow timeoutNow() {
        final DirectTimeoutNow directTimeoutNow = new DirectTimeoutNow();
        directTimeoutNow.wrap(newBuffer(DirectTimeoutNow.BYTE_LENGTH), 0);
        return null;
    }

    @Override
    public CommandKey commandKey() {
        final DirectCommandKey directCommandKey = new DirectCommandKey();
        directCommandKey.wrap(newBuffer(DirectCommandKey.BYTE_LENGTH), 0);
        return directCommandKey;
    }

    @Override
    public Command command() {
        final DirectCommand directCommand = new DirectCommand();
        directCommand.wrap(newBuffer(DirectCommand.EMPTY_COMMAND_BYTE_LENGTH), 0);
        return directCommand;
    }

    @Override
    public LogEntry logEntry() {
        final DirectLogEntry directCommandLogEntry = new DirectLogEntry();
        directCommandLogEntry.wrap(newBuffer(DirectLogEntry.EMPTY_COMMAND_BYTE_LENGTH), 0);
        return directCommandLogEntry;
    }
}
