package org.example.database.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "echipa", schema = "public", catalog = "turneu")
public class EchipaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idechipa", nullable = false)
    private long idechipa;
    @Basic
    @Column(name = "nume", nullable = false, length = -1)
    private String nume;
    @Basic
    @Column(name = "puncte", nullable = true)
    private Integer puncte;
    @Basic
    @Column(name = "golaveraj", nullable = true, length = -1)
    private String golaveraj;

    public long getIdechipa() {
        return idechipa;
    }

    public void setIdechipa(long idechipa) {
        this.idechipa = idechipa;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Integer getPuncte() {
        return puncte;
    }

    public void setPuncte(Integer puncte) {
        this.puncte = puncte;
    }

    public String getGolaveraj() {
        return golaveraj;
    }

    public void setGolaveraj(String golaveraj) {
        this.golaveraj = golaveraj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EchipaEntity echipa = (EchipaEntity) o;
        return idechipa == echipa.idechipa && Objects.equals(nume, echipa.nume) && Objects.equals(puncte, echipa.puncte) && Objects.equals(golaveraj, echipa.golaveraj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idechipa, nume, puncte, golaveraj);
    }
}
