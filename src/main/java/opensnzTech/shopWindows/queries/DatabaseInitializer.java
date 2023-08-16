package opensnzTech.shopWindows.queries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import opensnzTech.shopWindows.beans.PharmaLabo;
import opensnzTech.shopWindows.dao.PharmaLaboRepository;

@Component
public class DatabaseInitializer implements ApplicationRunner{
	private final PharmaLaboRepository pharmaLaboRepository;
	private final JdbcTemplate jdbcTemplate;
	
	  @Autowired
	  PasswordEncoder encoder;
	
	 @Autowired
	    public DatabaseInitializer(JdbcTemplate jdbcTemplate, PharmaLaboRepository pharmaLaboRepository) {
			this.jdbcTemplate = jdbcTemplate;
			this.pharmaLaboRepository = pharmaLaboRepository;
	    }
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		//classe role
		// TODO Auto-generated method stub
        String query1 = "INSERT INTO roles(name) VALUES('ROLE_LABORATOIRE')";
        String query2 = "INSERT INTO roles(name) VALUES('ROLE_PHARMACIE')";
        String query3 = "INSERT INTO roles(name) VALUES('ROLE_ADMIN')";


        jdbcTemplate.update(query1);
        jdbcTemplate.update(query2);
        jdbcTemplate.update(query3);

        //enregistrement de la classe pharmacie
        PharmaLabo labo = new PharmaLabo();
        labo.setPharmaLaboName("labo2");
        labo.setPharmaLaboGln("1234567892588");
        labo.setPharmaLaboAdresseCanton("rue 2 paris");
        labo.setPharmaLaboRsGoogleBusiness("labo2 google business");
        labo.setPharmaLaboRsLinkedin("labo2 linkedin");
        labo.setPharmaLaboRsFacebook("labo2 facebook");
        labo.setPharmaLaboRsInstagram("labo2 instagram");
        labo.setPharmaLaboNumeroTelephone("0782737110");
        labo.setPharmaLaboGroupement("groupe2");
        labo.setPharmaLaboHoraireOuverture("5h");
        labo.setRole("Laboratory");
        pharmaLaboRepository.save(labo);
        
        PharmaLabo pharma = new PharmaLabo();
        pharma.setPharmaLaboName("pharmacie1");
        pharma.setPharmaLaboGln("3334567892684");
        pharma.setPharmaLaboAdresseCanton("rue 12 maroc");
        pharma.setPharmaLaboRsGoogleBusiness("pharmacie1 google business");
        pharma.setPharmaLaboRsLinkedin("pharmacie1 linkedin");
        pharma.setPharmaLaboRsFacebook("pharmacie1 facebook");
        pharma.setPharmaLaboRsInstagram("pharmacie1 instagram");
        pharma.setPharmaLaboNumeroTelephone("0682737110");
        pharma.setPharmaLaboGroupement("groupe1");
        pharma.setPharmaLaboHoraireOuverture("6h");
        pharma.setRole("Pharmacy");
        pharmaLaboRepository.save(pharma);
        
        

        //ajouter un user pour le role admin
        
        // Requête SQL pour insérer un nouvel enregistrement dans la table "users" avec le rôle "ROLE_ADMIN"
        
        String insertUserQuery = "INSERT INTO users (username, email, password,isvalid ,perso_gln, pharma_labo_name, adresse_canton, pharma_labo_adresse_canton, rs_google_business, pharma_labo_rs_google_business, rs_linkedin, pharma_labo_rs_linkedin, rs_facebook, pharma_labo_rs_facebook, rs_instagram, pharma_labo_rs_instagram, numero_telephone, pharma_labo_numero_telephone, pharma_labo_groupement, pharma_labo_horaire_ouverture) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?,?)";

        // Remplacez les valeurs suivantes par celles que vous souhaitez insérer dans la table "users"
        String username = "admin";
        String email = "imane.barigou@ump.ac.ma";
        String password = encoder.encode("123456");
        String perso_gln = "1234567982584";
        boolean isvalid = true;
        String pharma_labo_name = "";
        String adresse_canton = "";
        String pharma_labo_adresse_canton = "";
        String rs_google_business = "";
        String pharma_labo_rs_google_business = "";
        String rs_linkedin = "";
        String pharma_labo_rs_linkedin = "";
        String rs_facebook = "";
        String pharma_labo_rs_facebook = "";
        String rs_instagram = "";
        String pharma_labo_rs_instagram = "";
        String numero_telephone = "0762737110";
        String pharma_labo_numero_telephone = "";
        String pharma_labo_groupement = "";
        String pharma_labo_horaire_ouverture = "5h";

        jdbcTemplate.update(insertUserQuery, username, email, password,isvalid, perso_gln, pharma_labo_name, adresse_canton, pharma_labo_adresse_canton, rs_google_business, pharma_labo_rs_google_business, rs_linkedin, pharma_labo_rs_linkedin, rs_facebook, pharma_labo_rs_facebook, rs_instagram, pharma_labo_rs_instagram, numero_telephone, pharma_labo_numero_telephone, pharma_labo_groupement, pharma_labo_horaire_ouverture);

        // Après l'insertion de l'utilisateur, ajoutez le rôle "ROLE_ADMIN" à l'utilisateur
        String findUserIdQuery = "SELECT id FROM users WHERE username = ?";
        Long userId = jdbcTemplate.queryForObject(findUserIdQuery, Long.class, username);

        String insertUserRoleQuery = "INSERT INTO user_roles (user_id, role_id) VALUES (?, ?)";
        jdbcTemplate.update(insertUserRoleQuery, userId, 3); 



	}

}
