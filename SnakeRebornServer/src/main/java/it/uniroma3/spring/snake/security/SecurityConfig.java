package it.uniroma3.spring.snake.security;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
 
	
	@Autowired
	DataSource dataSource;
	
    @Bean
    public PasswordEncoder passwordEncoder() {
    	PwdEncoder pwdEncoder = PwdEncoder.getInstance();
    	return pwdEncoder.getPasswordEncoder();
    }
	
	@Autowired
	protected void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication().dataSource(dataSource)
		.passwordEncoder(passwordEncoder())
		.usersByUsernameQuery("SELECT username,password,1 FROM player WHERE username=?")
		.authoritiesByUsernameQuery("SELECT username,role FROM player WHERE username=?")
		.and().inMemoryAuthentication().withUser("SnakeReborn").password("Snake123").roles("ADMIN");
		
	}
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
        .authorizeRequests()
            .antMatchers("/profile").authenticated()
            .anyRequest().permitAll()
            .and()
        .formLogin()
            .loginPage("/loginUser").defaultSuccessUrl("/profile")
            .usernameParameter("username").passwordParameter("password")
            .permitAll()
            .and()
        .logout()
        	.logoutUrl("/logout")
        	.permitAll()
        	.and()
        .csrf().disable();
    }
}