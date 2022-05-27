package com.hinkleung.model.request;

import com.hinkleung.model.Packet;

import static com.hinkleung.model.Command.HEART_BEAT_REQUEST;

public class HeartBeatRequestPacket extends Packet {



    @Override
    public Byte getCommand() {
        return HEART_BEAT_REQUEST;
    }
}
