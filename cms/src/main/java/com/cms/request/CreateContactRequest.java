package com.cms.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateContactRequest {

    private Long id;
    private String firstname;
    private String lastName;
    private String email;
    private String phoneNumber;
}
