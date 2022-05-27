package com.hinkleung.model.response;

import com.hinkleung.model.Packet;
import lombok.Data;

import static com.hinkleung.model.Command.MESSAGE_RESPONSE;

@Data
public class MessageResponsePacket extends Packet {

    private String message;

    private String fromUserId;

    private String fromUserName;


    @Override
    public Byte getCommand() {
        return MESSAGE_RESPONSE;
    }
}
