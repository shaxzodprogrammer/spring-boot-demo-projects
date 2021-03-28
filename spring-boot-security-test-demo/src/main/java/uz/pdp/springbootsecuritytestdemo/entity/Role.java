package uz.pdp.springbootsecuritytestdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import uz.pdp.springbootsecuritytestdemo.entity.enums.RoleNames;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private RoleNames roleNames;

    @Override
    public String getAuthority() {
        return roleNames.name();
    }

    public Role(RoleNames roleNames) {
        this.roleNames = roleNames;
    }
}
