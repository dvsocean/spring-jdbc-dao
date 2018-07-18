package jdbcdao.daoimpl;

import jdbcdao.dao.OrganizationDAO;
import jdbcdao.org.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository("orgDao")
public class OrganizationDaoImpl implements OrganizationDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource ds) {
        jdbcTemplate = new JdbcTemplate(ds);
    }

    public boolean create(Organization org) {
        String sql = "INSERT INTO organization (company_name, year_of_incorporation, postal_code, employee_count, slogan) " +
            "VALUES(?, ?, ?, ?, ?)";
        Object[] vals = new Object[]{org.getCompany_name(), org.getYear_of_inc(), org.getPostal_code(), org.getEmployee_count(), org.getSlogan()};
        return jdbcTemplate.update(sql, vals) == 1;
    }

    public Organization getOrganization(Integer id) {
        return null;
    }

    public List<Organization> getAllOrganizations() {
        String sql = "SELECT * FROM organization";
        return jdbcTemplate.query(sql, new OrganizationRowMapper());
    }

    public boolean delete(Organization org) {
        return false;
    }

    public boolean update(Organization org) {
        return false;
    }

    public void cleanup() {
        String sql = "TRUNCATE TABLE";
        jdbcTemplate.execute(sql);
    }
}
