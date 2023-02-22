package com.cms.service;

import com.cms.request.CreateContactRequest;
import com.cms.response.ContactDetailsResponse;

import java.util.List;


public interface ContactService {
    ContactDetailsResponse createContact(CreateContactRequest request);

    List<ContactDetailsResponse> viewContact(String firstName, String lastName, String email);

    Object deleteContact(Long id);
}
