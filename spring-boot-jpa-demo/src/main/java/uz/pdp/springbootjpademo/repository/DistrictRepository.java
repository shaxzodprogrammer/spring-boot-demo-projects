package uz.pdp.springbootjpademo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.pdp.springbootjpademo.entity.District;
import uz.pdp.springbootjpademo.payload.DistrictDto;

import java.util.List;

public interface DistrictRepository extends JpaRepository<District,Integer> {
    @Query(value = "select * from district where region_id =:regId",nativeQuery = true)
    List<District> allByRegionId(@Param(value = "regId") Integer regionId);

}