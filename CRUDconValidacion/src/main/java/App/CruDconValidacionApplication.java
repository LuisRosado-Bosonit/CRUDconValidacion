package App;

import App.Utils.JWTAuthorizationFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@SpringBootApplication
public class CruDconValidacionApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruDconValidacionApplication.class, args);
	}

	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//
//		@Override
//		public void configure(WebSecurity web) throws Exception {
//			web.ignoring()
//					.antMatchers("/h2-console/**");
//		}


//		@Override
//		protected void configure(HttpSecurity http) throws Exception {
//			http.csrf().disable()
//					.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
//					.authorizeRequests()
//					.antMatchers(HttpMethod.POST, "/user").permitAll()
//					.antMatchers(HttpMethod.POST, "/persona/add").permitAll()
////					.antMatchers(HttpMethod.DELETE,"/persona").hasRole("ADMIN")
////					.antMatchers(HttpMethod.PUT,"/persona").hasRole("ADMIN")
//					.anyRequest().authenticated();
//
//
//
//
//		}


		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable()
					.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
					.authorizeRequests()
					.antMatchers(HttpMethod.POST, "/user").permitAll()
					.antMatchers(HttpMethod.POST, "/persona/add").permitAll()
					.antMatchers(HttpMethod.GET).hasAnyRole("ADMIN","USER")
					.antMatchers(HttpMethod.POST).hasRole("ADMIN")
					.antMatchers(HttpMethod.GET).hasRole("ADMIN")
					.antMatchers(HttpMethod.PUT).hasRole("ADMIN")
					.antMatchers(HttpMethod.DELETE).hasRole("ADMIN")
					.anyRequest().authenticated();
		}




	}

}
