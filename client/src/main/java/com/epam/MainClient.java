package com.epam;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class MainClient {
    public static void main(String[] args) {
        ManagedChannel chanel = ManagedChannelBuilder.forTarget("localhost:8080")
                .usePlaintext()
                .build();
        PingPongClient client = new PingPongClient(chanel);
        for (int i = 0; i < 1; i++) {
            client.sendMessage();
        }

    }
}