package uz.pdp.springbootjpademo.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Courses extends AbsNameEntity {

    @ManyToMany
    private List<Yonalish> yonalishlar;
}
