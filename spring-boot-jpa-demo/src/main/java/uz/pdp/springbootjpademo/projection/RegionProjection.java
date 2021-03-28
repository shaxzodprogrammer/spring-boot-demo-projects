package uz.pdp.springbootjpademo.projection;

//import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;
//import uz.pdp.springbootjpademo.entity.District;
import uz.pdp.springbootjpademo.entity.Region;
//import uz.pdp.springbootjpademo.payload.DistrictDto;

import java.util.List;

@Projection(name = "regionProjection",types = Region.class)
public interface RegionProjection {
    Integer getId();
    String getName();
//
//    @Value("#{@districtRepository.allByRegionId(target.id)}")
//    List<District> getAllByRegionId();

}