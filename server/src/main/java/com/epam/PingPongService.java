package com.epam;

import com.epam.grpc.PingPong;
import com.epam.grpc.PingPongServiceGrpc;
import io.grpc.stub.StreamObserver;

public class PingPongService extends PingPongServiceGrpc.PingPongServiceImplBase {

    @Override
    public void pingPong(PingPong.PingRequest request, StreamObserver<PingPong.PongResponse> responseObserver) {
        String message = request.getMessage();
        System.out.println("Received message: " + message);
        PingPong.PongResponse response = PingPong.PongResponse
                .newBuilder()
                .setMessage("Pong")
                .setTimestamp(System.currentTimeMillis())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();

        super.pingPong(request, responseObserver);
    }
}
