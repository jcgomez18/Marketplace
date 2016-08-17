

package models;

import com.avaje.ebean.Model;
import com.fasterxml.jackson.databind.JsonNode;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product extends Model {

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long referencia;


    private String nombre;


    private String descripcion;


    private double precio;


    private int stock;


    private boolean disponible;


    public Product() {
    }


    public Product(String nombre, String descripcion, double precio, int cantidad, boolean ava) {
     this.setNombre(nombre);
        this.setDescripcion(descripcion);
        this.setPrecio(precio);
        this.setStock(cantidad);
        this.setDisponible(ava);
    }





    public Long getReferencia() {
        return referencia;
    }

    public void setReferencia(Long referencia) {
        this.referencia = referencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void incrementarCantidad()
    {
        setStock(getStock() + 1);
    }


    public void reducirCantidad()
    {
        setStock(getStock() - 1);
    }


    public static Product bind(JsonNode j) {
        String nombre = j.findPath("nombre").asText();
        String descripcion = j.findPath("descripcion").asText();
        double precio = j.findPath("precio").asDouble();).asText();
        int stock = j.findPath("stock").asInt();
        boolean disponible = j.findPath("disponible").asBoolean();
       Product product = new Product(nombre,descripcion,precio,stock,disponible);
        return product;
    }
}
