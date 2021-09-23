package com.example.randombook;

import com.example.randombook.user.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RandomBookApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RandombookApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void testGetAllUsers() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/user",
				HttpMethod.GET, entity, String.class);

		Assert.assertNotNull(response.getBody());
	}

	@Test
	public void testGetUserById() {
		User user = restTemplate.getForObject(getRootUrl() + "/user/1", User.class);
		System.out.println(user.getEmail());
		Assert.assertNotNull(user);
	}

	@Test
	public void testCreateUser() {
		User user = new User(
				0,
				"lollo",
				"lollo@lollo.com",
				"qwerty123",
				""
		);

		ResponseEntity<User> postResponse = restTemplate.postForEntity(getRootUrl() + "/user", user, User.class);
		Assert.assertNotNull(postResponse);
		Assert.assertNotNull(postResponse.getBody());
	}

	@Test
	public void testUpdatePost() {
		int id = 1;
		User user = restTemplate.getForObject(getRootUrl() + "/user/" + id, User.class);
		User u = new User(
				user.getId(),
				user.getUsername(),
				user.getEmail(),
				"new-super-password",
				user.getPicture()
		);

		restTemplate.put(getRootUrl() + "/user/" + id, user);

		User updatedUser = restTemplate.getForObject(getRootUrl() + "/user/" + id, User.class);
		Assert.assertNotNull(updatedUser);
	}

	@Test
	public void testDeletePost() {
		int id = 3;
		User user = restTemplate.getForObject(getRootUrl() + "/user/" + id, User.class);
		Assert.assertNotNull(user);

		restTemplate.delete(getRootUrl() + "/user/" + id);

		try {
			user = restTemplate.getForObject(getRootUrl() + "/users/" + id, User.class);
		} catch (final HttpClientErrorException e) {
			Assert.assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}

}