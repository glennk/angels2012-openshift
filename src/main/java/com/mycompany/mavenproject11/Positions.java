/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject11;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author grk
 */
@Entity
@Table(name = "positions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Positions.findAll", query = "SELECT p FROM Positions p"),
    @NamedQuery(name = "Positions.findByIdpositions", query = "SELECT p FROM Positions p WHERE p.idpositions = :idpositions"),
    @NamedQuery(name = "Positions.findByPosition", query = "SELECT p FROM Positions p WHERE p.position = :position")})
public class Positions implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idpositions")
    private Integer idpositions;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "position")
    private String position;
    
    @ManyToOne
    @JoinColumn(name="PLAYERS_ID", nullable=false)
    private Players players;
    
    public Positions() {
    }

    public Positions(Integer idpositions) {
        this.idpositions = idpositions;
    }

    public Positions(Integer idpositions, String position) {
        this.idpositions = idpositions;
        this.position = position;
    }

    public Integer getIdpositions() {
        return idpositions;
    }

    public void setIdpositions(Integer idpositions) {
        this.idpositions = idpositions;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @JsonIgnore
    public Players getPlayers() {
        return players;
    }

    public void setPlayers(Players players) {
        this.players = players;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpositions != null ? idpositions.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Positions)) {
            return false;
        }
        Positions other = (Positions) object;
        if ((this.idpositions == null && other.idpositions != null) || (this.idpositions != null && !this.idpositions.equals(other.idpositions))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject11.Positions[ idpositions=" + idpositions + " ]";
    }
    
}
