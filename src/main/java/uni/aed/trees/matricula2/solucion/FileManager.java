package uni.aed.trees.matricula2.solucion;
import java.io.*;
import java.util.*;

public class FileManager {

  public static List<String> readFile(String filePath) throws IOException {
    List<String> lines = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = br.readLine()) != null) {
        lines.add(line);
      }
    }
    return lines;
  }

  public static void writeFile(String filePath, List<String> lines) throws IOException {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
      for (String line : lines) {
        bw.write(line);
        bw.newLine();
      }
    }
  }
}

