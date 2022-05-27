package com.hinkleung.model.request;

import com.hinkleung.model.Packet;
import lombok.Data;
import lombok.EqualsAndHashCode;

import static com.hinkleung.model.Command.LOGIN_REQUEST;

@EqualsAndHashCode(callSuper = true)
@Data
public class LoginRequestPacket extends Packet {

    private String userId;

    private String username;

    private String password;

    @Override
    public Byte getCommand() {
        return LOGIN_REQUEST;
    }
}
