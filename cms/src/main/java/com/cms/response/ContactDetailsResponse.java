package com.cms.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactDetailsResponse {

    private Long id;
    private String firstname;
    private String lastName;
    private String email;
    private String phoneNumber;
}
