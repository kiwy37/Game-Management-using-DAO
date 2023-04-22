package org.example.database.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "meci", schema = "public", catalog = "turneu")
public class MeciEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idmeci", nullable = false)
    private int idmeci;
    @Basic
    @Column(name = "idechipa1", nullable = true)
    private Integer idechipa1;
    @Basic
    @Column(name = "idechipa2", nullable = true)
    private Integer idechipa2;
    @Basic
    @Column(name = "rezultat", nullable = true, length = -1)
    private String rezultat;

    public int getIdmeci() {
        return idmeci;
    }

    public void setIdmeci(int idmeci) {
        this.idmeci = idmeci;
    }

    public Integer getIdechipa1() {
        return idechipa1;
    }

    public void setIdechipa1(Integer idechipa1) {
        this.idechipa1 = idechipa1;
    }

    public Integer getIdechipa2() {
        return idechipa2;
    }

    public void setIdechipa2(Integer idechipa2) {
        this.idechipa2 = idechipa2;
    }

    public String getRezultat() {
        return rezultat;
    }

    public void setRezultat(String rezultat) {
        this.rezultat = rezultat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MeciEntity that = (MeciEntity) o;
        return idmeci == that.idmeci && Objects.equals(idechipa1, that.idechipa1) && Objects.equals(idechipa2, that.idechipa2) && Objects.equals(rezultat, that.rezultat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idmeci, idechipa1, idechipa2, rezultat);
    }
}
