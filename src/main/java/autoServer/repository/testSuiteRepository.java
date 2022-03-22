package autoServer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fasterxml.jackson.module.kotlin.ReflectionCache.BooleanTriState.True;

import autoServer.Entity.TestSuiteEntity;

public interface testSuiteRepository extends JpaRepository<TestSuiteEntity, Long>{
	@Query(value = "select * from testsuite where result = :resuit",nativeQuery = true)
	public int getCountTestSuitePassOrFail(@Param("resuit") String resuil);
	
	@Query(value = "select * from testsuire where create_date >= :startDate and create_date <= :endDate")
	public List<TestSuiteEntity> getTestSuiteByDateStartAndDateEnd(@Param("startDate") String startDate, @Param("endDate")String endDate);
}