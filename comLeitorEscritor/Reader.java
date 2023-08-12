package comLeitorEscritor;

public class Reader extends Thread {

    private String palavraLida;

    private final Database database;

    public Reader(Database database) {
        this.database = database;
    }

    @Override
    public void run() {
        try {
            this.palavraLida = this.database.read();
        } catch (InterruptedException ex) {
            System.err.println("Erro execução reader");
        }
    }

    public String getPalavraLida() {
        return palavraLida;
    }
}
