package com.hinkleung.model.request;

import com.hinkleung.model.Packet;
import lombok.AllArgsConstructor;
import lombok.Data;

import static com.hinkleung.model.Command.GROUP_MESSAGE_REQUEST;

@Data
@AllArgsConstructor
public class GroupMessageRequestPacket extends Packet {

    private String groupId;

    private String message;

    @Override
    public Byte getCommand() {
        return GROUP_MESSAGE_REQUEST;
    }
}
