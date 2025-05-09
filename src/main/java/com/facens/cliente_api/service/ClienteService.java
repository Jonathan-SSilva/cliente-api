package com.facens.cliente_api.service;

import com.facens.cliente_api.dto.ClienteDTO;
import java.util.List;

public interface ClienteService {
    List<ClienteDTO> listarTodos();
    ClienteDTO obterPorId(Long id);
    void editar(Long id, ClienteDTO clienteDTO);
    void excluir(Long id);
}