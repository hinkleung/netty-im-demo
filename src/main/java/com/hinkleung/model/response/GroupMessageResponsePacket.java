package com.hinkleung.model.response;

import com.hinkleung.model.Packet;
import com.hinkleung.model.session.Session;
import lombok.Data;

import static com.hinkleung.model.Command.GROUP_MESSAGE_RESPONSE;

@Data
public class GroupMessageResponsePacket extends Packet {

    private String fromGroupId;

    private String message;

    private Session fromUser;

    @Override
    public Byte getCommand() {
        return GROUP_MESSAGE_RESPONSE;
    }
}
