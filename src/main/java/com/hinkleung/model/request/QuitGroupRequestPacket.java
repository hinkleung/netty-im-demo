package com.hinkleung.model.request;

import com.hinkleung.model.Packet;
import lombok.Data;

import static com.hinkleung.model.Command.QUIT_GROUP_REQUEST;

@Data
public class QuitGroupRequestPacket extends Packet {

    private String groupId;

    @Override
    public Byte getCommand() {

        return QUIT_GROUP_REQUEST;
    }
}
