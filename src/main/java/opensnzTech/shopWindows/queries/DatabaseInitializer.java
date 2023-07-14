package opensnzTech.shopWindows.queries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer implements ApplicationRunner{
	
	private final JdbcTemplate jdbcTemplate;
	
	 @Autowired
	    public DatabaseInitializer(JdbcTemplate jdbcTemplate) {
	        this.jdbcTemplate = jdbcTemplate;
	    }
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
        String query1 = "INSERT INTO roles(name) VALUES('ROLE_LABORATOIRE')";
        String query2 = "INSERT INTO roles(name) VALUES('ROLE_PHARMACIE')";
        String query3 = "INSERT INTO roles(name) VALUES('ROLE_ADMIN')";

        jdbcTemplate.update(query1);
        jdbcTemplate.update(query2);
        jdbcTemplate.update(query3);
	}

}
