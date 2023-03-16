package com.epam;

import com.epam.grpc.PingPong;
import com.epam.grpc.PingPongServiceGrpc;
import io.grpc.Channel;

public class PingPongClient {
    private final PingPongServiceGrpc.PingPongServiceBlockingStub stub;

    public PingPongClient(Channel channel) {
        this.stub = PingPongServiceGrpc.newBlockingStub(channel);
    }

    public void sendMessage(){
        PingPong.PingRequest request = PingPong.PingRequest.newBuilder()
                .setMessage("hello")
                .setTimestamp(System.currentTimeMillis())
                .build();


        PingPong.PongResponse pongResponse = stub.pingPong(request);
        System.out.println(pongResponse);

    }
}
