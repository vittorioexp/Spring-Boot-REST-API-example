package com.example.randombook;

import com.example.randombook.customer.Customer;
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

		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/customer",
				HttpMethod.GET, entity, String.class);

		System.out.println(response);

		Assert.assertNotNull(response.getBody());
	}

	@Test
	public void testGetCustomerById() {
		Customer customer = restTemplate.getForObject(getRootUrl() + "/customer/1", Customer.class);
		System.out.println(customer.getEmail());
		Assert.assertNotNull(customer);
	}

	@Test
	public void testCreateCustomer() {
		Customer customer = new Customer(
				0,
				"lollo",
				"lollo@lollo.com",
				"qwerty123",
				""
		);

		ResponseEntity<Customer> postResponse = restTemplate.postForEntity(getRootUrl() + "/customer", customer, Customer.class);
		Assert.assertNotNull(postResponse);
		Assert.assertNotNull(postResponse.getBody());
	}

	@Test
	public void testUpdatePost() {
		int id = 1;
		Customer customer = restTemplate.getForObject(getRootUrl() + "/customer/" + id, Customer.class);
		Customer u = new Customer(
				customer.getId(),
				customer.getUsername(),
				customer.getEmail(),
				"new-super-password",
				customer.getPicture()
		);

		restTemplate.put(getRootUrl() + "/customer/" + id, customer);

		Customer updatedCustomer = restTemplate.getForObject(getRootUrl() + "/customer/" + id, Customer.class);
		Assert.assertNotNull(updatedCustomer);
	}

	@Test
	public void testDeletePost() {
		int id = 3;
		Customer customer = restTemplate.getForObject(getRootUrl() + "/customer/" + id, Customer.class);
		Assert.assertNotNull(customer);

		restTemplate.delete(getRootUrl() + "/customer/" + id);

		try {
			customer = restTemplate.getForObject(getRootUrl() + "/customer/" + id, Customer.class);
		} catch (final HttpClientErrorException e) {
			Assert.assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}

}