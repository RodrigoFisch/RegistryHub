package com.adrtc.RegistryHub.controller.dto;

// DTO de Entrada (In): Não inclui o ID, pois ele será gerado pelo sistema ou banco de dados.

import lombok.Data;

@Data
public class RegisterIn {

    private String id;
    private String name;
    private String cpf;
    private String email;
}
