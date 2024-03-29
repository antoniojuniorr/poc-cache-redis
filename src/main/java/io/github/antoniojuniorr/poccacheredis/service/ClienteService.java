package io.github.antoniojuniorr.poccacheredis.service;

import io.github.antoniojuniorr.poccacheredis.entity.Cliente;
import io.github.antoniojuniorr.poccacheredis.repository.ClienteRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class ClienteService {

    private final ClienteRepository clienteRepository;

    private final RedisTemplate redisTemplate;

    public ClienteService(ClienteRepository clienteRepository, RedisTemplate redisTemplate) {
        this.clienteRepository = clienteRepository;
        this.redisTemplate = redisTemplate;
    }

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    /**
     * Quando for chamado pela primeira vez, sera criado um cache no redis
     * Na segunda vez o metodo ja retornara o cache rapidamente
     */
    @Cacheable(value = "clientes", key = "'todosClientes'")
    public List<Cliente> findAll() throws InterruptedException {
        log.info("Realizando a consulta na base de dados...");
        Thread.sleep(10000);
        return clienteRepository.findAll();
    }

    /**
     * Recuperando um cache no redis
     */
    public List<Cliente> recoverCache() {
        log.info("Recuperando cache já existente no redis...");
        return (List<Cliente>) redisTemplate.opsForValue().get("clientes::todosClientes");
    }
}
