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



    Organization edited = dao.getOrganization(1);
    edited.setCompany_name("Verys");
    dao.update(edited);



    List<Organization> inDatabase = dao.getAllOrganizations();
    for(Organization o: inDatabase){
      System.out.println(o);
    }

    ((ClassPathXmlApplicationContext) ctx).close();
  }
}

