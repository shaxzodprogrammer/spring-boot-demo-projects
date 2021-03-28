package uz.pdp.springbootjpademo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.springbootjpademo.entity.Region;
import uz.pdp.springbootjpademo.projection.RegionProjection;

@RepositoryRestResource(path ="region", collectionResourceRel = "list", excerptProjection = RegionProjection.class)// exported false qilsak qaysidir methodni ishlamaydigan qilib qo'yish mumkin delete methodini masalan
public interface RegionRepository extends JpaRepository<Region,Integer> { //yugurdak
}