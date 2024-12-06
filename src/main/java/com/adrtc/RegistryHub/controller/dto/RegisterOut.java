package com.adrtc.RegistryHub.controller.dto;

//DTO de Saída (Out): Inclui o ID, pois é necessário para a identificação do recurso na resposta.

import lombok.Data;

@Data
public class RegisterOut {

    private String name;
    private String cpf;
    private String email;
}
