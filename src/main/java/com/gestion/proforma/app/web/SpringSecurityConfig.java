package com.gestion.proforma.app.web; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.gestion.proforma.app.web.models.service.UsuarioService;
import com.gestion.proforma.app.web.security.LoginSuccessHandler;

@EnableGlobalMethodSecurity(securedEnabled=true)
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private LoginSuccessHandler successHandler;
	
	@Autowired
	private UsuarioService usuarioService;
		
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
		
	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder builder) throws Exception {		
		builder.userDetailsService(usuarioService).passwordEncoder(passwordEncoder);		
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/","/css/**","/js/**","/img/**","/scss/**","/fonts/**","/h2-console/**").permitAll()			
		.antMatchers("/usuario/**").permitAll()
			.antMatchers("/cliente/**").hasAnyRole("ADMIN")
			.antMatchers("/empleado/**").hasAnyRole("ADMIN")			
			.antMatchers("/proveedor/**").hasAnyRole("ADMIN")			
			.antMatchers("/producto/**").hasAnyRole("ADMIN","USER")			
			.antMatchers("/factura/**").hasAnyRole("USER", "ADMIN")
			.anyRequest().authenticated()
			.and()
			.formLogin().successHandler(successHandler)
			.loginPage("/login").permitAll()
			.and()
			.logout().permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/error_403")
			.and()
			.csrf().ignoringAntMatchers("/h2-console/**")
			.and()
			.headers().frameOptions().sameOrigin();
			
		
}

	

}
