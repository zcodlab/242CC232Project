/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uni.aed.trees.matricula.solucion;

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

/**
 *
 * @author OTI-FC24
 */
public class SistemaMatricula {
    private Node<Curso> root;
    private String filenombre;
    
    public SistemaMatricula(String file){
        root=null;
        filenombre=file;
        readfile();
    }
    
    private void readfile(){
        try(Scanner scr=new Scanner(new File(filenombre))){
            int position=0;
            while(scr.hasNextLine()){
                String line=scr.nextLine();
                String[] parts=line.split("\\s+");
                System.out.println("");
                if(parts.length!=4){
                    System.out.println("error en posicion " + position);
                    continue;
                }
                String nombre=parts[0];
                String codigo=parts[1];
                int numMatriculados=Integer.parseInt(parts[2]);
                int maxMatriculados=Integer.parseInt(parts[3]);
                Node<Curso> newNode= new Node<>(new Curso(nombre, codigo, numMatriculados, maxMatriculados),position);
                root=insert(root,newNode);                
                position++;
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
    
    
    
    private Node<Curso> insert(Node<Curso> root,Node<Curso> newNode){
        if(root==null)
            return newNode;
        int compareResult=newNode.getKey().getNombre().compareTo(root.getKey().getNombre());
        if(compareResult<0)
            root.left=insert(root.left,newNode);
        else if(compareResult>0)
            root.right=insert(root.right,newNode);
        else{
            root.getKey().setNumMatriculados(root.getKey().getNumMatriculados() + newNode.getKey().getNumMatriculados());            
            root.getKey().setMaxMatriculados(root.getKey().getMaxMatriculados()- newNode.getKey().getNumMatriculados());
        }
        return root;
    }
    
    public void verArbol(){
        System.out.println(root.toString());
    }
    
    public void inOrder(){
        inorderH(root);
    }
    
    private void inorderH(Node<Curso> nodo){
        if(nodo==null) return;
        inorderH(nodo.getLeft());
        System.out.println(nodo.getKey().toString());
        inorderH(nodo.getRight());
    }

    public void addCurso(String nombre, String codigo, int num, int max) {
        Node<Curso> newNodo = new Node<>(new Curso(nombre,codigo,num,max),-1);
        root=insert(root,newNodo);
        updateFile();
    }
    
    private void updateFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filenombre))) {
            inorderWriteToFile(root, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void inorderWriteToFile(Node<Curso> root, BufferedWriter writer) throws IOException {
        if (root != null) {
            inorderWriteToFile(root.left, writer);
            writer.write(root.getKey().getNombre()+ " " + root.getKey().getCodigo() + " " + root.getKey().getNumMatriculados() + " " + root.getKey().getMaxMatriculados());
            writer.newLine();
            inorderWriteToFile(root.right, writer);
        }
    }
    
    public void matricularAlumnos(String nombre,String codigo,int numMatricula){
        Node<Curso> node=findNode(root,nombre,codigo);
        if(node!=null){
            node.getKey().setNumMatriculados(node.getKey().getNumMatriculados() + numMatricula);      
            node.getKey().setMaxMatriculados(node.getKey().getMaxMatriculados()- numMatricula);
            updateFile();
        }
    }
    
    public void anularMatricula(String nombre,String codigo,int numMatricula){
        Node<Curso> node=findNode(root,nombre,codigo);
        if(node!=null){
            node.getKey().setNumMatriculados(node.getKey().getNumMatriculados() - numMatricula);               
            node.getKey().setMaxMatriculados(node.getKey().getMaxMatriculados()+ numMatricula);
            updateFile();
            if(node.getKey().getNumMatriculados()==0) deleteMerge(nombre,codigo);
        }
    }
    
    private void deleteMerge(String nombre, String codigo) {
        Node<Curso> tmp, node, p = root, prev = null;
        int compareResult = (nombre + codigo).compareTo(p.getKey().getNombre() + p.getKey().getCodigo());
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
    
    private Node<Curso> findNode(Node<Curso> root,String nombre,String codigo){
        if(root==null || (root.getKey().getNombre().equals(nombre) &&
                root.getKey().getCodigo().equals(codigo)))
            return root;
        
        int compareResult=(nombre+codigo).compareTo(
                root.getKey().getNombre()+root.getKey().getCodigo());
        if(compareResult<0)
            return findNode(root.left,nombre,codigo);
        else
            return findNode(root.right,nombre,codigo);
    }
    
    public void cleanUpFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filenombre)); BufferedWriter writer = new BufferedWriter(new FileWriter(filenombre + ".tmp"))) {

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
                int numMatriculados = Integer.parseInt(parts[2]);
                if (numMatriculados == 0) {
                    while (position < lines.size() && !stock) {
                        String lineLast = lines.get(lines.size() - 1);
                        String[] partsLast = lineLast.split("\\s+");
                        int numMatriculadosLast = Integer.parseInt(partsLast[2]);
                        if (numMatriculadosLast > 0) {
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
                String nombre = parts[0];
                String codigo = parts[1];
                int numMatriculados = Integer.parseInt(parts[2]);
                int maxMatriculados = Integer.parseInt(parts[3]);
                if (numMatriculados > 0) {
                    writer.write(nombre + " " + codigo + " " + numMatriculados + " " + maxMatriculados);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        File originalFile = new File(filenombre);
        if (originalFile.delete()) {
            File tempFile = new File(filenombre + ".tmp");
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
