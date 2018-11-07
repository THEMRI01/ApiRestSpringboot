package com.jcdecaux.recruiting.test;

import static org.junit.Assert.assertTrue;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Base64;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;


import com.jcdecaux.recruiting.RunApplicationSpringBoot;
import com.jcdecaux.recruiting.model.Developpeur;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RunApplicationSpringBoot.class,
webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DevelopperTest {

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	@Before
	public void before() {
		headers.add("Authorization", createHttpAuthenticationHeaderValue(
				"root", "root"));
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	}


	@Test
	public void addDevelopper() {

		Developpeur dev = new Developpeur("nom1", "prenom1", "Entreprise1");

		HttpEntity<Developpeur> entity = new HttpEntity<Developpeur>(dev, headers);

		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/developpeurs"),
				HttpMethod.POST, entity, String.class);

		String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);

		assertTrue(actual.contains("/developpeurs"));

	}

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

	private String createHttpAuthenticationHeaderValue(String userId,
			String password) {

		String auth = userId + ":" + password;

		byte[] encodedAuth = Base64.encode(auth.getBytes(Charset
				.forName("US-ASCII")));

		String headerValue = "Basic " + new String(encodedAuth);

		return headerValue;
	}

}
