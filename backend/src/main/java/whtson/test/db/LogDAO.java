package whtson.test.db;


import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;
import whtson.test.db.entity.Log;

import java.util.List;

@RegisterMapperFactory(BeanMapperFactory.class)
public interface LogDAO {

    @SqlQuery("Select * from employee where personnumber= :hostID")
    List<Log> verify(@BindBean Log id);

    @SqlUpdate("Insert into log values(:personnumber, :visitorname, :hostID, :entrytime, :exittime)")
    int insertentry(@BindBean Log log);

    @SqlQuery("select * from log")
    List<Log> findPersons();

    @SqlUpdate("UPDATE `log` set exittime= :exittime WHERE personnumber = :personnumber AND exittime='0'")
    int updateEmployeeExit(@BindBean Log log);

    @SqlUpdate("UPDATE `log` set exittime= :exittime WHERE visitorname =:visitorname AND hostID = :hostID AND exittime= '0'")
    int updateVisitorExit(@BindBean Log log);

}
