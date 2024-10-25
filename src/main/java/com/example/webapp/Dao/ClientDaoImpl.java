package com.example.webapp.Dao;

import com.example.webapp.Model.Client;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ClientDaoImpl implements ClientDao {

    public static List<Client> clients = new ArrayList<>();

    static {
        clients.add(new Client(1, "John", "Doe", "johnDoe@gmail.com", "0612457896", "123 rue du Parc", "France"));
        clients.add(new Client(2, "Jane", "Smith", "janeSmith@gmail.com", "0712345678", "456 rue de l'Église", "France"));
        clients.add(new Client(3, "Pierre", "Dupont", "pierre.dupont@example.com", "0687654321", "789 avenue de la République", "France"));
        clients.add(new Client(4, "Laura", "Martin", "laura.martin@example.com", "0645987321", "12 rue des Fleurs", "France"));
        clients.add(new Client(5, "Lucas", "Bernard", "lucas.bernard@example.com", "0654321987", "3 rue de la Liberté", "France"));
        clients.add(new Client(6, "Marie", "Legrand", "marie.legrand@example.com", "0621348765", "10 boulevard de la Paix", "France"));
        clients.add(new Client(7, "Paul", "Durand", "paul.durand@example.com", "0632547812", "98 rue des Lilas", "France"));
        clients.add(new Client(8, "Emma", "Moreau", "emma.moreau@example.com", "0698765432", "14 rue de la Gare", "France"));
        clients.add(new Client(9, "Nathalie", "Lopez", "nathalie.lopez@example.com", "0612348976", "7 avenue du Stade", "France"));
        clients.add(new Client(10, "Hugo", "Giraud", "hugo.giraud@example.com", "0687651234", "65 rue Victor Hugo", "France"));
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
        return null;
    }
}
