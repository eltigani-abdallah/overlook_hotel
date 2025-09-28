package com.overlook.hotel.service;

import com.overlook.hotel.repository.ClientRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ClientDetailsService implements UserDetailsService {

    public final ClientRepository clientRepository;

    public ClientDetailsService(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return clientRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("EMAIL NOT FOUND"));
    }
}
