package com.hinkleung.model.response;

import com.hinkleung.model.Packet;
import lombok.Data;

import java.util.List;

import static com.hinkleung.model.Command.CREATE_GROUP_RESPONSE;

@Data
public class CreateGroupResponsePacket extends Packet {

    private Boolean success;

    private String groupId;

    private List<String> userNameList;

    @Override
    public Byte getCommand() {
        return CREATE_GROUP_RESPONSE;
    }
}
