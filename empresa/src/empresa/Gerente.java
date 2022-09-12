package empresa;

public class Gerente extends Funcionario implements Autenticacao {
    
    private String senha = "13";
    
    public Gerente(String nome) {
        super(nome);
    }
    
    @Override
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    @Override
    public boolean autentica(String senha) {
        if(this.senha == senha) {
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public double bonificacao() {
        return this.getSalario() + this.getSalario() * 0.1;
    }
}
