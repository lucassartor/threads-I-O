package comLeitorEscritor;

public class Writer extends Thread {

    private final Database database;

    public Writer(Database database) {
        this.database = database;
    }

    @Override
    public void run() {
        try {
            this.database.write();
        } catch (InterruptedException ex) {
            System.err.println("Erro execução writer");
        }
    }

}