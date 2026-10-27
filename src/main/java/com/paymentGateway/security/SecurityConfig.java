    package com.paymentGateway.security;

    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.security.config.Customizer;
    import org.springframework.security.config.annotation.web.builders.HttpSecurity;
    import org.springframework.security.core.userdetails.User;
    import org.springframework.security.core.userdetails.UserDetails;
    import org.springframework.security.core.userdetails.UserDetailsService;
    import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
    import org.springframework.security.crypto.password.PasswordEncoder;
    import org.springframework.security.provisioning.InMemoryUserDetailsManager;
    import org.springframework.security.web.SecurityFilterChain;

    @Configuration
    public class SecurityConfig {
        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

            http
                    .csrf(csrf -> csrf.disable())
                    .headers(headers ->

                            headers.frameOptions(frame -> frame.disable()))
                    .authorizeHttpRequests(auth -> auth

                                    .requestMatchers("/h2-console/**").permitAll()

                                    .requestMatchers("/payments/initiate").authenticated()

                                    .requestMatchers("/payments/bulk").hasRole("ADMIN")

                                    .anyRequest().permitAll()

                    )

                    .httpBasic(Customizer.withDefaults());

            return http.build();
        }

        @Bean
        public UserDetailsService userDetailsService(){

          UserDetails user = User.withUsername("shankar")
                    .password(passwordEncoder().encode("shan123"))
                    .roles("USER")
                    .build();

           UserDetails admin = User.withUsername("admin")
                            .password(passwordEncoder().encode("admin123"))
                            .roles("ADMIN")
                            .build();

                    return new InMemoryUserDetailsManager(user, admin);
        }

        @Bean
        public PasswordEncoder passwordEncoder(){

            return new BCryptPasswordEncoder();
        }
    }
