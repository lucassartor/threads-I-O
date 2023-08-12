package semLeitorEscritor;

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
            System.err.println("Erro na execução do leitor");
        }
    }

    public String getPalavraLida() {
        return palavraLida;
    }
}
