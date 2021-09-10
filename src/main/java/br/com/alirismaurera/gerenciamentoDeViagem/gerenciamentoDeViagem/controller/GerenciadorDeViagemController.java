package br.com.alirismaurera.gerenciamentoDeViagem.gerenciamentoDeViagem.controller;

import br.com.alirismaurera.gerenciamentoDeViagem.gerenciamentoDeViagem.entities.Clientes;
import br.com.alirismaurera.gerenciamentoDeViagem.gerenciamentoDeViagem.entities.Viagens;
import br.com.alirismaurera.gerenciamentoDeViagem.gerenciamentoDeViagem.service.ViagemService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/Clientes")
@AllArgsConstructor
@NoArgsConstructor
public class GerenciadorDeViagemController {

    @Autowired
    private ViagemService viagemService;

    @GetMapping
    public ResponseEntity<Iterable<Clientes>> listarClientes(){
        var lista = viagemService.listar();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Clientes>> buscaClientePorId(@PathVariable Long id){
        Optional<Clientes> clientes = viagemService.buscarPorId(id);
        if (clientes.isPresent()){ return new ResponseEntity<>(clientes, HttpStatus.OK);
        }   return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PostMapping
    public ResponseEntity<Clientes> incluirClientes(@Valid @RequestBody Clientes cliente){
           viagemService.salvar(cliente);
           return new ResponseEntity<>(cliente, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Clientes> atualizarCliente(@PathVariable long id, @RequestBody Clientes cliente){
        viagemService.atualizarCliente(id, cliente);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Clientes> deletarUmaCliente(@PathVariable Long id){
        Optional<Clientes> clientes = viagemService.deletar(id);
        if (clientes.isPresent()){ return new ResponseEntity<>(HttpStatus.OK);
        }   return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
