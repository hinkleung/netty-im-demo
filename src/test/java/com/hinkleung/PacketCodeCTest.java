package com.hinkleung;

import com.hinkleung.model.request.LoginRequestPacket;
import com.hinkleung.model.Packet;
import com.hinkleung.serialize.JSONSerializer;
import com.hinkleung.serialize.PacketCodeC;
import com.hinkleung.serialize.Serializer;
import io.netty.buffer.ByteBuf;
import org.junit.Assert;
import org.junit.Test;

import java.util.UUID;

public class PacketCodeCTest {

    @Test
    public void encode() {

        Serializer serializer = new JSONSerializer();
        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();

        loginRequestPacket.setVersion(((byte) 1));
        loginRequestPacket.setUserId(UUID.randomUUID().toString());
        loginRequestPacket.setUsername("zhangsan");
        loginRequestPacket.setPassword("password");

        PacketCodeC packetCodeC = new PacketCodeC();
        ByteBuf byteBuf = packetCodeC.encode(loginRequestPacket);
        Packet decodedPacket = packetCodeC.decode(byteBuf);

        Assert.assertArrayEquals(serializer.serialize(loginRequestPacket), serializer.serialize(decodedPacket));

    }

}
