package hibernate;

import net.sf.hibernate.Session;
import net.sf.hibernate.SessionFactory;
import net.sf.hibernate.Transaction;
import net.sf.hibernate.cfg.Configuration;

public class Teste4MBJogos {

    private SessionFactory factory = null;

    private Session session;

    public void start() throws Exception {
        Configuration cfg;
        cfg = new Configuration().configure();
        factory = cfg.buildSessionFactory();
        cfg = null;
        session = factory.openSession();
    }

    public void armazenaJogo(Jogo[] j) throws Exception {
        Transaction tx = session.beginTransaction();

        for (int i = 0; i < j.length; i++) {
            session.save(j[i]);
        }

        tx.commit();
    }

    public void end() throws Exception {
        session.close();
        factory.close();
    }

    public static void main(String[] args) throws Exception {
        Teste4MBJogos prog = new Teste4MBJogos();

        prog.start();

        // Cria instâncias de Jogo e as persiste
        int quatroMB = 10;
        int nJogos = 0;
        Jogo[] j = new Jogo[10000];
        while (quatroMB > 0) {
            while (nJogos < j.length) {
                j[nJogos] = new Jogo();
                j[nJogos].setNumero(quatroMB);
                j[nJogos].setDzns(String.valueOf(quatroMB));
                nJogos = nJogos + 1;
            }
            nJogos = 0;
            
            prog.armazenaJogo(j);
            
            quatroMB = quatroMB - 1;
        }

        prog.end();
    }
}