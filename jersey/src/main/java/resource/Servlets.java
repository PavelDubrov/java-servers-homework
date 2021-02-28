package resource;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

@Path("/counter")
public class Servlets {

    public static int counter = 0;

    @GET
    public Response get() {
        OffsetDateTime now = OffsetDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        System.out.println("time= " + formatter.format(now) + "\n" + "counter= " + counter);
        return Response.ok("time= " + formatter.format(now) + "\n" + "counter= " + counter).build();
    }

    @POST
    public Response post() {
        counter += 1;
        System.out.println("Post");
        return Response.ok("Post").build();
    }

    @DELETE
    public Response delete(@HeaderParam("Subtraction-Value") Integer header) {
        System.out.println("Header = " + header);
        counter -= header;
        System.out.println("Delete; counter now = " + counter);
        return Response.ok("Delete; counter now = " + counter).build();
    }
    @POST
    @Path("/clear")
    public Response clear() {
        counter = 0;
        return Response.ok("Post; counter now = " + counter).build();
    }
}
