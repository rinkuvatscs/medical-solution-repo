package com.aaspaasdoctor.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aaspaasdoctor.entity.Contact;
import com.aaspaasdoctor.service.ContactServiceImpl;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(ContactController.class);
	@Autowired
	private ContactServiceImpl miscServiceImpl;

	@RequestMapping(value = "/addContact", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Contact addContact(@RequestBody Contact contact) {
		return miscServiceImpl.addContact(contact);
	}

	@RequestMapping(value = "/getContact/{email:.+}/email", method = RequestMethod.GET)
	public List<Contact> getContact(@PathVariable String email) {
		return miscServiceImpl.findContactByEmail(email);
	}

	@RequestMapping(value = "/updateContact", method = RequestMethod.PUT)
	public Contact updateContent(@RequestBody Contact contact) {
		try {
			return miscServiceImpl.updateContact(contact);
		} catch (IllegalAccessException | InvocationTargetException e) {
			LOGGER.error("UpdateContact for {} generating {} error ", contact,
					e);
			return new Contact();
		}
	}
}
