package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import modelo.Cliente;
import modelo.Funcionario;
import modelo.Produto;

public class DAO<T> {

    private final Class<T> classe;

    public DAO(Class<T> classe) {
        this.classe = classe;
    }

    public void adicionar(T t) {
        EntityManager manager = new JPAUtil().getEntityManager();
        manager.getTransaction().begin();
        manager.persist(t);
        manager.getTransaction().commit();
        manager.close();
    }
    
    public void atualizar(T t) {
        EntityManager manager = new JPAUtil().getEntityManager();
        manager.getTransaction().begin();
        manager.merge(t);
        manager.getTransaction().commit();
        manager.close();
    }

    public void remover(T t) {
        EntityManager manager = new JPAUtil().getEntityManager();
        manager.getTransaction().begin();
        manager.remove(manager.merge(t));
        manager.getTransaction().commit();
        manager.close();
    }
    
    public void removerPorId(Integer id) {
        EntityManager manager = new JPAUtil().getEntityManager();
        manager.getTransaction().begin();
        TypedQuery<Funcionario> sql = manager.createQuery("delete from Funcionario f where f.id = :pId", Funcionario.class);
        sql.setParameter("pId", id);
        sql.getResultList();
    }
    
    public List<Funcionario> buscarTodosFuncionarios() {
        EntityManager manager = new JPAUtil().getEntityManager();
        manager.getTransaction().begin();
        String sql = "select f from Funcionario f";
        List<Funcionario> funcionarios = manager.createQuery(sql, Funcionario.class).getResultList();
        manager.close();
        return funcionarios;
    }
    
    public Funcionario buscarFuncionarioPorId(Integer id) {
        EntityManager manager = new JPAUtil().getEntityManager();
        manager.getTransaction().begin();
        TypedQuery<Funcionario> sql = manager.createQuery("select f from Funcionario f where f.id = :pId", Funcionario.class);

        sql.setParameter("pId", id);
        Funcionario funcionario = sql.getSingleResult();
        
        return funcionario;
    }
    
    public Cliente buscarClientePorId(String id) {
        EntityManager manager = new JPAUtil().getEntityManager();
        manager.getTransaction().begin();
        TypedQuery<Cliente> sql = manager.createQuery("select c from Cliente c where c.id = :pId", Cliente.class);

        sql.setParameter("pId", Integer.parseInt(id));
        Cliente cliente = sql.getSingleResult();
        
        System.out.println("Cliente: " + cliente.getNome());
        
        return cliente;
    }
    
    public List<Cliente> buscarTodosClientes() {
        EntityManager manager = new JPAUtil().getEntityManager();
        manager.getTransaction().begin();
        String sql = "select c from Cliente c";
        List<Cliente> clientes = manager.createQuery(sql, Cliente.class).getResultList();
        return clientes;
    }

    public List<Produto> buscarTodosProdutos() {
        EntityManager manager = new JPAUtil().getEntityManager();
        manager.getTransaction().begin();
        String sql = "select p from Produto p";
        List<Produto> produtos = manager.createQuery(sql, Produto.class).getResultList();
        manager.close();
        return produtos;
    }
}
