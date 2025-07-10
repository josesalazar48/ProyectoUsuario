/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios;

import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;


/**
 *
 * @author JOSE SALAZAR
 */
public class Utilidades {
    private String path = "data";
    public void save(String text, String name_file) throws IOException{
        File carpeta = new File(path);
        if(!carpeta.exists()){
            carpeta.mkdirs();
        }
         File file = new File(path+File.separatorChar+name_file);
        if(!file.exists()){
            file.createNewFile();
        }
        FileWriter escribir = new FileWriter(file, true);
        escribir.write(text);
        escribir.close();
    }

    public String[] readLines(String name_file) throws IOException {
    File file = new File(path + File.separatorChar + name_file);
    if (!file.exists()) {
        return new String[0]; // Retorna arreglo vacío si no existe
    }

    // PRIMERA PASADA: contar líneas
    int lineCount = 0;
    BufferedReader br1 = new BufferedReader(new FileReader(file));
    while (br1.readLine() != null) {
        lineCount++;
    }
    br1.close();

    // SEGUNDA PASADA: leer y llenar el arreglo
    String[] resultado = new String[lineCount];
    BufferedReader br2 = new BufferedReader(new FileReader(file));
    String line;
    int index = 0;
    while ((line = br2.readLine()) != null) {
        resultado[index++] = line;
    }
    br2.close();

    return resultado;
}
}