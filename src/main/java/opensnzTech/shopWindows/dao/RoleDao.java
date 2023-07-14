package opensnzTech.shopWindows.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import opensnzTech.shopWindows.beans.ERole;
import opensnzTech.shopWindows.beans.Role;

@Repository
public interface RoleDao extends JpaRepository<Role, Long>{
	Optional<Role> findByName(ERole name);
}
