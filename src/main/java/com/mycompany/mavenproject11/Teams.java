/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject11;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author grk
 */
@Entity
@Table(name = "teams")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Teams.findAll", query = "SELECT t FROM Teams t"),
    @NamedQuery(name = "Teams.findByIdteams", query = "SELECT t FROM Teams t WHERE t.idteams = :idteams"),
    @NamedQuery(name = "Teams.findByName", query = "SELECT t FROM Teams t WHERE t.name = :name"),
    @NamedQuery(name = "Teams.findByLevel", query = "SELECT t FROM Teams t WHERE t.level = :level")})
public class Teams implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idteams")
    private Integer idteams;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "level")
    private String level;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teamsId")
    private Collection<Players> playersCollection;
    
    @ManyToMany(mappedBy = "teamsCollection")
    private Collection<Coaches> coachesCollection;

    public Teams() {
    }

    public Teams(Integer idteams) {
        this.idteams = idteams;
    }

    public Teams(Integer idteams, String name, String level) {
        this.idteams = idteams;
        this.name = name;
        this.level = level;
    }

    public Integer getIdteams() {
        return idteams;
    }

    public void setIdteams(Integer idteams) {
        this.idteams = idteams;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idteams != null ? idteams.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teams)) {
            return false;
        }
        Teams other = (Teams) object;
        if ((this.idteams == null && other.idteams != null) || (this.idteams != null && !this.idteams.equals(other.idteams))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject11.Teams[ idteams=" + idteams + " ]";
    }

    @JsonIgnore
    public Collection<Players> getPlayersCollection() {
        return playersCollection;
    }

    public void setPlayersCollection(Collection<Players> playersCollection) {
        this.playersCollection = playersCollection;
    }

    @JsonIgnore
    public Collection<Coaches> getCoachesCollection() {
        return coachesCollection;
    }

    public void setCoachesCollection(Collection<Coaches> coachesCollection) {
        this.coachesCollection = coachesCollection;
    }
    
}
