package com.fx.loja;

import com.fx.loja.controller.AcessoController;
import com.fx.loja.model.Acesso;
import com.fx.loja.repository.AcessoRepository;
import com.fx.loja.service.AcessoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = LojaVirtualApplication.class)
public class DemoApplicationTests {

    @Autowired
    private AcessoController acessoController;
    @Test
    public  void testCadastrarAcesso() {

        Acesso acesso = new Acesso();
        acesso.setDescricao("ROLE_ADMIN");
        acessoController.salvarAcesso(acesso);
    }

}
