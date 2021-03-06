/*

   ****MAPEO DE LA ENTIDAD "mensajito"****

 */
package org.unitec.elementos1801;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author T-107
 */

@Entity
public class Mensajito {
    
    //notaciones del id
    @Id
    @GeneratedValue
    private Integer id;
    
    private String titulo;
    private String cuerpo;

    @Override
    public String toString() {
        return "Mensajito{" + "id=" + id + ", titulo=" + titulo + ", cuerpo=" + cuerpo + '}';
    }
    
    //constructores

    public Mensajito() {
    }

    public Mensajito(Integer id, String titulo, String cuerpo) {
        this.id = id;
        this.titulo = titulo;
        this.cuerpo = cuerpo;
    }

    public Mensajito(Integer id) {
        this.id = id;
    }

    public Mensajito(String titulo, String cuerpo) {
        this.titulo = titulo;
        this.cuerpo = cuerpo;
    }
    
    //encapsulacion de los campos
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }
    
}
