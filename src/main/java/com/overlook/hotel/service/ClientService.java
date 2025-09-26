package com.overlook.hotel.service;

import com.overlook.hotel.Entity.Client;
import com.overlook.hotel.repository.ClientRepository; // Import Client repository
import lombok.RequiredArgsConstructor; // Lombok annotation for constructor injection
import org.springframework.stereotype.Service; // Marks the class as a Spring service

import java.util.List; // For returning lists

@Service // This class contains business logic for Client entity
@RequiredArgsConstructor // Lombok generates constructor with required arguments (final fields)
public class ClientService {

    private final ClientRepository clientRepository; // Inject repository dependency

    // Fetch all clients from the database
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    // Fetch a single client by ID (throws exception if not found)
    public Client getClientById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));
    }

    // Create a new client (insert into database)
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    // Update an existing client
    public Client updateClient(Long id, Client clientDetails) {
        // First, fetch client from DB (or throw if not exists)
        Client client = getClientById(id);

        // Update fields
        client.setFirstName(clientDetails.getFirstName());
        client.setLastName(clientDetails.getLastName());
        client.setEmail(clientDetails.getEmail());
        client.setPassword(clientDetails.getPassword());
        client.setPhoneNumber(clientDetails.getPhoneNumber());
        client.setAddress(clientDetails.getAddress());

        // Save updated client back to DB
        return clientRepository.save(client);
    }

    // Delete a client by ID
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
