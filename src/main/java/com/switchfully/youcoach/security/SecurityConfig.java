package com.switchfully.youcoach.security;

import com.switchfully.youcoach.security.authentication.VeryUnsafeFilter;
import com.switchfully.youcoach.security.authentication.user.SecuredUserService;
import com.switchfully.youcoach.security.authorization.RoleToFeatureMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableWebSecurity(debug = true)
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final PasswordEncoder passwordEncoder;
    private String jwtSecret;
    private RoleToFeatureMapper roleToFeatureMapper;
    private SecuredUserService securedUserService;

    public SecurityConfig(SecuredUserService securedUserService, PasswordEncoder passwordEncoder, @Value("${jwt.secret}") String jwtSecret, RoleToFeatureMapper roleToFeatureMapper) {
        this.securedUserService = securedUserService;
        this.passwordEncoder = passwordEncoder;
        this.jwtSecret = jwtSecret;
        this.roleToFeatureMapper = roleToFeatureMapper;
    }
    // ======== step 0 ========
    // Christoph was so kind to disable security
    // (Believe me, security can be quite annoying during development)
    // Remove the 'exclude={SecurityAutoConfiguration.class}'
    //
    // How does it know 'student/student' & 'coach/coach'??
    //
    // TODO: You'll want to replace com.switchfully.youcoach.security.authentication.user.SecuredUserRepositoryFromJson
    // ======== step 1 ========
    // No configuration is roughly the same as
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin();
//    }
    // ======== step 2 ========
    // We have an API + Angular is our front-end)
    // we don't need a nice form, sessions or cookies :-)
    // ONLY FOR INITIAL DEVELOPMENT
    // a 'filter' has been added to provide the user (and roles) in the url
    // http://localhost:8080/users?user=donald&roles=president,us
    // http://localhost:8080/users?user=elizabeth&roles=queen,uk
    // Yes ... it is very unsafe, but also very convenient for development
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.cors().and().csrf().disable().authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .addFilter(new VeryUnsafeFilter(authenticationManager()))
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//    }
     //======== step 3 =========
    // But ... you need to be logged in first ...
    // So ... how can you register?? Chicken-egg-problem
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().authorizeRequests()
                // we want to allow a POST on /users for _EVERYONE_
                .antMatchers(HttpMethod.POST, "/users").permitAll()
                // this is an other example
                .antMatchers("/home", "/public").permitAll()
                // all other requests are secured
                .anyRequest().authenticated()
                .and()
                // not by a form, but by our 'special' security filter
                .addFilter(new VeryUnsafeFilter(authenticationManager()))
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
    // ======== the next step ... JWT =========
//    // POST your username/password to /login
//    // => you will receive a token in return (your secure key)
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.cors().and().csrf().disable().authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .addFilter(new JwtAuthenticationFilter(authenticationManager(), jwtSecret))
//                .addFilter(new JwtAuthorizationFilter(authenticationManager(), jwtSecret, roleToFeatureMapper))
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(securedUserService).passwordEncoder(passwordEncoder);
    }

}
