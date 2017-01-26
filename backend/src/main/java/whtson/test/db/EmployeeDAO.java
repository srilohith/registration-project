package whtson.test.db;


import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;
import whtson.test.db.entity.Employee;

import java.util.List;

@RegisterMapperFactory(BeanMapperFactory.class)
public interface EmployeeDAO {

    @SqlQuery("Select * from employee where personnumber= :personnumber")
    List<Employee> verify(@BindBean Employee pno);

}
