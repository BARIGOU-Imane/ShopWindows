package opensnzTech.shopWindows.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import opensnzTech.shopWindows.beans.PharmaLabo;

@Repository
public interface PharmaLaboRepository extends JpaRepository<PharmaLabo, Long>{
	PharmaLabo findByPharmaLaboGln(String pharmaLaboGln);
}
