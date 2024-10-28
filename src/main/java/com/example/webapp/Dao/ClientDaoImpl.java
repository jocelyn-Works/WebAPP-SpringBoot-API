package com.example.webapp.Dao;

import com.example.webapp.Model.Client;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

@Repository
public class ClientDaoImpl implements ClientDao {

    public static List<Client> clients = new ArrayList<>();

    static {
        clients.add(new Client(1, "John", "Doe", new Date(95, 2, 20), "ABC123456", false));
        clients.add(new Client(2, "Jane", "Smith", new Date(87, 5, 15), "DEF789012",false));
        clients.add(new Client(3, "Alice", "Johnson", new Date(90, 8, 10), "GHI345678",false));
        clients.add(new Client(4, "Bob", "Brown", new Date(85, 11, 25), "JKL901234",false));
        clients.add(new Client(5, "Charlie", "Davis", new Date(92, 1, 5), "MNO567890",false));
        clients.add(new Client(6, "David", "Wilson", new Date(88, 3, 22), "PQR123456",false));
        clients.add(new Client(7, "Eve", "Taylor", new Date(91, 7, 14), "STU789012",false));
        clients.add(new Client(8, "Frank", "Anderson", new Date(94, 10, 9), "VWX345678",false));
        clients.add(new Client(9, "Grace", "Thomas", new Date(89, 1, 30), "YZA901234",false));
        clients.add(new Client(10, "Hank", "Jackson", new Date(93, 5, 19), "BCD567890",false));

    }


    @Override
    public List<Client> findAll() {
        return clients;
    }

    @Override
    public Client findById(int id) {
        for (Client client : clients) {
            if (client.getId() == id) {
                return client;
            }
        }
        return null;
    }

    @Override
    public Client save(Client client) {
        clients.add(client);
        return client;
    }


    @Override
    public Client delete(Client client) {
        clients.remove(client);
        return client;
    }
}
