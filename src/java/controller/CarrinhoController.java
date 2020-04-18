/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Carrinho;
import domain.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author T-Gamer
 */
@ManagedBean(name="carrinhoMB")
@SessionScoped
public class CarrinhoController {
    private Carrinho carrinho = new Carrinho();
    private Produto produto = new Produto();
    private List<Carrinho> carrinhos = new ArrayList<>();
    private Double totalCompra = 0.0;
    private Boolean isFinCarrinho = true;
    
    public CarrinhoController(){

    }
    
    public String novo(Produto produto){
        carrinho = new Carrinho();
        carrinho.setProduto(produto);
        return "new.xhtml?faces-redirect=true";
    }
    
    public String adicionarCarrinho(){
        if (carrinho.getQuant()>0){
            boolean existe = false;
            carrinho.setSubTotal(carrinho.getProduto().getPreco() * carrinho.getQuant());
            for (Carrinho car : carrinhos) {
                if (car.getProduto().getId().equals(carrinho.getProduto().getId())){
                    car.setQuant(carrinho.getQuant()+car.getQuant());
                    car.setSubTotal(car.getProduto().getPreco() * car.getQuant()); 
                    existe = true;
                }
            }
            if (!existe){ 
                carrinhos.add(carrinho);  
            }  
            totalCompra += carrinho.getSubTotal();
            if (!carrinhos.isEmpty()){
                isFinCarrinho = false;
            }
        } 
        return "list.xhtml?faces-redirect=true";
    }
    
    public String removerCarrinho(Carrinho carrinho){
        totalCompra -= carrinho.getSubTotal();
        carrinhos.remove(carrinho);
        if (carrinhos.isEmpty()){
            isFinCarrinho = true;
        }
        return "list.xhtml?faces-redirect=true";
    }
    
    public String limparCarrinho(){
        carrinhos = new ArrayList<>();
        totalCompra = 0.0;
        isFinCarrinho = true;
        return "/index.xhtml";
    }
    
    public String cancelar(){
        return "list.xhtml?faces-redirect=true";
    }
    
    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public List<Carrinho> getCarrinhos() {
        return carrinhos;
    }

    public void setCarrinhos(List<Carrinho> carrinhos) {
        this.carrinhos = carrinhos;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(Double totalCompra) {
        this.totalCompra = totalCompra;
    }

    public Boolean getIsFinCarrinho() {
        return isFinCarrinho;
    }

    public void setIsFinCarrinho(Boolean isFinCarrinho) {
        this.isFinCarrinho = isFinCarrinho;
    }
}
