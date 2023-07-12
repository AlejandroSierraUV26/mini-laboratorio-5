package Modelo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Traje {
    public ArrayList <Traje> lista_trajes = new ArrayList<Traje>();
    private String nombre;
    private String pais_fabricacion;
    private String material;
    private short precio;
    private String codigo;
    public Traje(String nombre,String codigo, String pais_fabricacion, String material, short precio){
        this.nombre = nombre;
        this.codigo = codigo;
        this.pais_fabricacion = pais_fabricacion;
        this.material = material;
        this.precio = precio;

    }
    public Traje() {
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getpais_fabricacion() {
        return pais_fabricacion;
    }
    public void setpais_fabricacion(String pais_fabricacion) {
        this.pais_fabricacion = pais_fabricacion;
    }
    public String getmaterial() {
        return material;
    }
    public void setMaterial(String material) {
        this.material = material;
    }
    public short getPrecio() {
        return precio;
    } 
    public void setPrecio(short precio) {
        this.precio = precio;
    }
    public String MostrarDatos(){
        String texto;
        texto =(   "           Nombre: " + getNombre()+"                            \n"
                +  "           Codigo : "+ getCodigo() +"                           \n" 
                +  "           Precio : "+ getPrecio() +"                           \n"
                +  "           Pais Fabricacion : " + getpais_fabricacion() +"                \n"                
                +  "           Material : "+ getmaterial()+"                       "); 
        return texto;
    }
    public ArrayList<Traje> getlista_trajes() {
        return lista_trajes;
    }
    public void setlista_trajes(ArrayList<Traje> lista_trajes) {
        this.lista_trajes = lista_trajes;
    }
    public void psbotonInsertar(){
        JOptionPane.showMessageDialog(null,"Boton Insertar Precionado");
    }
    public void psbotonActualizar(){
        JOptionPane.showMessageDialog(null,"Boton Actualizar Precionado");
    }
    public void psbotonEliminar(){
        JOptionPane.showMessageDialog(null,"Boton Eliminar Precionado");
    }
    public void psbotonBuscar(){
        JOptionPane.showMessageDialog(null,"Boton Buscar Precionado");
    }
    public void psbotonListar(){
        JOptionPane.showMessageDialog(null,"Boton Listar Precionado");
    }
}
