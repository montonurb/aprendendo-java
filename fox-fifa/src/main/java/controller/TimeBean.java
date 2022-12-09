package controller;

import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import model.Time;
import service.DAO;

/**
 *
 * @author montonurb
 */
@ManagedBean
public class TimeBean {

    private Long id;
    private Time time = new Time();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String salvar() {
        this.time.setDataCadastro(new Date());
        System.out.println("Data: " + this.time.getDataCadastro().toString());
        if (this.time.getId() != null) {
            new DAO<>(Time.class).atualizar(time);
        } else {
            new DAO<>(Time.class).cadastrar(this.time);
        }
        this.time = new Time();
        return "visualizarTimes?faces-redirect=true";
    }

    public void excluir(Time time) {
        new DAO<>(Time.class).remover(time);
    }

    public List<Time> buscarTodos() {
        return new DAO<>(Time.class).buscarTimes();
    }
    
    public String irParaCadastroTime() {
        return "cadastrarTime?faces-redirect=true";
    }
}
