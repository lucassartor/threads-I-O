package semLeitorEscritor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Database {

    private final List<String> list;
    private int inUse;

    public Database() {
        list = new ArrayList<String>();
        this.inUse = 0;
    }

    public void carregaEstruturaRAM() throws IOException {
        File arq = new File("./bd/bd.txt");
        if (arq.isFile()) {
            try (BufferedReader br = new BufferedReader(new FileReader(arq))) {
                String linhaArq;

                while ((linhaArq = br.readLine()) != null) {
                    list.add(linhaArq);
                }
            } catch (Exception e) {
                System.out.println("Erro na leitura dos arquivos");
            }
        }
    }

    public synchronized String read() throws InterruptedException {

        while (this.inUse != 0) {
            try {
                this.wait();
            } catch (InterruptedException ignored) {
            }
        }

        ThreadLocalRandom generator = ThreadLocalRandom.current();
        String palavraLida = "";

        for (int i = 0; i < 100; i++) {
            int pos = generator.nextInt(100);

            palavraLida = this.list.get(pos);
        }

        Thread.sleep(1);

        this.notifyAll();

        return palavraLida;

    }

    public synchronized void write() throws InterruptedException {
        while (this.inUse != 0) {
            try {
                this.wait();
            } catch (InterruptedException ignored) {
            }
        }

        ThreadLocalRandom generator = ThreadLocalRandom.current();

        for (int i = 0; i < 100; i++) {
            int pos = generator.nextInt(100);
            this.list.set(pos, "MODIFICADO");
        }

        Thread.sleep(1);

        this.notifyAll();
    }
}