package com.mtattab.emailservice.config;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.mtattab.emailservice.consts.Constants.WEB_DOMAIN_HTTP;
import static com.mtattab.emailservice.consts.Constants.WEB_DOMAIN_HTTPS;


@Configuration
public class ProjectSecurityConfig  {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeRequests().anyRequest().permitAll()
//                .and()
//                .csrf().disable();

        List<String> allowedDomains = new ArrayList<>();
        allowedDomains.add(WEB_DOMAIN_HTTPS);
        allowedDomains.add(WEB_DOMAIN_HTTP);

        http.authorizeRequests()
                .requestMatchers("/","/about","/actuator/health").permitAll()
                .requestMatchers("/css/**","/img/**","/js/**").permitAll()


        .anyRequest().authenticated().and().oauth2Login()
                .and().logout().logoutSuccessUrl("/")
                .and().cors(
                        corsCustomizer -> corsCustomizer.configurationSource(new CorsConfigurationSource() {
                            @Override
                            public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                                CorsConfiguration config = new CorsConfiguration();
                                config.setAllowedOrigins(allowedDomains);
                                config.setAllowedMethods(Collections.singletonList("*"));
                                config.setAllowCredentials(true);
                                config.setAllowedHeaders(Collections.singletonList("*"));
                                config.setMaxAge(3600L);
                                return config;
                            }
                        }
                    )
                )

;
        return http.build();
    }

}
