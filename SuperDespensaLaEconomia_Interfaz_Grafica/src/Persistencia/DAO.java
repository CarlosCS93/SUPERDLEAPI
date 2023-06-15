package Persistencia;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAO<T> {

    protected final EntityManagerFactory emf = Persistence.createEntityManagerFactory("SuperDespensaLaEconomiaPU");
    protected EntityManager em = emf.createEntityManager();

    protected void conectarBase() {
        try {
            if (!em.isOpen()) {
                em = emf.createEntityManager();
                em.isOpen();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    protected void desconectarBase() {
        try {
            if (em.isOpen()) {
                em.close();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    protected void guardar(T objeto) {
        try {
            conectarBase();
            em.getTransaction().begin();
            em.persist(objeto);
            em.getTransaction().commit();
            desconectarBase();
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    protected void modificar(T objeto) {
        try {
            conectarBase();
            em.getTransaction().begin();
            em.merge(objeto);
            em.getTransaction().commit();
            desconectarBase();
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    protected void eliminar(T objeto) {
        try {
            conectarBase();
            em.getTransaction().begin();
            Object eliminar = em.merge(objeto);
            em.remove(eliminar);
            em.getTransaction().commit();
            desconectarBase();
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    
}
