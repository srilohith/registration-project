package whtson.test.resource;

import whtson.test.db.EmployeeDAO;
import whtson.test.db.entity.Employee;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

@Path("employee")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeResource {


    private EmployeeDAO employeeDAO;

    public EmployeeResource(EmployeeDAO employeeDAO) {
        this.employeeDAO = checkNotNull(employeeDAO);
    }

    // posting the employee personnumber for validation
    @POST
    public List<Employee> verify(Employee pNumber) {

        return this.employeeDAO.verify(pNumber);
    }

}
