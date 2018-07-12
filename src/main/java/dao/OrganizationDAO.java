package dao;

import org.Organization;

import javax.sql.DataSource;
import java.util.List;

public interface OrganizationDAO {

    //Set the data-source required to create a connection to the database
    public void setDataSiource(DataSource ds);

    //Create a record in the organization table
    public boolean create(Organization org);

    //Retrieve a single organization
    public Organization getOrganization(Integer id);

    //Retrieve all organizations from the table
    public List<Organization> getAllOrganizations();

    //Delete a specific org
    public boolean delete(Organization org);

    //Update an existing organization
    public boolean update(Organization org);

    public void cleanup();

}
