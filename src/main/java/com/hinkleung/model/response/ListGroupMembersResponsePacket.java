package com.hinkleung.model.response;

import com.hinkleung.model.Packet;
import com.hinkleung.model.session.Session;
import lombok.Data;

import java.util.List;

import static com.hinkleung.model.Command.LIST_GROUP_MEMBERS_RESPONSE;

@Data
public class ListGroupMembersResponsePacket extends Packet {

    private String groupId;

    private List<Session> sessionList;

    @Override
    public Byte getCommand() {

        return LIST_GROUP_MEMBERS_RESPONSE;
    }
}
