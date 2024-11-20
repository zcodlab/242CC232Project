package uni.aed.trees.softwarestore;

import uni.aed.model.Software;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import uni.aed.queueTDA.LinkedQueueTDA;
import uni.aed.queueTDA.QueueTDA;

public class SoftwareStore {
    private Node<Software> root;
    private String filename;

    public SoftwareStore(String filename) {
        this.root=null;
        this.filename = filename;
        readFromFile();
    }
    private void readFromFile(){
        try(Scanner scr=new Scanner(new File(filename))){
            int position=0;
            while(scr.hasNextLine()){
                String line=scr.nextLine();
                String[] parts=line.split("\\s+");
                if(parts.length!=4)
                    continue;
                String name=parts[0];
                String version=parts[1].toString();
                int quantity=Integer.parseInt(parts[2]);
                int price=Integer.parseInt(parts[3]);
                Node<Software> newNode= new Node<>(new Software(name, version, quantity, price),position);
                root=insert(root,newNode);                
                position++;
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
    private Node<Software> insert(Node<Software> root,Node<Software> newNode){
        if(root==null)
            return newNode;
        int compareResult=newNode.getKey().getName().compareTo(root.getKey().getName());
        if(compareResult<0)
            root.left=insert(root.left,newNode);
        else if(compareResult>0)
            root.right=insert(root.right,newNode);
        else//se trataria del mismo producto por lo que solo corresponde incrementar la cantidad producto
            root.getKey().setQuantity(root.getKey().getQuantity() + newNode.getKey().getQuantity());            
        return root;
    }
    public void addSoftware(String name, String version, int quantity, int price) {
        Node<Software> newNode = new Node<>(new Software(name, version, quantity, price), -1);
        root = insert(root, newNode); //Inserta o suma la cantidad de software
        updateFile(); //Actualiza archivo .txt
    }
    
    public void sellSoftware(String name,String version,int quantitySold){
        Node<Software> node=findNode(root,name,version);
        if(node!=null){
            node.getKey().setQuantity(node.getKey().getQuantity() - quantitySold);               
            updateFile();
            if(node.getKey().getQuantity()<=0)
                deleteMerge(name,version);
        }
    }
    public void breadthFirst() {
        Node<Software> p = root;
        QueueTDA queue = new LinkedQueueTDA();
        if (p != null) {
            queue.enqueue(p);
            while (!queue.isEmpty()) {
                p = (Node<Software>) queue.dequeue();
                visit(p);
                if (p.left != null) {
                    queue.enqueue(p.left);
                }
                if (p.right != null) {
                    queue.enqueue(p.right);
                }
            }
        }
    }
    
    public void visit(Node<Software> p) {
        if (p != null) {
            System.out.println(p.getKey().toString() + " ");
        } else {
            System.out.println("Nodo No existe");
        }
    }
    
    private Node<Software> findNode(Node<Software> root,String name,String version){
        if(root==null || (root.getKey().getName().equals(name) &&
                root.getKey().getVersion().equals(version)))
            return root;
        
        int compareResult=(name+version).compareTo(
                root.getKey().getName()+root.getKey().getVersion());
        if(compareResult<0)
            return findNode(root.left,name,version);
        else
            return findNode(root.right,name,version);
    }
    
    private void deleteMerge(String name, String version) {
        Node<Software> tmp, node, p = root, prev = null;
        int compareResult = (name + version).compareTo(p.getKey().getName() + p.getKey().getVersion());
        while (p != null && compareResult != 0) {
            prev = p;
            if (compareResult < 0) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        node = p;
        if (p != null && compareResult == 0) {
            if (node.right == null) {
                node = node.left;
            } else if (node.left == null) {
                node = node.right;
            } else {
                tmp = node.left;
                while (tmp.right != null) {
                    tmp = tmp.right;
                }
                tmp.right = node.right;
                node = node.left;
            }
        }
        if (p == root) {
            root = node;
        }
    }
     private void updateFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            inorderWriteToFile(root, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void inorderWriteToFile(Node<Software> root, BufferedWriter writer) throws IOException {
        if (root != null) {
            inorderWriteToFile(root.left, writer);
            writer.write(root.getKey().getName() + " " + root.getKey().getVersion() + " " + root.getKey().getQuantity() + " " + root.getKey().getPrice());
            writer.newLine();
            inorderWriteToFile(root.right, writer);
        }
    }

    public void inventarioSoftware() {
        try (Scanner scanner = new Scanner(new File(filename))) { // LEE DIRECTAMENTE EL ARCHIVO, NO EL ÁRBOL
            System.out.printf("%-30s %-15s %-10s %-10s%n", "Nombre", "Versión", "Cantidad", "Precio");
            System.out.println("--------------------------------------------------------------------------------");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");

                if (parts.length >= 4) {
                    String name = parts[0];
                    String version = parts[1];
                    String quantity = parts[2];
                    String price = parts[3];

                    System.out.printf("%-30s %-15s %-10s %-10s%n", name, version, quantity, price);
                }
            }
            System.out.println("--------------------------------------------------------------------------------");
        } catch (FileNotFoundException e) {
            System.err.println("No se pudo encontrar el archivo: " + filename);
        }
    }

    public void displayMenu() {
        System.out.println("TIENDA DE SOFTWARE");
        System.out.println("1. Sell Software");
        System.out.println("2. Add Software");
        System.out.println("3. Ver Inventario");
        System.out.println("4. Exit");
    }

    public void cleanUpFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename)); BufferedWriter writer = new BufferedWriter(new FileWriter(filename + ".tmp"))) {

            String line;
            int position = 0;
            List<String> lines = new LinkedList<>();
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            boolean stock = false;
            while (position < lines.size()) {
                line = lines.get(position);
                String[] parts = line.split("\\s+");
                int quantity = Integer.parseInt(parts[2]);
                if (quantity == 0) {
                    while (position < lines.size() && !stock) {
                        String lineLast = lines.get(lines.size() - 1);
                        String[] partsLast = lineLast.split("\\s+");
                        int quantityLast = Integer.parseInt(partsLast[2]);
                        if (quantityLast > 0) {
                            stock = true;
                            lines.set(position, lineLast);
                        }
                        lines.remove(lines.size() - 1);
                    }
                }
                position++;
            }
            for (String fline : lines) {
                String[] parts = fline.split("\\s+");
                String name = parts[0];
                String version = parts[1];
                int quantity = Integer.parseInt(parts[2]);
                int price = Integer.parseInt(parts[3]);
                if (quantity > 0) {
                    writer.write(name + " " + version + " " + quantity + " " + price);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        File originalFile = new File(filename);
        if (originalFile.delete()) {
            File tempFile = new File(filename + ".tmp");
            if (tempFile.renameTo(originalFile)) {
                System.out.println("Archivo limpiado y actualizado correctamente.");
            } else {
                System.out.println("Error al renombrar el archivo temporal.");
            }
        } else {
            System.out.println("Error al borrar el archivo original.");
        }

    }
    
}
