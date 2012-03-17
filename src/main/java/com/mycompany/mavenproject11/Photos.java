/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject11;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author grk
 */
@Entity
@Table(name = "photos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Photos.findAll", query = "SELECT p FROM Photos p"),
    @NamedQuery(name = "Photos.findByIdphotos", query = "SELECT p FROM Photos p WHERE p.idphotos = :idphotos")})
public class Photos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idphotos")
    private Integer idphotos;
    @Lob
    @Column(name = "thumbnail")
    private byte[] thumbnail;
    @Lob
    @Column(name = "fullsize")
    private byte[] fullsize;
//    @JoinColumn(name = "players_idplayers", referencedColumnName = "idplayers")
//    @ManyToOne(optional = false)
//    private Players playersIdplayers;

    public Photos() {
    }

    public Photos(Integer idphotos) {
        this.idphotos = idphotos;
    }

    public Integer getIdphotos() {
        return idphotos;
    }

    public void setIdphotos(Integer idphotos) {
        this.idphotos = idphotos;
    }

    public byte[] getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(byte[] thumbnail) {
        this.thumbnail = thumbnail;
    }

    public byte[] getFullsize() {
        return fullsize;
    }

    public void setFullsize(byte[] fullsize) {
        this.fullsize = fullsize;
    }

//    @XmlTransient
//    public Players getPlayersIdplayers() {
//        return playersIdplayers;
//    }
//
//    public void setPlayersIdplayers(Players playersIdplayers) {
//        this.playersIdplayers = playersIdplayers;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idphotos != null ? idphotos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Photos)) {
            return false;
        }
        Photos other = (Photos) object;
        if ((this.idphotos == null && other.idphotos != null) || (this.idphotos != null && !this.idphotos.equals(other.idphotos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject9.Photos[ idphotos=" + idphotos + " ]";
    }
    
}
