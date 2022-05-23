package com.hinkleung.client.handler;

import com.hinkleung.model.LoginResponsePacket;
import com.hinkleung.utils.LoginUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Date;

public class LoginResponseHandler extends SimpleChannelInboundHandler<LoginResponsePacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginResponsePacket loginResponsePacket) throws Exception {
        if (loginResponsePacket.isSuccess()) {
            LoginUtil.markAsLogin(ctx.channel());
            System.out.println(new Date() + ":客户端登录成功");
        } else {
            System.out.println(new Date() + ":客户端登录失败，原因:" + loginResponsePacket.getReason());
        }
    }
}
