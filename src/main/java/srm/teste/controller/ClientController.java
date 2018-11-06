package srm.teste.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import srm.teste.model.Client;
import srm.teste.service.ClientService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    private final ClientService service;

    @Autowired
    public ClientController(ClientService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Client> save(@RequestBody Client client) {
        if (client != null) {
            Client clientDb = service.getRepository().save(client);
            if (clientDb != null) {
                return ResponseEntity.ok(clientDb);
            }
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @GetMapping
    public ResponseEntity<Collection<Client>> getAll(){
        List<Client> clients = service.getRepository().findAll();
        if (clients != null) {
            return ResponseEntity.ok(clients);
        }

        return ResponseEntity.noContent().build();
    }

}
