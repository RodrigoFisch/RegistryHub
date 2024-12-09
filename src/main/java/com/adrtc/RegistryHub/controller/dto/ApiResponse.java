package com.adrtc.RegistryHub.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor //Gera um construtor com todos os argumentos da classe.
@NoArgsConstructor //Gera um construtor padrão sem argumentos.
public class ApiResponse {

    @JsonProperty("message")
    private String message;

    @JsonProperty("is_success")
    private boolean success;

}
