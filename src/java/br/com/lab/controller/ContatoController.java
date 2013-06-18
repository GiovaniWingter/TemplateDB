package br.com.lab.controller;

import br.com.lab.bean.Contato;
import br.com.lab.dao.ContatoDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean(name="contatoController")
@SessionScoped
public class ContatoController {
    private ContatoDAO contatoDAO;
    private Contato contato;
    private DataModel<Contato> contatos;
 
    public void novo(){
        
    }
 
    public ContatoController(){
        contato = new Contato();
    }
    
    public String inserir(){
        String resultado = "falha";
        contatoDAO = new ContatoDAO();
        boolean retorno = contatoDAO.inserir(contato);
        if(retorno){
            resultado = "listacontato";
        }
        return resultado;
    }
 
     public void selecionar(){
        contato = contatos.getRowData();
    }
 
 
    public String alterar(){
        String resultado = "falha";
        contatoDAO = new ContatoDAO();
        boolean retorno = contatoDAO.alterar(contato); 
        if(retorno){
            resultado = "listacontato";
        }
        return resultado;
    }
 
    public String remover(){
        String resultado = "falha";
        contatoDAO = new ContatoDAO();
        boolean retorno = contatoDAO.remover(contato);
        if(retorno){
            resultado = "listacontato";
        }
        return resultado;
    }
 
    public Contato getContato() {
        return contato;
    }
 
    public void setContato(Contato contato) {
        this.contato = contato;
    }
 
    public DataModel<Contato> getContatos() {
        contatoDAO = new ContatoDAO();
        List<Contato> contatoList = contatoDAO.consultarContatos();
        contatos = new ListDataModel<Contato>(contatoList);
        return contatos;
    }
 
    public void setContatos(DataModel<Contato> contatos) {
        this.contatos = contatos;
    }
}