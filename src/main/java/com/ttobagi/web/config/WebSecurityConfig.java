package com.ttobagi.web.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private TtobagiAuthenticationSuccessHandler successHandler;
	
	@Bean
	public TtobagiAuthenticationSuccessHandler successHandler() {
		return new TtobagiAuthenticationSuccessHandler();
	}
	
	@Override 
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				//.antMatchers("/**").permitAll() // 편의를 위해 모든 페이지 접근 허용
				// url 아직 뭐뭐있는지 몰라서 일단 아래것만 허가해놓을게요. 주석처리하고 사용하셔도 됩니다 -2/1. 재희-
				.antMatchers("/auth/**", "/user/community/index").permitAll()
				.antMatchers(
						"/user/coupleNote", "/user/community/**",
						"/user/bucketlist/**", "/user/memory/**",
						"/user/diary/**", "/user/letter/**").hasAnyRole("ADMIN", "COUPLE")
				.antMatchers("/user/**").authenticated()
				.antMatchers("/admin/**").hasRole("ADMIN")
				.and()
			.formLogin()
				.loginPage("/auth/login")
				.loginProcessingUrl("/auth/login") // post하는 경로
				.defaultSuccessUrl("/index") // 의도적으로 로그인을 하여 성공한 경우
					//.failureUrl("/auth/reg") failureHandler를 써야할까?
				.successHandler(successHandler)
				.and()
			.logout()
				.logoutUrl("/auth/logout")
				.logoutSuccessUrl("/index")
				.invalidateHttpSession(true)
				.and()
			.csrf()
				.disable();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.jdbcAuthentication()
			.dataSource(dataSource)
			
			// 아이디에 따른 비밀번호 일치여부를 확인한다.
			// id, password, enabled를 뽑아야 스프링이 인식한다.
			.usersByUsernameQuery("select loginId id, password, 1 enabled "
					+ "from member where loginId=?")
			
			// 로그인에 성공한 사용자의 권한을 확인한다. 권한역할의 속성명은 반드시 'ROLE_역할' 형식으로 지정되어야 한다.
			// id, roleId를 뽑아야 스프링이 인식한다.
			.authoritiesByUsernameQuery("select m.loginId id, r.type roleId from memberRole mr"
					+ " join role r on mr.roleId = r.id"
					+ " join member m on mr.memberId = m.id where loginId=?")
			//.authoritiesByUsernameQuery("select loginId id, 'ROLE_SOLO' roleId from member where loginId=?")
			.passwordEncoder(new BCryptPasswordEncoder());
	}
}
