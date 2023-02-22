package com.cms.service.impl;

import com.cms.entity.ContactEntity;
import com.cms.exception.InvalidInputException;
import com.cms.repository.ContactRepository;
import com.cms.request.CreateContactRequest;
import com.cms.response.ContactDetailsResponse;
import com.cms.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

import static com.cms.constant.Constants.*;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    ContactRepository contactRepository;


    /*---- this api will work as create and edit ------
    ------ pass contact id in request for edit -------
    */
    @Override
    public ContactDetailsResponse createContact(CreateContactRequest request) {
        ContactEntity contact = new ContactEntity();
        contact.setFirstName(request.getFirstname());
        contact.setLastName(request.getLastName());
        contact.setEmail(request.getEmail());
        contact.setPhoneNumber(request.getPhoneNumber());
        if(request.getId()!=0){
            ContactEntity contactEntity = contactRepository.findById(request.getId()).
                    orElseThrow(() -> new InvalidInputException(INVALID_CONTACT_ID,
                                    INVALID_CONTACT_ID_ERROR_CODE,
                                    INVALID_CONTACT_ID_ERROR_MESSAGE));
            contact.setId(contactEntity.getId());
        }
        ContactEntity contactEntity = contactRepository.save(contact);
        return responseConverter(contactEntity);
    }

    @Override
    public List<ContactDetailsResponse> viewContact(String firstName, String lastName, String email) {
        List<ContactEntity> entities = contactRepository.findContactByFilter(firstName,lastName,email);

        return entities.stream().map(this::responseConverter).collect(Collectors.toList());
    }

    @Override
    public Object deleteContact(Long id) {
        ContactEntity contactEntity = contactRepository.findById(id).orElseThrow(() ->
                        new InvalidInputException(INVALID_CONTACT_ID,
                                INVALID_CONTACT_ID_ERROR_CODE,
                                INVALID_CONTACT_ID_ERROR_MESSAGE));
        contactEntity.setActive(false);
        contactRepository.save(contactEntity);

        return CONTACT_DELETED_SUCCESSFULLY;
    }

    private ContactDetailsResponse responseConverter(ContactEntity entity){
        return  ContactDetailsResponse.builder().id(entity.getId()).email(entity.getEmail())
                .firstname(entity.getFirstName()).lastName(entity.getLastName()).phoneNumber(entity.getPhoneNumber()).build();

    }
}
