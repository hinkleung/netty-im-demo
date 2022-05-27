package com.hinkleung.model.request;

import com.hinkleung.model.Packet;
import lombok.Data;

import static com.hinkleung.model.Command.LIST_GROUP_MEMBERS_REQUEST;

@Data
public class ListGroupMembersRequestPacket extends Packet {

    private String groupId;

    @Override
    public Byte getCommand() {

        return LIST_GROUP_MEMBERS_REQUEST;
    }
}