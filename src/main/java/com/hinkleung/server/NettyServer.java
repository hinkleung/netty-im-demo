package com.hinkleung.server;

import com.hinkleung.serialize.PacketCodecHandler;
import com.hinkleung.serialize.PacketDecoder;
import com.hinkleung.serialize.PacketEncoder;
import com.hinkleung.serialize.Spliter;
import com.hinkleung.server.handler.*;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

public class NettyServer {

    public static void main(String[] args) {
        ServerBootstrap serverBootstrap = new ServerBootstrap();

        NioEventLoopGroup boss = new NioEventLoopGroup();
        NioEventLoopGroup worker = new NioEventLoopGroup();
        serverBootstrap
                .group(boss, worker)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    protected void initChannel(NioSocketChannel ch) {
//                        ch.pipeline().addLast(new LifeCyCleTestHandler());
                        ch.pipeline().addLast(new IMIdleStateHandler());
                        ch.pipeline().addLast(new Spliter());
//                        ch.pipeline().addLast(new PacketDecoder());
                        ch.pipeline().addLast(PacketCodecHandler.INSTANCE);
                        ch.pipeline().addLast(LoginRequestHandler.INSTANCE);
                        ch.pipeline().addLast(HeartBeatRequestHandler.INSTANCE);
                        ch.pipeline().addLast(AuthHandler.INSTANCE);
                        ch.pipeline().addLast(IMHandler.INSTANCE);

//                        ch.pipeline().addLast(CreateGroupRequestHandler.INSTANCE);
//                        ch.pipeline().addLast(MessageRequestHandler.INSTANCE);
//                        ch.pipeline().addLast(JoinGroupRequestHandler.INSTANCE);
//                        ch.pipeline().addLast(QuitGroupRequestHandler.INSTANCE);
//                        ch.pipeline().addLast(ListGroupMembersRequestHandler.INSTANCE);
//                        ch.pipeline().addLast(LogoutRequestHandler.INSTANCE);
//                        ch.pipeline().addLast(GroupMessageRequestHandler.INSTANCE);
//                        ch.pipeline().addLast(new PacketEncoder());

                    }
                });
        bind(serverBootstrap, 8000);
    }

    private static void bind(final ServerBootstrap serverBootstrap, final int port) {
        serverBootstrap.bind(port)
                .addListener(new GenericFutureListener<Future<? super Void>>() {
                    @Override
                    public void operationComplete(Future<? super Void> future) throws Exception {
                        if (future.isSuccess()) {
                            System.out.println("??????[" + port + "]????????????!");
                        } else {
                            System.err.println("??????[" + port + "]????????????!");
                            bind(serverBootstrap, port + 1);
                        }
                    }
                });
    }
}
