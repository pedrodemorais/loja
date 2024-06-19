package com.fx.loja.model;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="nota_fiscal_compra")
@SequenceGenerator(name="seq_nota_fiscal_compra", sequenceName = "seq_nota_fiscal_compra", allocationSize = 1, initialValue = 1)
public class NotaFiscalCompra {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_nota_fiscal_compra")
    private Long id;

    @Column(nullable = false)
    private String numeroNota;
    @Column(nullable = false)
    private String serieNota;
    private String descricaoObservacao;
    @Column(nullable = false)
    private BigDecimal valorTotal = BigDecimal.ZERO;
    private BigDecimal valorDesconto = BigDecimal.ZERO;
    @Column(nullable = false)
    private BigDecimal valorIcms = BigDecimal.ZERO;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date DataCompra;

    @ManyToOne(targetEntity = Pessoa.class)//muitas notas de compra para uma pessoa
    @JoinColumn(name = "pessoa_id", nullable = false, foreignKey = @ForeignKey(value=ConstraintMode.CONSTRAINT,name = "pessoa_fk"))
    private Pessoa pessoa;

    @ManyToOne//muitas notas para uma conta pagar
    @JoinColumn(name = "contas_pagar_id", nullable = false, foreignKey = @ForeignKey(value=ConstraintMode.CONSTRAINT,name = "contas_pagar_fk"))
    private ContasPagar contasPagar;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroNota() {
        return numeroNota;
    }

    public void setNumeroNota(String numeroNota) {
        this.numeroNota = numeroNota;
    }

    public String getSerieNota() {
        return serieNota;
    }

    public void setSerieNota(String serieNota) {
        this.serieNota = serieNota;
    }

    public String getDescricaoObservacao() {
        return descricaoObservacao;
    }

    public void setDescricaoObservacao(String descricaoObservacao) {
        this.descricaoObservacao = descricaoObservacao;
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

    public BigDecimal getValorIcms() {
        return valorIcms;
    }

    public void setValorIcms(BigDecimal valorIcms) {
        this.valorIcms = valorIcms;
    }

    public Date getDataCompra() {
        return DataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        DataCompra = dataCompra;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public ContasPagar getContasPagar() {
        return contasPagar;
    }

    public void setContasPagar(ContasPagar contasPagar) {
        this.contasPagar = contasPagar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NotaFiscalCompra)) return false;
        NotaFiscalCompra that = (NotaFiscalCompra) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
