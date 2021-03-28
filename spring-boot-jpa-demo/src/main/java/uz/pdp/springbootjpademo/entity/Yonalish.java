package uz.pdp.springbootjpademo.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Yonalish extends AbsNameEntity {
@OneToMany
    private List<Courses> courses;
}
