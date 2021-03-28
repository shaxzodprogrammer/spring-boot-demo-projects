package uz.pdp.springbootjpademo.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class LearningCenter extends AbsNameEntity {

    @Column
    private String online;
    @Column
    private String offline;
    @Column
    private String onsite;

    @ManyToMany
    private List<Courses> courses;

}
