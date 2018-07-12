package daoimpl;

import dao.OrganizationDAO;
import org.Organization;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class OrganizationDaoImpl implements OrganizationDAO {

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource ds) {
        jdbcTemplate = new JdbcTemplate(ds);
    }

    public boolean create(Organization org) {
        return false;
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

    }
}
