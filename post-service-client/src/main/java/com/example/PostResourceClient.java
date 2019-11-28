package com.example;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.concurrent.CompletionStage;

@Path("/posts")
@RegisterRestClient
public interface PostResourceClient {

    @Path("count")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    CompletionStage<Long> countAllPosts(@QueryParam("q") String q);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    CompletionStage<List<Post>> getAllPosts(
            @QueryParam("q") String q,
            @QueryParam("offset") @DefaultValue("0") int offset,
            @QueryParam("limit") @DefaultValue("10") int limit
    );

}
