package mx.itesm.strc.prueba_descarga_firebase;

import java.util.ArrayList;
import java.util.LinkedList;

public class Producto {
    Integer id;
    String nombre;
    Double precio_promedio;
    String marca;
    String url_marca_logo;
    ArrayList<String> url_imagenes;
    ArrayList<CATEGORIAS> categorias;
    ArrayList<ArrayList<String>> url_tiendas;
    ArrayList<ArrayList<String>> url_sociales;
    String descripcion;
    Integer likes;

    public static LinkedList<Producto> lista_productos = new LinkedList<>();

    public Producto(Integer id, String nombre, Double precio_promedio, String marca, String url_marca_logo, ArrayList<String> url_imagenes, ArrayList<CATEGORIAS> categorias, ArrayList<ArrayList<String>> url_tiendas, ArrayList<ArrayList<String>> url_sociales, String descripcion, Integer likes) {
        this.id = id;
        this.nombre = nombre;
        this.precio_promedio = precio_promedio;
        this.marca = marca;
        this.url_marca_logo = url_marca_logo;
        this.url_imagenes = url_imagenes;
        this.categorias = categorias;
        this.url_tiendas = url_tiendas;
        this.url_sociales = url_sociales;
        this.descripcion = descripcion;
        this.likes = likes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio_promedio() {
        return precio_promedio;
    }

    public void setPrecio_promedio(Double precio_promedio) {
        this.precio_promedio = precio_promedio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getUrl_marca_logo() {
        return url_marca_logo;
    }

    public void setUrl_marca_logo(String url_marca_logo) {
        this.url_marca_logo = url_marca_logo;
    }

    public ArrayList<String> getUrl_imagenes() {
        return url_imagenes;
    }

    public void setUrl_imagenes(ArrayList<String> url_imagenes) {
        this.url_imagenes = url_imagenes;
    }

    public ArrayList<CATEGORIAS> getCategorias() {
        return categorias;
    }

    public void setCategorias(ArrayList<CATEGORIAS> categorias) {
        this.categorias = categorias;
    }

    public ArrayList<ArrayList<String>> getUrl_tiendas() {
        return url_tiendas;
    }

    public void setUrl_tiendas(ArrayList<ArrayList<String>> url_tiendas) {
        this.url_tiendas = url_tiendas;
    }

    public ArrayList<ArrayList<String>> getUrl_sociales() {
        return url_sociales;
    }

    public void setUrl_sociales(ArrayList<ArrayList<String>> url_sociales) {
        this.url_sociales = url_sociales;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public static LinkedList<Producto> getLista_productos() {
        return lista_productos;
    }

    public static void setLista_productos(LinkedList<Producto> lista_productos) {
        Producto.lista_productos = lista_productos;
    }
}
