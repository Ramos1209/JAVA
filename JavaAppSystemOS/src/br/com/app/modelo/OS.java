/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.app.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author paulo
 */

@Entity
@Table(name = "ordem_servico")
public class OS implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_os",sequenceName = "seq_os_id",allocationSize = 1)
    @GeneratedValue(generator = "seq_os",strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date os;
    
    @Column(length = 30,nullable = false)
    private String equipamento;
    
    @Column(length = 30,nullable = false)
    private String defeito;
    
    @Column(length = 30,nullable = false)
    private String tecnico;
    
    @Column(scale = 12)
    private Double valor;
    
    @Column(length = 20,nullable = false)
    private String tipo;
    
    @Column(length = 50,nullable = false)
    private String servico;
    
    
   
    @Column(length = 30,nullable = false)
    private String situacao;
    
    @ManyToOne
    @JoinColumn(name = "cliente",referencedColumnName = "id")
    @ForeignKey(name = "fk_cliente")
    private Cliente cliente;

    public OS() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getOs() {
        return os;
    }

    public void setOs(Date os) {
        this.os = os;
    }

    public String getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(String equipamento) {
        this.equipamento = equipamento;
    }

    public String getDefeito() {
        return defeito;
    }

    public void setDefeito(String defeito) {
        this.defeito = defeito;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    

     public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
     public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
     public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public String getSituacao() {
        return situacao;
    }
     public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OS other = (OS) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

   


    
}
