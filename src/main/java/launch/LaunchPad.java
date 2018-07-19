package launch;

import jdbcdao.dao.OrganizationDAO;
import jdbcdao.daoimpl.OrganizationDaoImpl;
import java.util.List;
import jdbcdao.org.Organization;
import jdbcdao.utilities.DaoUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LaunchPad {

  /*
    SQL Server time offset was the issue, to fix it I..

    SET GLOBAL time_zone='-07:00';
    SELECT @@time_zone;   inside of mysql workbench then..

    confirmed by going to server > status and system variables (select system variables tab)
    and search for "time_zone" to make sure the offset is set to -07:00 (current UTC offset in irvine).
  */

  public static void main(String[] args) {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");

    //create the bean
    OrganizationDAO dao = (OrganizationDaoImpl) ctx.getBean("orgDao");

    //creating seed data
    DaoUtils.createSeedData(dao);

    //List of the seed data we just created
    List<Organization> orgs = dao.getAllOrganizations();
    DaoUtils.printOrganizations(orgs, DaoUtils.READ_OPERATION);

    //create new org record
    Organization org = new Organization("Gen electric", 1994, 91789, 5487, "Your imagination at work");
    boolean isCreated = dao.create(org);
    DaoUtils.printSuccessFailure(DaoUtils.CREATE_OPERATION, isCreated);
    DaoUtils.printOrganizationCount(dao.getAllOrganizations(), DaoUtils.CREATE_OPERATION);

    //clean up
    dao.cleanup();
    DaoUtils.printOrganizationCount(dao.getAllOrganizations(), DaoUtils.CLEANUP_OPERATION);

    ((ClassPathXmlApplicationContext) ctx).close();
  }
}

