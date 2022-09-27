package dao;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import modelo.Autor;

public class DAO<T> {

    private final Class<T> classe;

    public DAO(Class<T> classe) {
        this.classe = classe;
    }

    public void adiciona(T t) {
        EntityManager manager = new JPAUtil().getEntityManager();

        manager.getTransaction().begin();

        manager.persist(t);

        manager.getTransaction().commit();

        manager.close();
    }

    public void remove(T t) {
        EntityManager manager = new JPAUtil().getEntityManager();

        manager.getTransaction().begin();

        manager.remove(manager.merge(t));

        manager.getTransaction().commit();

        manager.close();
    }

    public void atualiza(T t) {
        EntityManager manager = new JPAUtil().getEntityManager();

        manager.getTransaction().begin();

        manager.remove(manager.merge(t));

        manager.getTransaction().commit();

        manager.close();
    }

    public T buscaPorId(Integer id) {

        EntityManager manager = new JPAUtil().getEntityManager();
        T instancia = manager.find(classe, id);
        manager.close();

        return instancia;
    }

    public List<Autor> listaTodos() {
        EntityManager manager = new JPAUtil().getEntityManager();
        manager.getTransaction().begin();

        String sql = "SELECT a from Autor a";
        List<Autor> autores = manager.createQuery(sql, Autor.class).getResultList();

        manager.close();

        return autores;
    }
}