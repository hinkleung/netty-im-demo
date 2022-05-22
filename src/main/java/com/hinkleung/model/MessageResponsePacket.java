package com.hinkleung.model;

import lombok.Data;

import static com.hinkleung.model.Command.MESSAGE_RESPONSE;

@Data
public class MessageResponsePacket extends Packet {

    private String message;

    @Override
    public Byte getCommand() {
        return MESSAGE_RESPONSE;
    }
}
