package com.facens.cliente_api.service;

import com.facens.cliente_api.dto.ClienteDTO;
import com.facens.cliente_api.entity.Cliente;
import com.facens.cliente_api.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    public List<ClienteDTO> listarTodos() {
        return clienteRepository.findAll().stream()
            .map(cliente -> ClienteDTO.builder()
                .id(cliente.getId())
                .nome(cliente.getNome())
                .email(cliente.getEmail())
                .telefone(cliente.getTelefone())
                .build())
            .collect(Collectors.toList());
    }

    @Override
    public ClienteDTO obterPorId(Long id) {
        return clienteRepository.findById(id)
            .map(cliente -> ClienteDTO.builder()
                .id(cliente.getId())
                .nome(cliente.getNome())
                .email(cliente.getEmail())
                .telefone(cliente.getTelefone())
                .build())
            .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
    }

    @Override
    @Transactional
    public void editar(Long id, ClienteDTO clienteDTO) {
        Cliente cliente = clienteRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
        
        cliente.setNome(clienteDTO.getNome());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setTelefone(clienteDTO.getTelefone());
        
        clienteRepository.save(cliente);
    }

    @Override
    @Transactional
    public void excluir(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new IllegalArgumentException("Cliente não encontrado");
        }
        clienteRepository.deleteById(id);
    }
}