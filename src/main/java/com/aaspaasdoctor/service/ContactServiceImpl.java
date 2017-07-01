package com.aaspaasdoctor.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaspaasdoctor.entity.Contact;
import com.aaspaasdoctor.repository.ContactRepository;
import com.aaspaasdoctor.utility.BeanMapperUtility;

@Service
public class ContactServiceImpl {

	@Autowired
	private ContactRepository contactRepository;

	public Contact addContact(Contact contact) {
		return contactRepository.save(contact);
	}

	public List<Contact> findContactByEmail(String email) {
		return contactRepository.findByEmail(email);
	}

	public Contact updateContact(Contact contact)
			throws IllegalAccessException, InvocationTargetException {
		Contact tempContact = contactRepository.findOne(contact.getId());
		BeanMapperUtility.copyPropertiesIgnoreNull(contact, tempContact);
		return contactRepository.save(tempContact);
	}

}
