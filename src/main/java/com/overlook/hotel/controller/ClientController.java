package com.overlook.hotel.controller;

import com.overlook.hotel.database.Entity.Client;
import com.overlook.hotel.service.ClientService; // Import service class
import lombok.RequiredArgsConstructor; // Lombok for constructor injection
import org.springframework.web.bind.annotation.*; // REST annotations

import java.util.List; // For returning list of clients

@RestController // Marks this class as a REST controller
@RequestMapping("/api/clients") // Base URL for client API
@RequiredArgsConstructor // Constructor injection for service
public class ClientController {

    private final ClientService clientService; // Service layer dependency

    // GET /api/clients -> fetch all clients
    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    // GET /api/clients/{id} -> fetch a single client by ID
    @GetMapping("/{id}")
    public Client getClientById(@PathVariable Long id) {
        return clientService.getClientById(id);
    }

    // POST /api/clients -> create a new client
    @PostMapping
    public Client createClient(@RequestBody Client  client) {
        return clientService.createClient(client);
    }

    // PUT /api/clients/{id} -> update an existing client
    @PutMapping("/{id}")
    public Client updateClient(@PathVariable Long id, @RequestBody Client client) {
        return clientService.updateClient(id, client);
    }

    // DELETE /api/clients/{id} -> delete a client by ID
    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }
}
