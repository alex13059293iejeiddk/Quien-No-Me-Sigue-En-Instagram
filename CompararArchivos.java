import java.io.*;
import java.util.*;
import javax.swing.*;

public class CompararArchivos {
    public static void main(String[] args) {
        // Nombres de los archivos
        String archivoSeguidos = "following_list.txt";
        String archivoSeguidores = "followers_list.txt";

        // Listas para almacenar los elementos de cada archivo
        Set<String> seguidos = new HashSet<>();
        Set<String> seguidores = new HashSet<>();

        // Leer archivo seguidos.txt
        try (BufferedReader br = new BufferedReader(new FileReader(archivoSeguidos))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                seguidos.add(linea.trim());  // Agregar cada línea (elemento) a la lista
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo " + archivoSeguidos, "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return; // Salir si hay error
        }

        // Leer archivo seguidores.txt
        try (BufferedReader br = new BufferedReader(new FileReader(archivoSeguidores))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                seguidores.add(linea.trim());  // Agregar cada línea (elemento) a la lista
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo " + archivoSeguidores, "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return; // Salir si hay error
        }

        // Comparar los archivos y mostrar los elementos de seguidos.txt que no están en seguidores.txt
        Set<String> diferencia = new HashSet<>(seguidos);
        diferencia.removeAll(seguidores);

        // Preparar el mensaje a mostrar
        StringBuilder mensaje = new StringBuilder();
        if (diferencia.isEmpty()) {
            mensaje.append("No hay NO SEGUIDORES.");
        } else {
            mensaje.append("NO SEGUIDORES:\n");
            for (String elemento : diferencia) {
                mensaje.append(elemento).append("\n");
            }
        }

        // Mostrar el resultado en un JOptionPane
        JOptionPane.showMessageDialog(null, mensaje.toString(), "Resultado de la comparación", JOptionPane.INFORMATION_MESSAGE);
    }
}
