package com.hinkleung.serialize;

import com.hinkleung.model.*;
import com.hinkleung.model.request.*;
import com.hinkleung.model.response.*;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

import java.util.HashMap;
import java.util.Map;

import static com.hinkleung.model.Command.*;

public class PacketCodeC {

    public static final int MAGIC_NUMBER = 0x12345678;
    private static final Map<Byte, Class<? extends Packet>> packetTypeMap;
    private static final Map<Byte, Serializer> serializerMap;

    public static final  PacketCodeC INSTANCE = new PacketCodeC();

    static {
        packetTypeMap = new HashMap<>();
        packetTypeMap.put(LOGIN_REQUEST, LoginRequestPacket.class);
        packetTypeMap.put(LOGIN_RESPONSE, LoginResponsePacket.class);
        packetTypeMap.put(MESSAGE_REQUEST, MessageRequestPacket.class);
        packetTypeMap.put(MESSAGE_RESPONSE, MessageResponsePacket.class);
        packetTypeMap.put(CREATE_GROUP_REQUEST, CreateGroupRequestPacket.class);
        packetTypeMap.put(CREATE_GROUP_RESPONSE, CreateGroupResponsePacket.class);
        packetTypeMap.put(JOIN_GROUP_REQUEST, JoinGroupRequestPacket.class);
        packetTypeMap.put(JOIN_GROUP_RESPONSE, JoinGroupResponsePacket.class);
        packetTypeMap.put(QUIT_GROUP_REQUEST, QuitGroupRequestPacket.class);
        packetTypeMap.put(QUIT_GROUP_RESPONSE, QuitGroupResponsePacket.class);
        packetTypeMap.put(LIST_GROUP_MEMBERS_REQUEST, ListGroupMembersRequestPacket.class);
        packetTypeMap.put(LIST_GROUP_MEMBERS_RESPONSE, ListGroupMembersResponsePacket.class);
        packetTypeMap.put(GROUP_MESSAGE_REQUEST, GroupMessageRequestPacket.class);
        packetTypeMap.put(GROUP_MESSAGE_RESPONSE, GroupMessageResponsePacket.class);
        packetTypeMap.put(HEART_BEAT_REQUEST, HeartBeatRequestPacket.class);
        packetTypeMap.put(HEART_BEAT_RESPONSE, HeartBeatResponsePacket.class);

        serializerMap = new HashMap<>();
        Serializer serializer = new JSONSerializer();
        serializerMap.put(serializer.getSerializerAlgorithm(), serializer);
    }

    public ByteBuf encode(ByteBufAllocator byteBufAllocator, Packet packet) {
        // 1. ?????? ByteBuf ??????
        ByteBuf byteBuf = byteBufAllocator.ioBuffer();
        // 2.?????????Java??????
        byte[] bytes = Serializer.DEFAULT.serialize(packet);

        // 3.??????????????????
        byteBuf.writeInt(MAGIC_NUMBER);
        byteBuf.writeByte(packet.getVersion());
        byteBuf.writeByte(Serializer.DEFAULT.getSerializerAlgorithm());
        byteBuf.writeByte(packet.getCommand());
        byteBuf.writeInt(bytes.length);
        byteBuf.writeBytes(bytes);
        return byteBuf;
    }

    public ByteBuf encode(ByteBuf byteBuf, Packet packet) {
        // 1.?????????Java??????
        byte[] bytes = Serializer.DEFAULT.serialize(packet);

        // 2.??????????????????
        byteBuf.writeInt(MAGIC_NUMBER);
        byteBuf.writeByte(packet.getVersion());
        byteBuf.writeByte(Serializer.DEFAULT.getSerializerAlgorithm());
        byteBuf.writeByte(packet.getCommand());
        byteBuf.writeInt(bytes.length);
        byteBuf.writeBytes(bytes);
        return byteBuf;
    }

    /**
     * ???????????????????????????
     *
     * @return
     */
    public ByteBuf encode(Packet packet) {
        // 1.??????ByteBuf??????
        ByteBuf byteBuf = ByteBufAllocator.DEFAULT.ioBuffer();
        // 2.?????????Java??????
        byte[] bytes = Serializer.DEFAULT.serialize(packet);

        // 3.??????????????????
        byteBuf.writeInt(MAGIC_NUMBER);
        byteBuf.writeByte(packet.getVersion());
        byteBuf.writeByte(Serializer.DEFAULT.getSerializerAlgorithm());
        byteBuf.writeByte(packet.getCommand());
        byteBuf.writeInt(bytes.length);
        byteBuf.writeBytes(bytes);
        return byteBuf;
    }

    /**
     * ??????????????????Java??????
     *
     * @param byteBuf
     * @return
     */
    public Packet decode(ByteBuf byteBuf) {
        // ??????Magic number
        byteBuf.skipBytes(4);
        // ???????????????
        byteBuf.skipBytes(1);
        // ?????????????????????
        byte serializeAlgorithm = byteBuf.readByte();
        // ??????
        byte command = byteBuf.readByte();
        // ???????????????
        int length = byteBuf.readInt();

        byte[] bytes = new byte[length];
        byteBuf.readBytes(bytes);
        Class<? extends Packet> requestType = getRequestType(command);
        Serializer serializer = getSerializer(serializeAlgorithm);
        if (requestType == null) {
            throw new RuntimeException("packet?????????????????????");
        }
        if (serializer == null) {
            throw new RuntimeException("??????serializeAlgorithm??????????????????Serializer");
        }
        return serializer.deserialize(requestType, bytes);
    }

    private Serializer getSerializer(byte serializeAlgorithm) {
        return serializerMap.get(serializeAlgorithm);
    }

    private Class<? extends Packet> getRequestType(byte command) {
        return packetTypeMap.get(command);
    }

}
