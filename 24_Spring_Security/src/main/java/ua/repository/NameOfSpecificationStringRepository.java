package ua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.entity.NameOfSpecificationString;

public interface NameOfSpecificationStringRepository extends JpaRepository<NameOfSpecificationString, Integer>, JpaSpecificationExecutor<NameOfSpecificationString>{

	@Query("SELECT DISTINCT noss FROM Category c JOIN c.nameOfSpecificationStrings noss LEFT JOIN FETCH noss.specificationStrings WHERE c.id=:id")
	List<NameOfSpecificationString> findByCategoryId(@Param("id")int id);

	NameOfSpecificationString findByName(String name);
	@Query("SELECT DISTINCT noss FROM NameOfSpecificationString noss LEFT JOIN FETCH noss.specificationStrings")
	List<NameOfSpecificationString> findAllLoadedSS();

}
