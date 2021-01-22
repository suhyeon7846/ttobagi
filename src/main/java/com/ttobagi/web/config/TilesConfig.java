package com.ttobagi.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.tiles3.SimpleSpringPreparerFactory;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
public class TilesConfig {
	@Bean
	public TilesConfigurer tilesConfigurer() {// tiles 설정이 어디에 되어있다~~ 라고 알려
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setDefinitions(new String[] { "/WEB-INF/tiles.xml" });
		tilesConfigurer.setCheckRefresh(true);
		// ViewPreparer에서 Autowired가 가능하게 하는 설정
		tilesConfigurer.setPreparerFactoryClass(SimpleSpringPreparerFactory.class);
		return tilesConfigurer;
	}

	@Bean
	public TilesViewResolver tilesViewResolver() {
		// 사용자로부터 요청이 들어오면 controller에서 return하는 tiles이름을 확인하고,
		// 그 view와 tiles.xml의 이름을 맞춰보고 그에 맞는 view를 반환해줌
		TilesViewResolver viewResolver = new TilesViewResolver();
		viewResolver.setViewClass(TilesView.class);
		viewResolver.setOrder(1);// dispatcherServlet에서 viewResolver를 찾을때 1번으로 찾도록

		return viewResolver;
	}
}
