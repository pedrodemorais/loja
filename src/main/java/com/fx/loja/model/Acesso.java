package com.fx.loja.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="acesso")
@SequenceGenerator(name = "sq_acesso", sequenceName = "sq_acesso",allocationSize = 1)

public class Acesso implements GrantedAuthority {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_acesso")
    private Long id;
    @Column(nullable = false)
    private String descricao; /* Acesso ex: ROLE_ADMIN ou ROLE_SECRETARIO */

    @Override
    public String getAuthority() {
        return this.descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Acesso)) return false;
        Acesso acesso = (Acesso) o;
        return id.equals(acesso.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
