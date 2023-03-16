package com.epam;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.protobuf.services.ProtoReflectionService;

import java.io.IOException;

public class MainServer {
    public static void main(String[] args) throws InterruptedException, IOException {
        Server server = ServerBuilder.forPort(8080)
                .addService(new PingPongService())
                .addService(ProtoReflectionService.newInstance())
                .build();
        server.start();
        server.awaitTermination();
    }
}
