package com.fx.loja.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="vd_cp_loja_virt")
@SequenceGenerator(name="seq_vd_cp_virt", sequenceName = "seq_vd_cp_virt", allocationSize = 1, initialValue = 1)
public class VendaCompraLojaVirtual implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_vd_cp_virt")
    private Long id;

    @ManyToOne(targetEntity = Pessoa.class)//MUITAS vendas para UMA pessoa
    @JoinColumn(name = "pessoa_id", nullable = false, foreignKey = @ForeignKey(value=ConstraintMode.CONSTRAINT,name = "pessoa_fk"))
    private Pessoa pessoa;

    @ManyToOne(targetEntity = Endereco.class)
    @JoinColumn(name = "endereco_entrega_id", nullable = false, foreignKey = @ForeignKey(value=ConstraintMode.CONSTRAINT,name = "endereco_entrega_fk"))
    private Endereco enderecoEntrega;

    @ManyToOne(targetEntity = Endereco.class)
    @JoinColumn(name = "endereco_cobranca_id", nullable = false, foreignKey = @ForeignKey(value=ConstraintMode.CONSTRAINT,name = "endereco_cobranca_fk"))
    private Endereco enderecoCobranca;

    @Column(nullable = false)
    private BigDecimal valorTotal;
    private BigDecimal valorDesconto;

    @ManyToOne(targetEntity = FormaPagamento.class)
    @JoinColumn(name = "forma_pagamento_id", nullable = false, foreignKey = @ForeignKey(value=ConstraintMode.CONSTRAINT,name = "forma_pagamento_fk"))
    private FormaPagamento formaPagamento;

    @OneToOne
    @JoinColumn(name = "nota_fiscal_venda_id", nullable = false, foreignKey = @ForeignKey(value=ConstraintMode.CONSTRAINT,name = "nota_fiscal_venda_fk"))
    private NotaFiscalVenda notaFiscalVenda;

    @ManyToOne(targetEntity = FormaPagamento.class)
    @JoinColumn(name = "cupom_desconto_id", foreignKey = @ForeignKey(value=ConstraintMode.CONSTRAINT,name = "cupom_desconto_fk"))
    private CupomDesconto cupomDesconto;
    @Column(nullable = false)
    private BigDecimal valorFrete;
    @Column(nullable = false)
    private Integer diaEntrega;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataDaVenda;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataDaEntrega;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Endereco getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(Endereco enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public Endereco getEnderecoCobranca() {
        return enderecoCobranca;
    }

    public void setEnderecoCobranca(Endereco enderecoCobranca) {
        this.enderecoCobranca = enderecoCobranca;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public BigDecimal getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(BigDecimal valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public NotaFiscalVenda getNotaFiscalVenda() {
        return notaFiscalVenda;
    }

    public void setNotaFiscalVenda(NotaFiscalVenda notaFiscalVenda) {
        this.notaFiscalVenda = notaFiscalVenda;
    }

    public CupomDesconto getCupomDesconto() {
        return cupomDesconto;
    }

    public void setCupomDesconto(CupomDesconto cupomDesconto) {
        this.cupomDesconto = cupomDesconto;
    }

    public BigDecimal getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(BigDecimal valorFrete) {
        this.valorFrete = valorFrete;
    }

    public Integer getDiaEntrega() {
        return diaEntrega;
    }

    public void setDiaEntrega(Integer diaEntrega) {
        this.diaEntrega = diaEntrega;
    }

    public Date getDataDaVenda() {
        return dataDaVenda;
    }

    public void setDataDaVenda(Date dataDaVenda) {
        this.dataDaVenda = dataDaVenda;
    }

    public Date getDataDaEntrega() {
        return dataDaEntrega;
    }

    public void setDataDaEntrega(Date dataDaEntrega) {
        this.dataDaEntrega = dataDaEntrega;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VendaCompraLojaVirtual)) return false;
        VendaCompraLojaVirtual that = (VendaCompraLojaVirtual) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
