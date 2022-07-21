package com.stephennimmo.demo;

import com.stephennimmo.demo.hello.HelloGrpc;
import com.stephennimmo.demo.hello.HelloReply;
import com.stephennimmo.demo.hello.HelloRequest;
import io.quarkus.grpc.GrpcService;

import io.smallrye.mutiny.Uni;

@GrpcService
public class HelloGrpcService implements HelloGrpc {

    @Override
    public Uni<HelloReply> sayHello(HelloRequest request) {
        return Uni.createFrom().item("Hello " + request.getName() + "!")
                .map(msg -> HelloReply.newBuilder().setMessage(msg).build());
    }

}
