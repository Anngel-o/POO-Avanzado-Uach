package Mediator;

import java.util.ArrayList;
import java.util.List;

interface Mediator {
    void addUser(User user);
    void sendMessage(User sender, String message);
}

class ChatMediator implements Mediator {
    private List<User> users;

    public ChatMediator() {
        this.users = new ArrayList<>();
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void sendMessage(User sender, String message) {
        for (User user : users) {
            // Evitar que el remitente reciba su propio mensaje
            if (user != sender) {
                user.receiveMessage(sender, message);
            }
        }
    }
}

class User {
    private String name;
    private Mediator mediator;

    public User(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
        mediator.addUser(this);
    }

    public void sendMessage(String message) {
        mediator.sendMessage(this, message);
    }

    public void receiveMessage(User sender, String message) {
        System.out.println(name + " received a message from " + sender.getName() + ": " + message);
    }

    public String getName() {
        return name;
    }
}

public class Main {
    public static void main(String[] args) {
        Mediator chatMediator = new ChatMediator();

        User alice = new User("Alice", chatMediator);
        User bob = new User("Bob", chatMediator);

        // Enviar mensajes a través del mediador
        alice.sendMessage("Hi, Bob!");
        bob.sendMessage("Hello, Alice!");
    }
}

