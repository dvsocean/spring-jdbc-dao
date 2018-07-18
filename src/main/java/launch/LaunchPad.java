package launch;

import jdbcdao.dao.OrganizationDAO;
import jdbcdao.daoimpl.OrganizationDaoImpl;
import java.util.List;
import jdbcdao.org.Organization;
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
    OrganizationDAO dao = (OrganizationDaoImpl) ctx.getBean("orgDao");
    List<Organization> orgs = dao.getAllOrganizations();

    for(Organization org: orgs){
      System.out.println(org);
    }
    ((ClassPathXmlApplicationContext) ctx).close();
  }
}

