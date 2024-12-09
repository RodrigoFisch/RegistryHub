package com.adrtc.RegistryHub.service;

import com.adrtc.RegistryHub.controller.dto.ApiResponse;
import com.adrtc.RegistryHub.controller.dto.RegisterIn;
import com.adrtc.RegistryHub.controller.dto.RegisterOut;
import com.adrtc.RegistryHub.domain.RegisterPerson;
import com.adrtc.RegistryHub.repository.RegisterPersonRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UseRegistryHub {

    @Autowired
    private RegisterPersonRepository personRepository;

    @Autowired
    private ModelMapper mapper;

    public RegisterOut creat(RegisterIn registerIn){
        RegisterPerson registerPerson = mapper.map(registerIn, RegisterPerson.class);
        personRepository.save(registerPerson);
        RegisterOut registerOut = mapper.map(registerPerson, RegisterOut.class);
        return registerOut;
    }

    public RegisterOut updateByCpf(String cpf, RegisterIn registerIn){
        Optional<RegisterPerson> optional = personRepository.findByCpf(cpf);
        RegisterPerson upDataRegister = optional.get();
        mapper.map(registerIn, upDataRegister);
        personRepository.save(upDataRegister);
        RegisterOut registerOut = mapper.map(upDataRegister, RegisterOut.class);
        return registerOut;
    }

    public String deleteByCpf(String cpf){
        Optional<RegisterPerson> optional = personRepository.findByCpf(cpf);
        personRepository.delete(optional.get());

        return "Registro deletado";
    }

    public RegisterOut consultByCpf(String cpf){
        Optional<RegisterPerson> optional = personRepository.findByCpf(cpf);
        RegisterPerson lookingFor = optional.get();
        RegisterOut registerOut =mapper.map(lookingFor, RegisterOut.class);
        return registerOut;
    }

    public List<RegisterOut> readRegisters(){
        List<RegisterPerson> registerPersonList = personRepository.findAll();
        List<RegisterOut> registerOuts = mapper.map(registerPersonList, new TypeToken<List<RegisterOut>>()
        {}.getType());
        return registerOuts;
    }
}
