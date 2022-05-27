package com.hinkleung.model.response;

import com.hinkleung.model.Packet;
import lombok.Data;

import static com.hinkleung.model.Command.LOGOUT_RESPONSE;

@Data
public class LogoutResponsePacket extends Packet {

    private boolean success;

    private String reason;


    @Override
    public Byte getCommand() {

        return LOGOUT_RESPONSE;
    }
}
