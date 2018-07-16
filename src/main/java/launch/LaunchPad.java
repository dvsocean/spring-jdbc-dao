package launch;

import dao.OrganizationDAO;
import daoimpl.OrganizationDaoImpl;
import java.util.List;
import org.Organization;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LaunchPad {

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
