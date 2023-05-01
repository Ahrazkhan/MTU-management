package ie.ahraz.MTUmanagement.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;

import java.net.http.HttpClient;

@Configuration
@Profile("test")
public class WebSecurityConfigMemory {
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.authorizeRequests()
//                .antMatchers(HttpMethod.DELETE).hasRole("ADMIN")
//                .antMatchers(HttpMethod.POST).hasRole("ADMIN")
//                .antMatchers("/office/{id}").hasAnyRole("ADMIN","USER")
//                .antMatchers("/department/{id}").hasAnyRole("ADMIN","USER")
//                .antMatchers("/office").permitAll()
//                .antMatchers("/department").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .httpBasic().and().formLogin().and().csrf().disable();
//
//
//
//        return httpSecurity.build();
//    }
//
//    @Bean
//    PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//    @Bean
//    public UserDetailsService users(){
//        String encoded = passwordEncoder().encode("secret");
//        UserDetails user = User.builder().password(encoded).username("user").roles("USER").build();
//        UserDetails admin = User.builder().password(encoded).username("admin").roles("ADMIN").build();
//        return new InMemoryUserDetailsManager(user,admin);
//    }
}
