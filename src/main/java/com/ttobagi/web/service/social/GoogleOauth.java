package com.ttobagi.web.service.social;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class GoogleOauth implements SocialOauth {
	//@Value("${sns.google.url}")
    private final String GOOGLE_SNS_BASE_URL = "https://accounts.google.com/o/oauth2/v2/auth";
    //@Value("${sns.google.client.id}")
    private final String GOOGLE_SNS_CLIENT_ID = "366513921096-deon823lc1if9qll8v098akrg8jpqsqf.apps.googleusercontent.com";
    //@Value("${sns.google.callback.url}")
    private final String GOOGLE_SNS_CALLBACK_URL = "http://localhost:8080/auth/google/callback";
    //@Value("${sns.google.client.secret}")
    private final String GOOGLE_SNS_CLIENT_SECRET = "br9Z0VsCeKdm9EcWcX6uiqFN";
    private final String GOOGLE_SNS_TOKEN_BASE_URL = "https://oauth2.googleapis.com/token";

	@Override
	public String getOauthRedirectURL() {
		Map<String, Object> params = new HashMap<>();
        params.put("scope", "profile");
        params.put("response_type", "code");
        params.put("client_id", GOOGLE_SNS_CLIENT_ID);
        params.put("redirect_uri", GOOGLE_SNS_CALLBACK_URL);
 
        String parameterString = params.entrySet().stream()
                .map(x -> x.getKey() + "=" + x.getValue())
                .collect(Collectors.joining("&"));
 
        return GOOGLE_SNS_BASE_URL + "?" + parameterString;
	}

	@Override
	public String requestAccessToken(String code) {
		RestTemplate restTemplate = new RestTemplate();
		 
        Map<String, Object> params = new HashMap<>();
        params.put("code", code);
        params.put("client_id", GOOGLE_SNS_CLIENT_ID);
        params.put("client_secret", GOOGLE_SNS_CLIENT_SECRET);
        params.put("redirect_uri", GOOGLE_SNS_CALLBACK_URL);
        params.put("grant_type", "authorization_code");
 
        ResponseEntity<String> responseEntity =
                restTemplate.postForEntity(GOOGLE_SNS_TOKEN_BASE_URL, params, String.class);
 
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            return responseEntity.getBody();
        }
        return "구글 로그인 요청 처리 실패";
	}
	@Override
	public String requestUserInfo(String access_token) {
//		 
//        Map<String, Object> params = new HashMap<>();
//        params.put("access_token", access_token);
//        params.put("redirect_uri", "http://localhost:8080/auth/google/userInfo");
//        
//        String parameterString = params.entrySet().stream()
//                .map(x -> x.getKey() + "=" + x.getValue())
//                .collect(Collectors.joining("&"));
//        
//        return "https://www.googleapis.com/oauth2/v3/userinfo" + "?" + parameterString;
		HashMap<String, Object> googleUserInfo = new HashMap<>();
		String reqURL = "https://www.googleapis.com/oauth2/v3/userinfo?access_token="
				+access_token;
		try {
			URL url = new URL(reqURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			conn.setRequestProperty("Authorization", "Bearer " + access_token);
			int responseCode = conn.getResponseCode();
			if(responseCode == 200) {
				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				
				String line = "";
				String result = "";
				
				while((line = br.readLine()) != null) {
					result += line;
				}
				
				JsonParser parser = new JsonParser();
				JsonElement element = parser.parse(result);
				
				String sub = element.getAsJsonObject().get("sub").getAsString();
				
				return sub;
				
			}
		
		}catch(IOException e) {
			e.printStackTrace();
		}
	
		return null;
	}

}
