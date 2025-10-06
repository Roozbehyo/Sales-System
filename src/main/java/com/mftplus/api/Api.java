package com.mftplus.api;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/")
public class Api extends Application {
    public Api() {
        System.out.println("Api started");
    }
}
