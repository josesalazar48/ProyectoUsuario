/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author JOSE SALAZAR
 */
public class Usuariocontroller {
    private Utilidades u = new Utilidades();
    private String file_name = "Usuario.data";
    public boolean guardarUsuario(String Usuario, String clave, String confirmar){
          if (existeUsuario(Usuario)) {
        return false; 
    }

    String data = Usuario + "\t" + clave + "\n";
    try {
        u.save(data, file_name);
        return true;
    } catch (Exception e) {
        return false;
    }
    }
     public boolean existeUsuario(String usuario) {
       try {
           String[] lineas = u.readLines(file_name);
        for (String line : lineas) {
            String[] partes = line.split("\t");
            if (partes.length >= 1 && partes[0].equalsIgnoreCase(usuario)) {
                return true;
            }
        }
    } catch (IOException e) {
        e.printStackTrace(); 
    }
    return false;
     }
     public boolean iniciarSesion(String Usuario, String clave){
         try {
             String[] lineas = u.readLines(file_name);
        for (String line : lineas) {
            String[] partes = line.split("\t");
            if (partes.length >= 2) {
                String usuarioGuardado = partes[0].trim();
                String claveGuardada = partes[1].trim();

                if (usuarioGuardado.equalsIgnoreCase(Usuario.trim()) &&
                    claveGuardada.equals(clave.trim())) {
                    return true; 
                }
            }
        }
    } catch (IOException e) {
        e.printStackTrace(); 
    }
    return false;
     }
}
