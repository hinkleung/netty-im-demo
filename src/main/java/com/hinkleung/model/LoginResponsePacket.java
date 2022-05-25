package com.hinkleung.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import static com.hinkleung.model.Command.LOGIN_REQUEST;
import static com.hinkleung.model.Command.LOGIN_RESPONSE;

@EqualsAndHashCode(callSuper = true)
@Data
public class LoginResponsePacket extends Packet {

    private String userId;

    private String username;

    private Boolean success;

    private String reason;

    @Override
    public Byte getCommand() {
        return LOGIN_RESPONSE;
    }

    public boolean isSuccess() {
        return success;
    }
}
