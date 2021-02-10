package com.ttobagi.web.social.converter;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

import com.ttobagi.web.social.SocialLoginType;

@Configuration
public class SocialLoginTypeConverter implements Converter<String, SocialLoginType> {

	@Override
	public SocialLoginType convert(String source) {
		// TODO Auto-generated method stub
		return SocialLoginType.valueOf(source.toUpperCase());
	}

}
