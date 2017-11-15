package is.hi.foodbar.configuration;


import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Karítas Sif Halldórsdóttir ksh18@hi.is
 * @date Nóvember 2017
 * HBV501G Hugbúnarverkefni 1 Háskóli Íslands
 *
 * Configuration for webSecurity in spring
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin", "/admin/**").authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .successForwardUrl("/admin/addRestaurant")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("hug").password("123").roles("ADMIN");
    }
}