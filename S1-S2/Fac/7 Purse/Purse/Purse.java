package Purse;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Purse {
    String name;
    String mdp;
    int balance;
    Map<String, String> transactions;
    boolean isConnected;

    public Purse(String name, String mdp) {
        this.name = name;
        this.mdp = mdp;
        balance = 500;
        this.transactions = new HashMap<String, String>();
        isConnected = false;
        this.menu();
    }

    void addToBalance(int amount) {
        if (this.isConnected) {
            this.balance += amount;
            this.transactions.put(Integer.toString(this.transactions.size()), Integer.toString(amount));
        } else {
            System.out.println("Vous n'êtes pas connecté");
        }
    }

    void displayTransaction() {
        if (this.isConnected) {
            System.out.println("N°  Value");
            for (Map.Entry<String, String> ts : this.transactions.entrySet()) {
                System.out.println(ts.getKey() + "   " + ts.getValue()); // Or something as per temp defination. can be
                                                                         // used
            }
        }
    }

    void connection(String username, String password) {
        if (isConnected) {
            System.out.println("You are already connected");
        } else {
            if (username.equals(this.name) && password.equals(this.mdp)) {
                this.isConnected = true;
                System.out.println("You are connected ");
                System.out.println("Bonjour " + this.name);
            } else {
                System.out.println("Wrong username or password");
            }
        }
    }

    void disconnect() {
        this.isConnected = false;
        System.out.println("Vous êtes bien déconnecté");
    }

    Boolean isConnected() {
        return this.isConnected;
    }

    void menu() {
        Scanner enter = new Scanner(System.in);
        do {
            System.out.println("Entrez votre identifiant");
            String username = enter.nextLine();
            System.out.println("Entrez votre mdp");
            String password = enter.nextLine();
            this.connection(username, password);
        } while (!this.isConnected);
        enter.close();
    }
}
