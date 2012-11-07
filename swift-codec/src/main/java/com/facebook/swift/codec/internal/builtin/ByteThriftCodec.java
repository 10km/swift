/*
 * Copyright 2012 Facebook, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package com.facebook.swift.codec.internal.builtin;

import com.facebook.swift.codec.ThriftCodec;
import com.facebook.swift.codec.metadata.ThriftType;
import com.google.common.base.Preconditions;
import org.apache.thrift.protocol.TProtocol;

import javax.annotation.concurrent.Immutable;

@Immutable
public class ByteThriftCodec implements ThriftCodec<Byte>
{
    @Override
    public ThriftType getType()
    {
        return ThriftType.BYTE;
    }

    @Override
    public Byte read(TProtocol protocol)
            throws Exception
    {
        Preconditions.checkNotNull(protocol, "protocol is null");
        return protocol.readByte();
    }

    @Override
    public void write(Byte value, TProtocol protocol)
            throws Exception
    {
        Preconditions.checkNotNull(value, "value is null");
        Preconditions.checkNotNull(protocol, "protocol is null");
        protocol.writeByte(value);
    }
}
