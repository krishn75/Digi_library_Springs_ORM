package com.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
@Configuration
@EnableWebSecurity
public class Security_Config extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private BCryptPasswordEncoder be;
	
	@Autowired
	private UserDetailsService uds;
	
	public void global_Configure(AuthenticationManagerBuilder ab) throws Exception {
		ab.userDetailsService(uds).passwordEncoder(be);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/reg").permitAll()
		.antMatchers("/userreg").permitAll()
		.antMatchers("/checkId").permitAll()
		.antMatchers("/admin").hasAuthority("ADMIN")
		.antMatchers("/user").hasAuthority("USER")
		.antMatchers("/select").hasAuthority("ADMIN")
		.antMatchers("/approve").hasAuthority("ADMIN")
		.antMatchers("/Approvereg").hasAuthority("ADMIN")
		.antMatchers("/cat").hasAuthority("ADMIN")
		.antMatchers("/catreg").hasAuthority("ADMIN")
		.antMatchers("/book").hasAuthority("ADMIN")
		.antMatchers("/bookreg").hasAuthority("ADMIN")
		.antMatchers("/books_list").hasAuthority("USER")
		.antMatchers("/Issue_Book/{bid}/{qty}").hasAuthority("USER")
		.antMatchers("/return_page").hasAuthority("USER")
		.antMatchers("/Return_Book").hasAuthority("USER")
		.anyRequest()
		.authenticated()
		.and()
		

		.formLogin()
		.loginPage("/Login").permitAll()
		.loginProcessingUrl("/loginPros").permitAll()
		.usernameParameter("username")
		.passwordParameter("password")
		.successForwardUrl("/home")
		.and()
		
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/login?logout")
		
		.and()
		.exceptionHandling().accessDeniedPage("/error")
		
		.and()
		.csrf().disable();
	}

}
