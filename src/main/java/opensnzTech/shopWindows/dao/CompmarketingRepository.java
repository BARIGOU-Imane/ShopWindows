package opensnzTech.shopWindows.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import opensnzTech.shopWindows.beans.Compmarketing;
import opensnzTech.shopWindows.beans.User;



@Repository
public interface CompmarketingRepository extends JpaRepository<Compmarketing, Long>{
	List<Compmarketing> findByNameComp(String nameComp);
	List<Compmarketing> findByBrand(String brand);
	List<Compmarketing> findByTypeComp(String typeComp);
	List<Compmarketing> findBySeason(String season);
	List<Compmarketing> findByStartDateBetween(java.util.Date startDate, java.util.Date endDate);
	List<Compmarketing> findByUserLabo(User user);
    @Query("SELECT c FROM Compmarketing c WHERE c.period = :period")
    List<Compmarketing> findByPeriod(@Param("period") String period);
    @Query("SELECT c FROM Compmarketing c WHERE c.startDate <= :startDate AND c.endDate >= :endDate")
    List<Compmarketing> getAllBetweenDates(@Param("startDate") java.util.Date startDate, @Param("endDate") java.util.Date endDate);

}
