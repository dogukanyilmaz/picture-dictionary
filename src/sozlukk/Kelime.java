/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sozlukk;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.swing.ImageIcon;

/**
 *
 * @author Doğukan Yılmaz
 */
@Entity
@Table(name = "KELIME", catalog = "", schema = "DYILMAZ")

@NamedQueries({
    @NamedQuery(name = "Kelime.findAll", query = "SELECT k FROM Kelime k")
    , @NamedQuery(name = "Kelime.findById", query = "SELECT k FROM Kelime k WHERE k.id = :id")
    , @NamedQuery(name = "Kelime.findByTurkce", query = "SELECT k FROM Kelime k WHERE k.turkce = :turkce")
    , @NamedQuery(name = "Kelime.findByIngilizce", query = "SELECT k FROM Kelime k WHERE k.ingilizce = :ingilizce")
    , @NamedQuery(name = "Kelime.findByAlmanca", query = "SELECT k FROM Kelime k WHERE k.almanca = :almanca")})
public class Kelime implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "TURKCE")
    private String turkce;
    @Column(name = "INGILIZCE")
    private String ingilizce;
    @Column(name = "ALMANCA")
    private String almanca;
    @Lob
    @Column(name = "RESIM")
    private byte[] resim;
    public ImageIcon getKelimeResim(){
        return new ImageIcon (new ImageIcon(resim).getImage().getScaledInstance(100,100,java.awt.Image.SCALE_SMOOTH));
    }

    public Kelime() {
    }

    public Kelime(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getTurkce() {
        return turkce;
    }

    public void setTurkce(String turkce) {
        String oldTurkce = this.turkce;
        this.turkce = turkce;
        changeSupport.firePropertyChange("turkce", oldTurkce, turkce);
    }

    public String getIngilizce() {
        return ingilizce;
    }

    public void setIngilizce(String ingilizce) {
        String oldIngilizce = this.ingilizce;
        this.ingilizce = ingilizce;
        changeSupport.firePropertyChange("ingilizce", oldIngilizce, ingilizce);
    }

    public String getAlmanca() {
        return almanca;
    }

    public void setAlmanca(String almanca) {
        String oldAlmanca = this.almanca;
        this.almanca = almanca;
        changeSupport.firePropertyChange("almanca", oldAlmanca, almanca);
    }

    public byte[] getResim() {
        return resim;
    }

    public void setResim(byte[] resim) {
        byte[] oldResim = this.resim;
        this.resim = resim;
        changeSupport.firePropertyChange("resim", oldResim, resim);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kelime)) {
            return false;
        }
        Kelime other = (Kelime) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sozlukk.Kelime[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
