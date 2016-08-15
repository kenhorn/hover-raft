/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 hover-raft (tools4j), Marco Terzer
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
package org.tools4j.hoverraft.message.simple;

import org.tools4j.hoverraft.message.MessageType;
import org.tools4j.hoverraft.message.TimeoutNow;

public final class SimpleTimeoutNow extends AbstractSimpleMessage implements TimeoutNow<SimpleMessage> {

    private int term;
    private int candidateId;

    @Override
    public MessageType type() {
        return MessageType.TIMEOUT_NOW;
    }

    @Override
    public int term() {
        return term;
    }

    @Override
    public SimpleTimeoutNow term(final int term) {
        this.term = term;
        return this;
    }

    @Override
    public int candidateId() {
        return candidateId;
    }

    @Override
    public SimpleTimeoutNow candidateId(final int candidateId) {
        this.candidateId = candidateId;
        return this;
    }

    @Override
    public String toString() {
        return "SimpleTimeoutNow{" +
                "term=" + term +
                ", candidateId=" + candidateId +
                '}';
    }
}