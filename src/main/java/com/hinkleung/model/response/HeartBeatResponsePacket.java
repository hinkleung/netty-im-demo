package com.hinkleung.model.response;

import com.hinkleung.model.Packet;

import static com.hinkleung.model.Command.HEART_BEAT_RESPONSE;

public class HeartBeatResponsePacket extends Packet {

    @Override
    public Byte getCommand() {
        return HEART_BEAT_RESPONSE;
    }
}
