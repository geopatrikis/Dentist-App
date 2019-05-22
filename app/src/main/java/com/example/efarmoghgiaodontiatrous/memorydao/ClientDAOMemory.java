package com.example.efarmoghgiaodontiatrous.memorydao;

import com.example.efarmoghgiaodontiatrous.dao.ClientDAO;
import com.example.efarmoghgiaodontiatrous.domain.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientDAOMemory implements ClientDAO {
    protected static List<Client> entities = new ArrayList<>();

    @Override
    public void delete(Client entity) {
        entities.remove(entity);
    }

    @Override
    public List<Client> findAll() {
        ArrayList<Client> result = new ArrayList<>();
        result.addAll(entities);
        return result;
    }

    @Override
    public void save(Client entity) {
        if (!entities.contains(entity)) {
            entities.add(entity);
        }
    }

    @Override
    public Client find(String clientAMKA) {
        for (Client client : entities) {
            if (client.getAMKA().equals(clientAMKA)) {
                return client;
            }
        }
        return null;
    }
}