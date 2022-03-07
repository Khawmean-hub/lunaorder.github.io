package com.kosign.luna.configuration;


import com.kosign.luna.configuration.jwconfiguration.JwtAuthenticationEntryPoint;
import com.kosign.luna.configuration.jwconfiguration.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private BCryptPasswordEncoder encoder;
    @Autowired
    JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    @Autowired
    JwtRequestFilter jwtRequestFilter;



    private UserDetailsService userDetailsService;

    @Autowired
    public void setUserDetailsService(@Qualifier("userServiceImp") UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf()
                .disable()
                .headers()
                .frameOptions()
                .deny()
                .and()
                .authorizeRequests()
                .antMatchers(
                        HttpMethod.GET,
                        "/",
                        "/*.html",
                        "/chart",
                        "/favicon.ico",
                        "//*.html",
                        "//*.css",
                        "//*.js"
                ).permitAll()
                .antMatchers("/login","/luna-app-websocket",
                "/lunaChart",
                "/rest/**",
                "/luna/app",
                "/uploadFile",
                "/uploadMultipleFiles",
                "/downloadFile/**",
                "/category",
                "/delete/**",
                "/luna").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/upload").permitAll()

                .antMatchers("/check").hasAnyRole("ADMIN", "USER")
                
                .antMatchers("/user/**").hasRole("ADMIN")
                .antMatchers("/prudcut/**").hasAnyRole("ADMIN", "USER")

                .anyRequest().authenticated()
                .and().exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
    }



    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/v2/api-docs",
                "/configuration/ui",
                "/swagger-resources/**",
                "/configuration/security",
                "/swagger-ui.html",
                "/images/**",
                "/webjars/**",
                "/login",
                "/api/v1/profile"
        );
    }
}
