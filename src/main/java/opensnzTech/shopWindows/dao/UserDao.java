package opensnzTech.shopWindows.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import opensnzTech.shopWindows.beans.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
		
	 Optional<User> findById(Long id);

	@Query("SELECT u FROM User u WHERE u.isvalid = :isValid")
	List<User> findByIsvalid(boolean isValid);
}
