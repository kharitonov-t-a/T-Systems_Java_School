package com.web.shop.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("customUserDetailsService")
    UserDetailsService userDetailsService;

//    @Autowired
//    PersistentTokenRepository tokenRepository;

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().antMatchers("/", "/list").access("hasRole('USER') or hasRole('ADMIN') or hasRole('DBA')")
//                .antMatchers("/newuser/**", "/delete-user-*").access("hasRole('ADMIN')")
//                .antMatchers("/edit-user-*").access("hasRole('ADMIN') or hasRole('DBA')")
//                .and().formLogin()
//                .loginPage("/login")
//                .loginProcessingUrl("/j_spring_security_check")
//                .usernameParameter("email")
//                .passwordParameter("password")
//                .and()
//                /*.rememberMe().rememberMeParameter("remember-me")*///.tokenRepository(tokenRepository)
//                /*.tokenValiditySeconds(86400)*//*.and()*/.csrf().and().exceptionHandling().accessDeniedPage("/Access_Denied");
//        http.authorizeRequests()
//                .antMatchers("/profile/**").hasAnyRole("ADMIN","USER")
//                .and().formLogin()  //login configuration
//                .loginPage("/login")
//                .loginProcessingUrl("/j_spring_security_check")
//                .usernameParameter("email")
//                .passwordParameter("password")
//                .defaultSuccessUrl("/index")
//                .failureUrl("/login?error")
//                .permitAll()
//                .and().logout()    //logout configuration
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/login?logout")
//                .permitAll()
//                .and().exceptionHandling() //exception handling configuration
//                .accessDeniedPage("/user/error");
//        http.authorizeRequests().and()
//                .formLogin().loginPage("/login")
//                .loginProcessingUrl("/login").
//                usernameParameter("email")
//                .passwordParameter("password").and()
//                /*.rememberMe().rememberMeParameter("remember-me").tokenRepository(tokenRepository)
//                .tokenValiditySeconds(86400).and()*/.csrf().and().exceptionHandling().accessDeniedPage("/Access_Denied");

        // включаем защиту от CSRF атак
        http.csrf()
                .disable()
                // указываем правила запросов
                // по которым будет определятся доступ к ресурсам и остальным данным
                .authorizeRequests()
                .antMatchers("/list").access("hasRole('ADMIN') or hasRole('MANAGER')")
                .antMatchers("/delete-user-*").access("hasRole('ADMIN') or hasRole('MANAGER')")
        //access("hasRole('USER') or hasRole('ADMIN') or hasRole('DBA')")
//                .antMatchers("/resources/**", "/**").permitAll()
//                .anyRequest().permitAll()
        /*.and()*/;

        http.formLogin()
                // указываем страницу с формой логина
                .loginPage("/login")
                // указываем action с формы логина
                .loginProcessingUrl("/login")
                // указываем URL при неудачном логине
                .failureUrl("/login?error")
                // Указываем параметры логина и пароля с формы логина
                .usernameParameter("email")
                .passwordParameter("password")
                // даем доступ к форме логина всем
                .permitAll();

        http.logout()
                // разрешаем делать логаут всем
                .permitAll()
                // указываем URL логаута
                .logoutUrl("/logout")
                // указываем URL при удачном логауте
                .logoutSuccessUrl("/login?logout")
                // делаем не валидной текущую сессию
                .invalidateHttpSession(true);
        http.exceptionHandling().accessDeniedPage("/Access_Denied");


    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

//    @Bean
//    public PersistentTokenBasedRememberMeServices getPersistentTokenBasedRememberMeServices() {
//        PersistentTokenBasedRememberMeServices tokenBasedservice = new PersistentTokenBasedRememberMeServices(
//                "remember-me", userDetailsService, tokenRepository);
//        return tokenBasedservice;
//    }

    @Bean
    public AuthenticationTrustResolver getAuthenticationTrustResolver() {
        return new AuthenticationTrustResolverImpl();
    }

}