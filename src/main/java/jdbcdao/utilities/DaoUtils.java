package jdbcdao.utilities;

import java.util.ArrayList;
import java.util.List;
import jdbcdao.dao.OrganizationDAO;
import jdbcdao.org.Organization;

public class DaoUtils {

  public static final String CREATE_OPERATION = "CREATE";
  public static final String READ_OPERATION = "READ";
  public static final String UPDATE_OPERATION = "UPDATE";
  public static final String DELETE_OPERATION = "DELETE";
  public static final String CLEANUP_OPERATION = "TRUNCATE";

  public static void printOrganizations(List<Organization> orgsList, String operation){
    System.out.println("\n****************** printing organizations after " + operation + " operation **************");
    for(Organization org: orgsList){
      System.out.println(org);
    }
  }

  public static void printSuccessFailure(String opertion, boolean param){
    if(param){
      System.out.println("\nOperation " + opertion + " successful!");
    } else {
      System.out.println("\nOperation " + opertion + " failed!");
    }
  }

  public static void createSeedData(OrganizationDAO dao){
    Organization org1 = new Organization("Amazon", 1998, 91789, 1200, "Work hard, have fun and make history");
    Organization org2 = new Organization("GoodsByeOcean", 2016, 91789, 5500, "I struggled to make it now it pays off");
    Organization org3 = new Organization("NerdSchool", 2015, 91789, 1, "Blood sweat and tears at this school and now im here");

    List<Organization> orgs = new ArrayList<Organization>();
    orgs.add(0, org1);
    orgs.add(1, org2);
    orgs.add(2, org3);

    int createCount = 0;
    for(Organization org: orgs){
      boolean isCreated = dao.create(org);
      if(isCreated){
        createCount += 1;
      }
      System.out.println("Created " + createCount + " organizations");
    }
  }

  public static void printOrganizationCount(List<Organization> orgsList, String operation){
    System.out.println("\n*************Currently we have " + orgsList.size() + " organizations after " + operation + " operation");
  }
}//End of class
