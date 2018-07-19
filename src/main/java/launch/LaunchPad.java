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
    SQL Server time offset issue --> to fix it..

    SET GLOBAL time_zone='-07:00';
    SELECT @@time_zone;   to confirm
  */

  public static void main(String[] args) {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");

    //create the bean
    OrganizationDAO dao = (OrganizationDaoImpl) ctx.getBean("orgDao");

    //creating seed data
    //DaoUtils.createSeedData(dao);

    //List of the seed data we just created
    //List<Organization> orgs = dao.getAllOrganizations();
    //DaoUtils.printOrganizations(orgs, DaoUtils.READ_OPERATION);

    //create new org record
//    Organization org = new Organization("Gen electric", 1994, 91789, 5487, "Your imagination at work");
//    boolean isCreated = dao.create(org);
//    DaoUtils.printSuccessFailure(DaoUtils.CREATE_OPERATION, isCreated);
//    DaoUtils.printOrganizationCount(dao.getAllOrganizations(), DaoUtils.CREATE_OPERATION);
//    DaoUtils.printOrganizations(dao.getAllOrganizations(), DaoUtils.CREATE_OPERATION);

    //get single org

   Organization td = dao.getOrganization(12);
   dao.delete(td);

   List<Organization> finalOrgs = dao.getAllOrganizations();

   for(Organization org: finalOrgs){
     System.out.println(org);
   }


    //clean up
//    dao.cleanup();
//    DaoUtils.printOrganizationCount(dao.getAllOrganizations(), DaoUtils.CLEANUP_OPERATION);

    ((ClassPathXmlApplicationContext) ctx).close();
  }
}

