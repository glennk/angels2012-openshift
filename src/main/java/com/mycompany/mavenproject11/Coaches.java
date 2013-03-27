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
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author grk
 */
@Entity
@Table(name = "coaches")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Coaches.findAll", query = "SELECT c FROM Coaches c order by c.lastname"),
    @NamedQuery(name = "Coaches.findById", query = "SELECT c FROM Coaches c WHERE c.idcoaches = :id"),
    @NamedQuery(name = "Coaches.findByFirstname", query = "SELECT c FROM Coaches c WHERE c.firstname = :firstname"),
    @NamedQuery(name = "Coaches.findByLastname", query = "SELECT c FROM Coaches c WHERE c.lastname = :lastname")})
public class Coaches implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcoaches")
    private Integer idcoaches;
    @Size(max = 45)
    @Column(name = "firstname")
    private String firstname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "lastname")
    private String lastname;
    @Size(max = 45)
    @Column(name = "phone1")
    private String phone1;
    @Size(max = 60)
    @Column(name = "email1")
    private String email1;
    @Size(max = 45)
    @Column(name = "phone2")
    private String phone2;
    @Size(max = 60)
    @Column(name = "email2")
    private String email2;
    @Lob
    @Column(name = "photo")
    private byte[] fullsize;

    @JoinTable(name = "teams_has_coaches", joinColumns = {
        @JoinColumn(name = "coaches_idcoaches", referencedColumnName = "idcoaches")}, inverseJoinColumns = {
        @JoinColumn(name = "teams_idteams", referencedColumnName = "idteams")})
    @ManyToMany
    private Collection<Teams> teamsCollection;

    public Coaches() {
    }

    public Coaches(Integer idcoaches) {
        this.idcoaches = idcoaches;
    }

    public Coaches(Integer idcoaches, String lastname) {
        this.idcoaches = idcoaches;
        this.lastname = lastname;
    }

    public Integer getIdcoaches() {
        return idcoaches;
    }

    public void setIdcoaches(Integer idcoaches) {
        this.idcoaches = idcoaches;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    @XmlTransient
    @JsonIgnore
    public byte[] getPhoto() {
        return fullsize;
    }

    public void setPhoto(byte[] photo) {
        this.fullsize = photo;
    }

    
    @XmlTransient
    @JsonIgnore
    public Collection<Teams> getTeamsCollection() {
        return teamsCollection;
    }

    public void setTeamsCollection(Collection<Teams> teamsCollection) {
        this.teamsCollection = teamsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcoaches != null ? idcoaches.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Coaches)) {
            return false;
        }
        Coaches other = (Coaches) object;
        if ((this.idcoaches == null && other.idcoaches != null) || (this.idcoaches != null && !this.idcoaches.equals(other.idcoaches))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject11.Coaches[ idcoaches=" + idcoaches + " ]";
    }
    
}
