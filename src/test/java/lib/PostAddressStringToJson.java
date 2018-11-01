package lib;

import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;

import org.assertj.core.util.Lists;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class PostAddressStringToJson {

	private RestTemplate restTemplate;
	private ResponseEntity<String> responseEntity;
	private HttpEntity<String> httpEntity;
	private HttpHeaders httpHeader;
	private String serviceUrl;
	HttpMessageConverter<?> stringHttpMessageConverter;
	List<HttpMessageConverter<?>> httpMessageConverter;
	
	
	public PostAddressStringToJson() {
		restTemplate = new RestTemplate();
		httpHeader = new HttpHeaders();
		httpHeader.setContentType(MediaType.TEXT_PLAIN);
		serviceUrl = "http://localhost:8080";
		httpHeader.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		stringHttpMessageConverter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
		httpMessageConverter = Lists.newArrayList();
		httpMessageConverter.add(stringHttpMessageConverter);
		restTemplate.setMessageConverters(httpMessageConverter);
	}
	
	public ResponseEntity<String> postString(String address, String endPoint) {
		serviceUrl = serviceUrl.concat(endPoint);
		httpEntity = new HttpEntity<String>(address, httpHeader);
		responseEntity = restTemplate.exchange(serviceUrl, HttpMethod.POST, httpEntity, String.class);
		return responseEntity;
	}
	

}
