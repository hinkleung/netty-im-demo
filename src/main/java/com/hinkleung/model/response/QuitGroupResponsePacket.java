package com.hinkleung.model.response;

import com.hinkleung.model.Packet;
import lombok.Data;

import static com.hinkleung.model.Command.QUIT_GROUP_RESPONSE;

@Data
public class QuitGroupResponsePacket extends Packet {

    private String groupId;

    private boolean success;

    private String reason;

    @Override
    public Byte getCommand() {

        return QUIT_GROUP_RESPONSE;
    }
}