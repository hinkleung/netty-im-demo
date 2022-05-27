package com.hinkleung.model.request;

import com.hinkleung.model.Packet;
import lombok.Data;

import static com.hinkleung.model.Command.JOIN_GROUP_REQUEST;

@Data
public class JoinGroupRequestPacket extends Packet {

    private String groupId;

    @Override
    public Byte getCommand() {
        return JOIN_GROUP_REQUEST;
    }
}
