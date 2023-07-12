package Principal;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ManejadorArchivos {
    public void leerArchivo(){
        File archivo = new File("files/archivo.txt");
        try {
            FileReader reader = new FileReader(archivo);
            try (BufferedReader buffer = new BufferedReader(reader)) {
                String linea = "";
                while ((linea = buffer.readLine()) != null){
                    System.out.println(linea);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void leerArchivo2(){
        try {
            try (RandomAccessFile archivo = new RandomAccessFile("files/archivo.txt", "r")) {
                String linea = "";
                while ((linea = archivo.readLine()) != null){
                    System.out.println(linea);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void escribirArchivo(String texto){
        try (RandomAccessFile archivo = new RandomAccessFile("files/archivo.txt", "rw")) {
            archivo.seek(archivo.length());
            archivo.writeBytes("\n" + texto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void escribirArchivos2(){
        File archivo = new File("files/archivo.txt");
        try{
            FileReader reader = new FileReader(archivo);
            try (BufferedReader buffer = new BufferedReader(reader)) {
                String linea = "";
                String contenido = "";
                while ((linea = buffer.readLine()) != null){
                    contenido += linea;
                }
                for(int i = 0; i<10;i++){
                    contenido += "\n"+i;
                }
                FileWriter writter = new FileWriter(archivo);
                BufferedWriter bufferedWriter = new BufferedWriter(writter);
                bufferedWriter.write(contenido);
                bufferedWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
