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
        String sql = "INSERT INTO organizations (company_name, year_of_incorporation, postal_code, employee_count, slogan) " +
            "VALUES(?, ?, ?, ?, ?)";
        Object[] vals = new Object[]{org.getCompany_name(), org.getYear_of_inc(), org.getPostal_code(), org.getEmployee_count(), org.getSlogan()};
        return jdbcTemplate.update(sql, vals) == 1;
    }

    public Organization getOrganization(Integer id) {
        String sql = "SELECT * FROM organizations WHERE id = ?";
        Object[] val = new Object[]{id};
        return jdbcTemplate.queryForObject(sql, val, new OrganizationRowMapper());
    }

    public List<Organization> getAllOrganizations() {
        String sql = "SELECT * FROM organizations";
        return jdbcTemplate.query(sql, new OrganizationRowMapper());
    }

    public boolean delete(Organization org) {
        String sql = "DELETE FROM organizations WHERE id = ?";
        Object[] toDelete = new Object[]{org.getId()};
        return jdbcTemplate.update(sql, toDelete) == 1;
    }

    public boolean update(Organization org) {
        String sql = "UPDATE organizations SET slogan = ? WHERE id = ?";
        Object [] values = new Object[]{org.getSlogan(), org.getId()};
        return jdbcTemplate.update(sql, values) == 1;
    }

    public void cleanup() {
        String sql = "TRUNCATE TABLE organizations";
        jdbcTemplate.execute(sql);
    }
}
