package com.adrtc.RegistryHub.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document()
public class RegisterPerson {

    private String id;
    private String name;
    private String cpf;
    private String email;

}
