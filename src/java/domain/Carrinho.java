package domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author T-Gamer
 */
@Entity
@Table(name="carrinhos")
public class Carrinho implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name="idProduto", referencedColumnName="id")
    private Produto produto;
    
    @NotNull
    @Column(name="quant")
    private Integer quant;
    
    @NotNull
    @Column(name="subTotal")
    private Double subTotal;

    public Carrinho(){
    }

    public Carrinho(Integer id, Produto produto, Integer quant, Double subTotal) {
        this.id = id;
        this.produto = produto;
        this.quant = quant;
        this.subTotal = subTotal;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuant() {
        return quant;
    }

    public void setQuant(Integer quant) {
        this.quant = quant;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }
    
    
    
    @Override
    public String toString() {
        return "Carrinho{" + "id=" + id 
                + ", produto=" + produto 
                + ", quant=" + quant
                + ", subToral=" + subTotal + '}';
    }
}
