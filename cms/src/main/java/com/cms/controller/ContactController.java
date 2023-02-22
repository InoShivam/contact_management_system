package com.cms.controller;

import com.cms.request.CreateContactRequest;
import com.cms.response.BaseApiResponse;
import com.cms.response.ResponseBuilder;
import com.cms.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.cms.constant.RestMappingConstants.ContactManagementSystemUri.*;


@RestController
public class ContactController {

    @Autowired
    ContactService contactService;

    @PostMapping(path = CONTACT)
    public ResponseEntity<BaseApiResponse> createContact(@RequestBody CreateContactRequest request){
        BaseApiResponse baseApiResponse = ResponseBuilder.getSuccessResponse(contactService.createContact(request));
        return new ResponseEntity<>(baseApiResponse, HttpStatus.OK);

    }
    @PutMapping(path = CONTACT)
    public ResponseEntity<BaseApiResponse> editContact(@RequestBody CreateContactRequest request){
        BaseApiResponse baseApiResponse = ResponseBuilder.getSuccessResponse(contactService.createContact(request));
        return new ResponseEntity<>(baseApiResponse, HttpStatus.OK);

    }

    @GetMapping(path = VIEW_CONTACT)
    public ResponseEntity<BaseApiResponse> viewContact(@RequestParam(required = false) String firstName,
                                                       @RequestParam(required = false) String lastName, @RequestParam(required = false) String email){
        BaseApiResponse baseApiResponse = ResponseBuilder.getSuccessResponse(contactService.viewContact(firstName,lastName,email));
        return new ResponseEntity<>(baseApiResponse, HttpStatus.OK);
    }

    @DeleteMapping(path = DELETE_CONTACT)
    public ResponseEntity<BaseApiResponse> deleteContact(@RequestParam Long id){
        BaseApiResponse baseApiResponse = ResponseBuilder.getSuccessResponse(contactService.deleteContact(id));
        return new ResponseEntity<>(baseApiResponse, HttpStatus.OK);
    }






}
