package semLeitorEscritor;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Database database = new Database();
        try {
            database.carregaEstruturaRAM();
        } catch (IOException ex) {
            System.err.println("Erro para carregar a base de dados");
        }

        Sistema sistema = new Sistema(database);
        sistema.start();
    }
}