package io.github.antoniojuniorr.poccacheredis.controller;

import io.github.antoniojuniorr.poccacheredis.entity.Cliente;
import io.github.antoniojuniorr.poccacheredis.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente save(@RequestBody Cliente cliente) {
        return clienteService.save(cliente);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Cliente> findAll() throws InterruptedException {
        return clienteService.findAll();
    }

    @GetMapping(path = "/cash")
    @ResponseStatus(HttpStatus.OK)
    public List<Cliente> recoverCash() {
        return clienteService.recoverCache();
    }
}
