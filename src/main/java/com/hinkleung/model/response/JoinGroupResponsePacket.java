package com.hinkleung.model.response;

import com.hinkleung.model.Packet;
import lombok.Data;

import static com.hinkleung.model.Command.JOIN_GROUP_RESPONSE;

@Data
public class JoinGroupResponsePacket extends Packet {

    private Boolean success;

    private String groupId;

    private String reason;

    @Override
    public Byte getCommand() {
        return JOIN_GROUP_RESPONSE;
    }
}
