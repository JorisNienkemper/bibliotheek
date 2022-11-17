package nl.bld.bibliotheek.app;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {

    private EntityManagerFactory emf;

    public static void main(String[] args) {
        System.out.println("Bibliotheek started!");
        App app = new App();

        app.run();
    }

    public App() {
        this.emf = Persistence.createEntityManagerFactory("bibliotheek-pu");
    }

    private void run() {
        //start app from here
    }


}
