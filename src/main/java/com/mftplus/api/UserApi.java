package com.mftplus.api;

import com.mftplus.model.entity.User;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Consumes("application/json")
@Produces("application/json")
@Path("/users")
public class UserApi {
    @GET
    public User getUser() {
        return User.builder().firstName("Roozbeh")
                .familyName("Yousefi").build();
    }
}
