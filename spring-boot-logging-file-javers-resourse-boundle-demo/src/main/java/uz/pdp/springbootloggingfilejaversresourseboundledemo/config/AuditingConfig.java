package uz.pdp.springbootloggingfilejaversresourseboundledemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.UUID;

@Configuration
@EnableJpaAuditing
public class AuditingConfig {


    public AuditorAware<UUID> auditorProvider() {
        return new AuditorAwareImpl();
    }
}
