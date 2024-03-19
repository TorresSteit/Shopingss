package com.example.shoping.confirution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/home").permitAll() // Разрешаем доступ к главной странице всем
                .antMatchers("/admin/**").hasRole("ADMIN") // Требуем роль ADMIN для доступа к страницам администратора
                .antMatchers("/products/add", "/categories/add").hasRole("ADMIN") // Требуем роль ADMIN для добавления товаров и категорий
                .anyRequest().authenticated() // Остальные запросы требуют аутентификации
                .and()
                .formLogin()
                .loginPage("/login") // Указываем страницу входа
                .permitAll() // Разрешаем всем доступ к странице входа
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // Указываем URL для выхода
                .logoutSuccessUrl("/login?logout") // После выхода перенаправляем на страницу входа с параметром logout
                .permitAll(); // Разрешаем всем доступ к выходу из системы
    }


}
