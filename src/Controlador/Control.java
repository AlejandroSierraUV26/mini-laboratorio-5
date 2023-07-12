package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Modelo.Dulce;
import Vista.Ventana;

public class Control implements ActionListener{
    private Dulce modelo;
    private Ventana vista;

    public Control(Dulce modelo, Ventana vista){
        this.modelo = modelo;
        this.vista = vista;
        
    }
    public void iniciarVista(){
        vista.setSize(500, 500); 
        vista.setTitle("RINCON DULCE");
        vista.setResizable(false);
        vista.setLocationRelativeTo(null);
        for(int i = 0;i<5;i++ ){
            vista.botonesPanelPrincipal[i].addActionListener(this);
        }
        vista.botonEnviarActualizar.addActionListener(this);
        vista.botonEnviarInsertar.addActionListener(this);
        vista.botonEnviarActualizarOpciones.addActionListener(this);
        vista.botonEliminar.addActionListener(this);
        vista.botonBuscar.addActionListener(this);
        vista.botonRegresar.addActionListener(this);
        vista.botonRegresarListar.addActionListener(this);
        vista.setVisible(true);


        
    }
    @Override
    public void actionPerformed(ActionEvent evento) {
        vista.categoriaSeleccionada = vista.categorias.getSelectedItem().toString();
        if(evento.getSource() == vista.botonesPanelPrincipal[0]){
            vista.panelPrincipal.setVisible(false);
            vista.panelInsertar.setVisible(true);
            vista.add(vista.panelInsertar);
        }
        else if(evento.getSource()==vista.botonEnviarInsertar){
            Short cantidad =0;
            Short precio = 0; 
            boolean ValorError = false;
            if(vista.areaTextoNombre.getText().isEmpty() || vista.areaTextoPrecio.getText().isEmpty() || vista.areaTextoCantidad.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Llene todas las casillas","Advertencia",JOptionPane.WARNING_MESSAGE);       
            }
            else{
           try {
                String userInput = vista.areaTextoPrecio.getText();
                String userInput2 = vista.areaTextoCantidad.getText();
                precio = Short.parseShort(userInput);
                cantidad = Short.parseShort(userInput2); 
                
                ValorError = false;

            } catch (NumberFormatException e) {
                ValorError = true;
            }
            
            String codigo="";
                int x,n;
                String[] letras = 
                {"A","B","C","D","E",
                "F","G","H","I","J", 
                "K","L","M","N","O", 
                "P","Q","R","S","T", 
                "U","V","W","X","Y","Z"};
                for (int i =0;i<3;i++){
                    x = (int) (Math.random() * 26 + 0);
                    codigo += letras[x];
                }
                for (int i =0;i<3;i++){
                    n = (int) (Math.random() * 10 + 0);
                    codigo += n;
                }
                if(ValorError){
                    JOptionPane.showMessageDialog(null,"Error","Advertencia",JOptionPane.WARNING_MESSAGE);
                }
                else{
                    Dulce n1 = new Dulce(vista.areaTextoNombre.getText(),codigo,vista.categorias.getSelectedItem().toString(),cantidad,precio);
                    modelo.lista_dulces.add(n1);
                    
                    JOptionPane.showMessageDialog(null,"El codigo del producto es: " + codigo, "CODIGO", JOptionPane.INFORMATION_MESSAGE);
                    vista.areaTextoNombre.setText(null);
                    vista.categorias.setSelectedItem("Acido");
                    vista.areaTextoPrecio.setText(null);;
                    vista.areaTextoCantidad.setText(null);
                    vista.panelInsertar.setVisible(false);
                    vista.panelPrincipal.setVisible(true);
                    vista.add(vista.panelPrincipal);
                }
                
            }
            
            
        }
        else if(evento.getSource() == vista.botonesPanelPrincipal[1]){
            if(modelo.lista_dulces.size() >0){
                vista.panelPrincipal.setVisible(false);
                vista.panelActualizar.setVisible(true);
                vista.add(vista.panelActualizar);
            }
            else{
                JOptionPane.showMessageDialog(null,"No se pueden Actualizar dulces, sino ha ingresado al menos 1","Advertencia",JOptionPane.WARNING_MESSAGE);
            }
            
        }
        else if(evento.getSource()==vista.botonEnviarActualizar){
            for(int i =0 ; i<modelo.lista_dulces.size() ; i++){
                if(vista.areaTextoActualizar.getText().equals(modelo.lista_dulces.get(i).getCodigo())){
                    if(vista.areaTextoActualizar.getText().isEmpty() || vista.areaTextoActualizar.getText().length()<6){
                        JOptionPane.showMessageDialog(null,"El codigo debe ser de 6 caracteres","Advertencia",JOptionPane.WARNING_MESSAGE);
                    }
                    else{                    
                    vista.etiquetaActualizarDatos.setText(vista.areaTextoActualizar.getText());
                    vista.panelActualizar.setVisible(false);             
                    vista.panelActualizarDatos.setVisible(true);
                    vista.add(vista.panelActualizarDatos);
                    }
                break;
                }
                else{
                    JOptionPane.showMessageDialog(null,"El codigo que ingresa al parecer no existe","Advertencia",JOptionPane.WARNING_MESSAGE);
                }
            }
               
        }
        else if(evento.getSource() == vista.botonEnviarActualizarOpciones){
            Boolean campos_vacios = false;
            Boolean ValorError = false;
            Short cantidad_actualizar =0;
            Short precio_actualizar = 0; 
            vista.contenido5 = vista.areaTextoActualizarNombre.getText().trim();
            vista.contenido6 = vista.areaTextoActualizarPrecio.getText().trim();
            vista.contenido7 = vista.areaTextoActualizarCantidad.getText().trim();
            if(vista.contenido5.isEmpty() && vista.contenido6.isEmpty() && vista.contenido7.isEmpty()){
                campos_vacios = false;
                JOptionPane.showMessageDialog(null,"Debes seleccionar una opcion y llenarla para actualizar","Advertencia",JOptionPane.WARNING_MESSAGE);
            }
            else{
                campos_vacios = true;
            }
            try {
                if (!(vista.contenido6.isEmpty() || vista.contenido7.isEmpty())){
                String precio = vista.areaTextoActualizarPrecio.getText();
                String cantidad = vista.areaTextoActualizarCantidad.getText();
                precio_actualizar = Short.parseShort(precio);
                cantidad_actualizar = Short.parseShort(cantidad); 
                
                ValorError = false; 
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,"En los campos de Precio y Cantidad solo se permiten numericos","Advertencia",JOptionPane.WARNING_MESSAGE);
                ValorError = true;
            }
            if (campos_vacios && !ValorError){
            for(int i=0; i<modelo.lista_dulces.size();i++){
                if(modelo.lista_dulces.get(i).getCodigo().equals(vista.areaTextoActualizar.getText())){
                    if(vista.checkBox1.isSelected()){
                        modelo.lista_dulces.get(i).setNombre(vista.contenido5);
                        
                        }
                    if(vista.checkBox2.isSelected()){
                        modelo.lista_dulces.get(i).setPrecio(precio_actualizar);
                        
                    }
                    if(vista.checkBox3.isSelected()){
                        modelo.lista_dulces.get(i).setCantidad(cantidad_actualizar);      
                        
                    }
                }
            }
            JOptionPane.showMessageDialog(null,"Producto Actualizado","Actualizado",JOptionPane.INFORMATION_MESSAGE);
            vista.checkBox1.setSelected(false);
            vista.checkBox2.setSelected(false);
            vista.checkBox3.setSelected(false);
            vista.areaTextoActualizar.setText(null);
            vista.areaTextoActualizarNombre.setText(null);
            vista.areaTextoActualizarPrecio.setText(null);
            vista.areaTextoActualizarCantidad.setText(null);
            vista.panelActualizarDatos.setVisible(false);
            vista.panelPrincipal.setVisible(true);
                
            vista.add(vista.panelPrincipal);
            }
            
        }

        else if(evento.getSource() == vista.botonesPanelPrincipal[2]){
            if(modelo.lista_dulces.size() >0){
                vista.panelPrincipal.setVisible(false);
                vista.panelEliminar.setVisible(true);
                vista.add(vista.panelEliminar);
            }
            else{
                JOptionPane.showMessageDialog(null,"No se pueden Eliminar dulces, sino ha ingresado al menos 1","Advertencia",JOptionPane.WARNING_MESSAGE);
            }
            
        }
        else if(evento.getSource() == vista.botonEliminar){
            vista.contenido8 = vista.areaTextoEliminar.getText().trim();
            for(int i =0 ; i<modelo.lista_dulces.size() ; i++){
                if(vista.contenido8.equals(modelo.lista_dulces.get(i).getCodigo())){
                    if(vista.contenido8.isEmpty() || vista.contenido8.length()<6){
                        JOptionPane.showMessageDialog(null,"El codigo debe ser de 6 caracteres","Advertencia",JOptionPane.WARNING_MESSAGE);
                    }
                    else{
                        if(modelo.lista_dulces.get(i).getCodigo().equals(vista.contenido8)){
                            modelo.lista_dulces.remove(modelo.lista_dulces.get(i));
                        }
                        
                        JOptionPane.showMessageDialog(null,"Producto Eliminado","Eliminado",JOptionPane.INFORMATION_MESSAGE);
                        vista.areaTextoEliminar.setText(null);
                        vista.panelEliminar.setVisible(false);
                        vista.panelPrincipal.setVisible(true);
                        vista.add(vista.panelPrincipal);
                        break;
                    }
                    
                }
                else{
                    JOptionPane.showMessageDialog(null,"El codigo que ingresa al parecer no existe","Advertencia",JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        else if(evento.getSource() == vista.botonesPanelPrincipal[3]){
            vista.panelPrincipal.setVisible(false);
            vista.panelBuscar.setVisible(true);
            vista.add(vista.panelBuscar);
        }
        else if(evento.getSource() == vista.botonBuscar){
            vista.contenido9 = vista.areaTextoBuscar.getText().trim();
            for(int i =0 ; i<modelo.lista_dulces.size() ; i++){
                if(vista.contenido9.equals(modelo.lista_dulces.get(i).getCodigo())){
                    if(vista.contenido9.isEmpty() || vista.contenido9.length()<6){
                        JOptionPane.showMessageDialog(null,"El codigo debe ser de 6 caracteres","Advertencia",JOptionPane.WARNING_MESSAGE);
                    }
                    else{
                        if(modelo.lista_dulces.get(i).getCodigo().equals(vista.contenido9)){
                            vista.etiquetaBuscarNombre.setText("Nombre: " + modelo.lista_dulces.get(i).getNombre());
                            vista.etiquetaBuscarCategoria.setText("Categoria: "+ modelo.lista_dulces.get(i).getCategoria());
                            vista.etiquetaBuscarCantidad.setText("Cantidad: "+ modelo.lista_dulces.get(i).getCantidad());
                            vista.etiquetaBuscarPrecio.setText("Precio: " + modelo.lista_dulces.get(i).getPrecio());
                        }
                    }
                    break;
                }
                else{
                    JOptionPane.showMessageDialog(null,"El codigo que ingresa al parecer no existe","Advertencia",JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        else if(evento.getSource() == vista.botonRegresar){
            vista.areaTextoBuscar.setText(null);
            vista.etiquetaBuscarNombre.setText(null);
            vista.etiquetaBuscarCategoria.setText(null);
            vista.etiquetaBuscarCantidad.setText(null);
            vista.etiquetaBuscarPrecio.setText(null);
            vista.panelBuscar.setVisible(false);
            vista.panelPrincipal.setVisible(true);
            vista.add(vista.panelPrincipal);
        }
        else if(evento.getSource() == vista.botonesPanelPrincipal[4]){
            for(int i = 0; i<modelo.lista_dulces.size(); i++){
                vista.areaTextoListar.append(modelo.lista_dulces.get(i).MostrarDatos() + "\n\n");
            }
            vista.panelPrincipal.setVisible(false);
            vista.panelListar.setVisible(true);            
            vista.add(vista.panelListar);
        }
        else if(evento.getSource() == vista.botonRegresarListar){
            vista.areaTextoListar.setText(null);
            vista.panelListar.setVisible(false);
            vista.panelPrincipal.setVisible(true);
            vista.add(vista.panelPrincipal);
        }

    }
    
}
