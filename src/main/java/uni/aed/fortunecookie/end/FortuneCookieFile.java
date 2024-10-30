package uni.aed.fortunecookie.end;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import uni.aed.tda.linkedlistTDA.LinkedListTDA;
import uni.aed.tda.listTDA.ListTDA;

public class FortuneCookieFile {
    private ListTDA<String> lista;

    public FortuneCookieFile(String nombreArchivo) {
        lista = new LinkedListTDA<>();        
        loadFortunesFromFileAbsolutePath(nombreArchivo);
    }

    public ListTDA<String> getLista() {
        return lista;
    }   

    //el archivo debe estar dentro del classpath (como en src/main/resources) para poder cargarlo como un recurso.
    private void loadFortunesFromFile(String filePath) {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filePath);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lista.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //acceder a archivo con ruta absoluta: loadFortunesFromFile("src\\main\\java\\uni\\aed\\FortuneCookie\\fortunes.txt");
    private void loadFortunesFromFileAbsolutePath(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lista.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Método para actualizar el archivo con la lista actualizada
    public void updateFile(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Object line : lista.toArray()) {
                writer.write(line.toString());
                writer.newLine();
            }            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
