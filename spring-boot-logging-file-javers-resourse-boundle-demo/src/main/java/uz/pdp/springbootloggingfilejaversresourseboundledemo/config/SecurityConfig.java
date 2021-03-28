package uz.pdp.springbootloggingfilejaversresourseboundledemo.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import uz.pdp.springbootloggingfilejaversresourseboundledemo.security.JwtFilter;
import uz.pdp.springbootloggingfilejaversresourseboundledemo.service.AuthService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, jsr250Enabled = true, prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    AuthService authService;

//    @Bean
//    public AuthorProvider provideJaversAuthor() {
//        return new SimpleAuthorProvider();
//    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder managerBuilder) throws Exception {
        managerBuilder.userDetailsService(authService).passwordEncoder(passwordEncoder());
    }


    @Bean
    JwtFilter jwtFilter() {
        return new JwtFilter();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
        http
                .cors()
                .and()
                .csrf()
                .disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/api/auth/**", "/api/pdpIntegration/**")
                .permitAll()
                .antMatchers("/api/**")
                .authenticated();

        http.addFilterBefore(jwtFilter(), UsernamePasswordAuthenticationFilter.class);
    }

//    private static class SimpleAuthorProvider implements AuthorProvider {
//        @Override
//        public String provide() {
//            User user = SecurityContextHolder.getContext() != null ?
//                    (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal() : null;
//            return user == null ? currentRequest().getHeader("financeSecretHeader")!=null? "Pdp Platforma":null: user.getFirstName().substring(0,1)+'.'+user.getLastName()+' '+user.getPhoneNumber();
////            return "CreateAlways";
//        }
//        private HttpServletRequest currentRequest() {
//            // Use getRequestAttributes because of its return null if none bound
//            ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//            return Optional.ofNullable(servletRequestAttributes).map(ServletRequestAttributes::getRequest).orElse(null);
//        }
//    }


}
