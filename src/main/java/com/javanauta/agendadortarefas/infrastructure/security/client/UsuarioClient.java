package com.javanauta.agendadortarefas.infrastructure.security.client;

import com.javanauta.agendadortarefas.busines.dto.UsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

//Se comporta como se fosse um Postman, onde ele faz a requisição no endpoint busca usuario por email
// passando email e token.

@FeignClient(name = "usuario",url = "${usuario.url}")
public interface UsuarioClient {

    @GetMapping("/usuario")
    UsuarioDTO buscaUsuarioPorEmail(@RequestParam("email") String email,
                                    @RequestHeader("Authorization") String token);
}
