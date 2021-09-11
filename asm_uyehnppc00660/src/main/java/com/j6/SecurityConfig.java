package com.j6;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.j6.entity.Accounts;
import com.j6.service.AccountsService;


@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	AccountsService accountsService;

	@Autowired
	BCryptPasswordEncoder pEncoder;

	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(username -> {
			try {
				Accounts accounts = accountsService.findById(username);
				String password = accounts.getPassword(); 
				String[] roles = accounts.getAuthorities().stream().map(au -> au.getRole().getId())
						.collect(Collectors.toList()).toArray(new String[0]); 
				return User.withUsername(username).password(pEncoder.encode(password)).roles(roles).build();
			} catch (Exception e) {
				throw new UsernameNotFoundException(username + e);
			}
		});
	}

	// Phân quyền 
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().cors().disable();
		http.authorizeRequests().antMatchers("/order/**").authenticated().antMatchers("/assets/admin/**")
				.hasAnyRole("Admin").antMatchers("/rest/authorities").hasRole("PM").anyRequest().permitAll();

		http.formLogin().loginPage("/security/login/form") 
				.loginProcessingUrl("/security/login")
				.defaultSuccessUrl("/security/login/success", false).failureUrl("/security/login/error") 
																											
				.usernameParameter("username").passwordParameter("password"); 
		http.rememberMe().tokenValiditySeconds(86400);

		http.exceptionHandling().accessDeniedPage("/security/unauthoried"); 

		http.logout().logoutUrl("/security/logoff").logoutSuccessUrl("/security/logoff/success");
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
	}

}
