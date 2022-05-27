package com.hinkleung.model.request;

import com.hinkleung.model.Packet;
import lombok.Data;

import java.util.List;

import static com.hinkleung.model.Command.CREATE_GROUP_REQUEST;

@Data
public class CreateGroupRequestPacket extends Packet {

    private List<String> userIdList;

    @Override
    public Byte getCommand() {
        return CREATE_GROUP_REQUEST;
    }
}
