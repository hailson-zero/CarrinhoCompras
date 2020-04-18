package controller;

import domain.Produto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Hailson
 */
@ManagedBean(name="produtoMB")
@SessionScoped
public class ProdutoController implements Serializable{
    
    private Produto produto = new Produto();
    private List<Produto> produtos = new ArrayList<>();
    private Integer id = 1;
    
    public ProdutoController(){
       
    }
    
    public String novo(){
        produto = new Produto();
        return "new.xhtml?faces-redirect=true";
    }
    
    public String salvar(){
        produto.setId(id);
        produtos.add(produto);
        id++;
        return "list.xhtml?faces-redirect=true";
    }
    
    public String alterar(){
        for (Produto prod : produtos) {
            if (prod.getId().equals(produto.getId())) {
               prod.setId(produto.getId());
               prod.setDescricao(produto.getDescricao());
               prod.setNome(produto.getNome());
               prod.setPreco(produto.getPreco());   
            }
        }
        return "list.xhtml?faces-redirect=true";
    }
    
    public String excluir (Produto produto){
        produtos.remove(produto);
        return "list.xhtml?faces-redirect=true";
    }
    
    public String cancelar(){
        return "list.xhtml?faces-redirect=true";
    }

    public String buscaDados(Produto produto){
        this.produto = produto;
        return "alter.xhtml?faces-redirect=true";
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}

