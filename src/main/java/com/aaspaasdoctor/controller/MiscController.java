package com.aaspaasdoctor.controller;

import java.lang.reflect.InvocationTargetException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aaspaasdoctor.entity.Contact;
import com.aaspaasdoctor.service.MiscServiceImpl;

@RestController
@RequestMapping("/api/misc")
public class MiscController {

	@Autowired
	private MiscServiceImpl miscServiceImpl;

	/*
	 * @RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces =
	 * MediaType.APPLICATION_JSON_VALUE, value = "/singleto", method =
	 * RequestMethod.POST)
	 * 
	 * @ResponseStatus(HttpStatus.CREATED) public Response
	 * sendEmail_SingleTO(@RequestBody
	 * com.medical.solutions.request.MiscEmailRequest miscEmailRequest) {
	 * 
	 * Email email = new Email(); try {
	 * BeanUtils.copyProperties(miscEmailRequest, email); } catch
	 * (BeansException beansException) { throw new
	 * BadRequestException("Email address is not correct", beansException); }
	 * 
	 * if (!StringUtils.isEmpty(email) && !StringUtils.isEmpty(email.getTo()) &&
	 * !StringUtils.isEmpty(email.getMessage())) { return new
	 * Response(miscFactory.getMiscService().sendMail(email)); } else { throw
	 * new BadRequestException("Receiver's address and message can't be blank");
	 * } }
	 * 
	 * @RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces =
	 * MediaType.APPLICATION_JSON_VALUE, value = "/singletomultiplecc", method =
	 * RequestMethod.POST)
	 * 
	 * @ResponseStatus(HttpStatus.CREATED)
	 * 
	 * @ApiOperation(value = "add new email", notes = "add new email")
	 * 
	 * @ApiResponses(value = { @ApiResponse(code = 400, message =
	 * "Fields are with validation errors"),
	 * 
	 * @ApiResponse(code = 201, message = "") }) public Response
	 * emailSingleTO_MultipleCC(
	 * 
	 * @RequestBody com.medical.solutions.request.MiscEmailRequest
	 * miscEmailRequest) {
	 * 
	 * Email email = new Email(); try {
	 * BeanUtils.copyProperties(miscEmailRequest, email); } catch
	 * (BeansException beansException) { throw new
	 * BadRequestException("Email address is not correct", beansException); }
	 * 
	 * if (!StringUtils.isEmpty(email) && !StringUtils.isEmpty(email.getTo()) &&
	 * !StringUtils.isEmpty(email.getMessage())) { return new
	 * Response(miscFactory.getMiscService().SingleTo_MultipleCC(email)); } else
	 * { throw new
	 * BadRequestException("Receiver's address and message can't be blank"); } }
	 */
	@RequestMapping(value = "/addContact", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Contact addContact(@RequestBody Contact contact) {
		return miscServiceImpl.addContact(contact);
	}

	@RequestMapping(value = "/getContact/{email}/email", method = RequestMethod.GET)
	public Contact getContact(@PathVariable String email) {
		return miscServiceImpl.findContactByEmail(email);
	}

	@RequestMapping(value = "/updateContact", method = RequestMethod.PUT)
	public Contact updateContent(@RequestBody Contact contact)
			throws IllegalAccessException, InvocationTargetException {

		return miscServiceImpl.updateContact(contact);
	}
}
