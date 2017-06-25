package com.aaspaasdoctor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaspaasdoctor.entity.Message;
import com.aaspaasdoctor.repository.MessageRepository;

@Service
@Transactional
public class MessageServiceImpl {

	@Autowired
	private MessageRepository messageRepository;

	public List<Message> getAllMessages() {
		return (List<Message>) messageRepository.findAll();
	}

	public Message addMessage(Message message) {
		return messageRepository.save(message);
	}

	public List<Message> findByPatientId(Integer patientId) {
		return messageRepository.findByPatientId(patientId);
	}

	public List<Message> findByDoctorId(Integer doctorId) {
		return messageRepository.findByDoctorId(doctorId);
	}

	public Message updateMessage(Message message) {
		Message tempMessage = messageRepository.findOne(message.getId());

		if (tempMessage != null && message.getMessage() != null) {
			tempMessage.setMessage(message.getMessage());
			tempMessage.setStatus(message.getStatus());
			return messageRepository.save(tempMessage);

		} else {
			return new Message();
		}

	}

	public Message deleteByMessageId(Integer messageId) {

		Message message = messageRepository.findOne(messageId);
		if (message != null) {
			messageRepository.delete(message);
			return message;
		} else {
			return new Message();
		}
	}

}
