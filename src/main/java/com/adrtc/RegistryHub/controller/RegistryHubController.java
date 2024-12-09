package com.adrtc.RegistryHub.controller;

import com.adrtc.RegistryHub.controller.dto.RegisterIn;
import com.adrtc.RegistryHub.controller.dto.RegisterOut;
import com.adrtc.RegistryHub.service.UseRegistryHub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("register-person")
public class RegistryHubController {


    @Autowired
    private UseRegistryHub useRegistryHub;

    @PostMapping
    public ResponseEntity<RegisterOut> create(@RequestBody RegisterIn registerIn) {
        //log.info("Cadastro realizado: {}", registerIn);
        RegisterOut registerOut = useRegistryHub.create(registerIn);
        return ResponseEntity.ok(registerOut);
    }

    @PutMapping("cpf/{cpf}")
    public ResponseEntity<RegisterOut> upDateCpf(@PathVariable("cpf") String cpf,
                                                 @RequestBody RegisterIn registerIn){
        //log.info("Cadastro atualizado: {}, {}", registerIn);
        RegisterOut registerOut = useRegistryHub.updateByCpf(cpf, registerIn);
        return ResponseEntity.ok(registerOut);
    }

    @DeleteMapping("cpf/{cpf}")
    public ResponseEntity<String> deleteByCpf(@PathVariable("cpf") String cpf){
        //log.info("Cadastro excluido: {}", cpf);
        String string = useRegistryHub.deleteByCpf(cpf);
        return ResponseEntity.ok(string);
    }

    @GetMapping("cpf/{cpf}")
    public ResponseEntity<RegisterOut> consultByCpf(@PathVariable("cpf") String cpf){
        //log.info("Consulta: {}", cpf);
        RegisterOut registerOut = useRegistryHub.consultByCpf(cpf);
        return ResponseEntity.ok(registerOut);
    }

    @GetMapping("all")
    public ResponseEntity<List<RegisterOut>> registerList(){
        //log.info("Usuários cadastrados" );
        List<RegisterOut> registerOut = useRegistryHub.readRegisters();
        return ResponseEntity.ok(registerOut);
    }

}
