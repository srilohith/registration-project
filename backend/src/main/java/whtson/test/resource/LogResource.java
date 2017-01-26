package whtson.test.resource;


import whtson.test.db.LogDAO;
import whtson.test.db.entity.Log;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;


@Path("log")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LogResource {

    private LogDAO logDAO;

    public LogResource(LogDAO logDAO) {
        this.logDAO = checkNotNull(logDAO);
    }

    //  posting hostID for visitor validation
    @POST
    public Response verify(Log log) {

        if (!(this.logDAO.verify(log).isEmpty())) {
            this.logDAO.insertentry(log);
            return Response.status(200).build();
        } else {
            return Response.status(400).build();
        }
    }

    // posting employee entry time to log table
    @POST
    @Path("/employee")
    public Response employeeEntry(Log log) {
        this.logDAO.insertentry(log);
        return Response.status(200).build();
    }

    // getting the total list of entries from log table
    @GET
    public List<Log> personCount() {
        return this.logDAO.findPersons();
    }

    // updating the log table with employee exit time
    @PUT
    @Path("/employeeexit")
    public Response employeeExit(Log log) {

        if (this.logDAO.updateEmployeeExit(log) != 0) {
            return Response.status(200).build();
        }
        return Response.status(400).build();
    }

    // updating the log table with visitor exit time
    @PUT
    @Path("/visitorexit")
    public Response visitorExit(Log log) {

        if (this.logDAO.updateVisitorExit(log) != 0) {
            return Response.status(200).build();
        }
        return Response.status(400).build();
    }


}
