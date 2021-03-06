package com.hinkleung.model.request;

import com.hinkleung.model.Packet;
import lombok.Data;

import static com.hinkleung.model.Command.MESSAGE_REQUEST;

@Data
public class MessageRequestPacket extends Packet {

    private String message;

    private String toUserId;

    public MessageRequestPacket(String toUserId, String message) {
        this.message = message;
        this.toUserId = toUserId;
    }

    @Override
    public Byte getCommand() {
        return MESSAGE_REQUEST;
    }
}
