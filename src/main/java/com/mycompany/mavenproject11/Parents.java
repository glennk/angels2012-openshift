/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject11;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author grk
 */
@Entity
@Table(name = "parents")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parents.findAll", query = "SELECT p FROM Parents p"),
    @NamedQuery(name = "Parents.findByIdparents", query = "SELECT p FROM Parents p WHERE p.idparents = :idparents"),
    @NamedQuery(name = "Parents.findByParent1", query = "SELECT p FROM Parents p WHERE p.parent1 = :parent1"),
    @NamedQuery(name = "Parents.findByEmail1", query = "SELECT p FROM Parents p WHERE p.email1 = :email1"),
    @NamedQuery(name = "Parents.findByPhone1", query = "SELECT p FROM Parents p WHERE p.phone1 = :phone1"),
    @NamedQuery(name = "Parents.findByParent2", query = "SELECT p FROM Parents p WHERE p.parent2 = :parent2"),
    @NamedQuery(name = "Parents.findByEmail2", query = "SELECT p FROM Parents p WHERE p.email2 = :email2"),
    @NamedQuery(name = "Parents.findByPhone2", query = "SELECT p FROM Parents p WHERE p.phone2 = :phone2")})
public class Parents implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idparents")
    private Integer idparents;
    @Size(max = 60)
    @Column(name = "parent1")
    private String parent1;
    @Size(max = 100)
    @Column(name = "email1")
    private String email1;
    @Size(max = 45)
    @Column(name = "phone1")
    private String phone1;
    @Size(max = 60)
    @Column(name = "parent2")
    private String parent2;
    @Size(max = 100)
    @Column(name = "email2")
    private String email2;
    @Size(max = 45)
    @Column(name = "phone2")
    private String phone2;

    public Parents() {
    }

    public Parents(Integer idparents) {
        this.idparents = idparents;
    }

    public Integer getIdparents() {
        return idparents;
    }

    public void setIdparents(Integer idparents) {
        this.idparents = idparents;
    }

    public String getParent1() {
        return parent1;
    }

    public void setParent1(String parent1) {
        this.parent1 = parent1;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getParent2() {
        return parent2;
    }

    public void setParent2(String parent2) {
        this.parent2 = parent2;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idparents != null ? idparents.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parents)) {
            return false;
        }
        Parents other = (Parents) object;
        if ((this.idparents == null && other.idparents != null) || (this.idparents != null && !this.idparents.equals(other.idparents))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject11.Parents[ idparents=" + idparents + " ]";
    }
    
}
