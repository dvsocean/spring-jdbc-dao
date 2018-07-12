package daoimpl;


import org.Organization;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrganizationRowMapper implements RowMapper<Organization> {

    public Organization mapRow(ResultSet resultSet, int rownum) throws SQLException {
        Organization org = new Organization();
        org.setId(resultSet.getInt("id"));
        org.setCompany_name(resultSet.getString("company_name"));
        org.setYear_of_inc(resultSet.getInt("year+of_inc"));
        org.setPostal_code(resultSet.getInt("postal_code"));
        org.setEmployee_count(resultSet.getInt("employee_count"));
        org.setSlogan(resultSet.getString("slogan"));
        return org;
    }
}
