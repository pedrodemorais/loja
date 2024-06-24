package com.fx.loja.service;

import com.fx.loja.model.Acesso;
import com.fx.loja.repository.AcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AcessoService {

    @Autowired
    private AcessoRepository acessoRepository;

    public Acesso save (Acesso acesso){

       return acessoRepository.save(acesso);

    }
}
