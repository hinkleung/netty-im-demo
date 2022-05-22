package com.hinkleung.model;

import lombok.Data;

import static com.hinkleung.model.Command.MESSAGE_REQUEST;

@Data
public class MessageRequestPacket extends Packet {

    private String message;

    @Override
    public Byte getCommand() {
        return MESSAGE_REQUEST;
    }
}
