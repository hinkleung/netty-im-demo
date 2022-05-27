package com.hinkleung.model.request;

import com.hinkleung.model.Packet;
import lombok.Data;

import static com.hinkleung.model.Command.LOGOUT_REQUEST;

@Data
public class LogoutRequestPacket extends Packet {
    @Override
    public Byte getCommand() {

        return LOGOUT_REQUEST;
    }
}
