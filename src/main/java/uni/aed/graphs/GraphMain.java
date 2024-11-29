package uni.aed.graphs;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import static uni.aed.graphs.DataGraph.*;
import uni.aed.graphs.TopologicalSort.TopologicalSort;
import uni.aed.graphs.recubrimiento.Kruskal;
import uni.aed.graphs.shortestpath.CostPathPair;
import uni.aed.graphs.shortestpath.Dijkstra;

public class GraphMain {
    private static Scanner scr;
    private static int opcion=1;		
    private static String Rpta="S";				
    private static String SEPARADOR="\n";
    public static void main(String[] args) { 
        GraphMain g=new GraphMain();
        scr=new Scanner(System.in).useDelimiter("\n");
        g.menu();
    }
    private void menu(){        
        try{
            
            do			
            {	
                System.out.print("Grafos"+SEPARADOR+
                "1.- Grafo No Dirigido "+SEPARADOR+
                "2.- Grafo Dirigido "+SEPARADOR+
                "3.- Grafo Dirigido con NegativeWeights "+SEPARADOR+                
                "4.- Recorrido primero en amplitud "+SEPARADOR+                
                "5.- Recorrido primero en profundidad "+SEPARADOR+                
                "6.- Dijkstra No Dirigido "+SEPARADOR+                                
                "7.- Kruskal No Dirigido "+SEPARADOR+                
                "8.- Prim No Dirigido "+SEPARADOR+
                "9.- Ordenamiento Topologico con Grafo Dirigido "+SEPARADOR+   
                "10.- Salir "+SEPARADOR+"Elija una opcion:");                
                opcion =scr.nextInt();            
                switch (opcion)
                {
                    case 1 -> {getUndirectedGraph();}
                    case 2 -> {getDirectedGraph();}
                    case 3 -> {getDirectedGraphWithNegativeWeights();}                    
                    case 4 -> {BreadthFirstTraversalTestWithAdjacencyMatrix();}                    
                    case 5 -> {DepthFirstTraversalTestWithAdjacencyMatrix();}                    
                    case 6 -> {getDijkstraUndirected();}                    
                    case 7 -> {getKruskalUndirected();}                    
                    case 8 -> {getPrimUndirected();}                    
                    case 9 -> {getTopologicalSortOnDirectedGraph();}
                    default -> {break;}
                }	            
                System.out.print("Para continuar con las operaciones pulsa S; Para finalizar pulse N: ");
                Rpta=scr.next().toUpperCase();			
            }while(Rpta.equals("S")==true);	
        }catch(InputMismatchException ex) {
            System.out.println("Debe ingresar obligatoriamente un número entero como opcion elegida.");
        }
        catch(Exception e) {
            System.out.println(e.toString());
        }finally{            
            scr.close();
        }
    }
    private void getUndirectedGraph(){
        System.out.println("-----------------undirectedGraph--------------------");
        UndirectedGraph undirectedGraph = new UndirectedGraph();        
        System.out.println(undirectedGraph.graph.toString());
    }
    private void getDirectedGraph(){
        System.out.println("-----------------directedGraph--------------------");
        DirectedGraph directedGraph = new DirectedGraph();
        System.out.println(directedGraph.graph.toString());
    }
    private void getDirectedGraphWithNegativeWeights(){
        System.out.println("-----------------directedWithNegativeWeights--------------------");
        DirectedWithNegativeWeights directedWithNegativeWeights = new DirectedWithNegativeWeights();        
        System.out.println(directedWithNegativeWeights.graph.toString());
    }
    private void BreadthFirstTraversalTestWithAdjacencyMatrix() {
         final byte[][] adjacencyMatrix = new byte[4][4];        
            // v0
            adjacencyMatrix[0][1] = 1;
            adjacencyMatrix[0][2] = 1;
            // v1
            adjacencyMatrix[1][2] = 1;
            // v2
            adjacencyMatrix[2][0] = 1;
            adjacencyMatrix[2][3] = 1;
            // v3
            adjacencyMatrix[3][3] = 1;        
        
        StringBuilder str=new StringBuilder();
        str.append("\nStart=v2:");                    
        for(int r:BreadthFirstTraversal.breadthFirstTraversal(4, adjacencyMatrix, 2)){
            if(!str.isEmpty())
                str.append(",");
            str.append(r);            
        }
        str.append("\nStart=v0:");                    
        for(int r:BreadthFirstTraversal.breadthFirstTraversal(4, adjacencyMatrix, 0)){
            if(!str.isEmpty())
                str.append(",");
            str.append(r);            
        }
        System.out.println(str.toString());        
        System.out.println("BreadthFirstTraversalTestWithGraph");        
        BreadthAndDepthFirstTraversalTestWithGraph(1);
    }
    private void BreadthAndDepthFirstTraversalTestWithGraph(int type) {
        final List<Vertex<Integer>>    vertices    = new ArrayList<>();
        final List<Edge<Integer>>      edges       = new ArrayList<>();

        final Vertex<Integer> v0 = new Vertex<>(0);
        final Vertex<Integer> v1 = new Vertex<>(1);
        final Vertex<Integer> v2 = new Vertex<>(2);
        final Vertex<Integer> v3 = new Vertex<>(3);
    
        vertices.add(v0);
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);

        edges.add(new Edge<>(0, v0, v1));
        edges.add(new Edge<>(0, v0, v2));
        edges.add(new Edge<>(0, v1, v2));
        edges.add(new Edge<>(0, v2, v0));
        edges.add(new Edge<>(0, v2, v3));
        edges.add(new Edge<>(0, v3, v3));    
        final Graph<Integer> graph = new Graph<>(Graph.TYPE.DIRECTED, vertices, edges);        
        StringBuilder str=new StringBuilder();
        if(type==1)//Breadth                
        {
            str.append("\nStart=v2:");                    
            for(Vertex<Integer> r: BreadthFirstTraversal.breadthFirstTraversal(graph, v2)){
                if(!str.isEmpty())
                    str.append(",");
                str.append(r.getValue());            
            }
            str.append("\nStart=v0:");                    
            for(Vertex<Integer> r: BreadthFirstTraversal.breadthFirstTraversal(graph, v0)){
                if(!str.isEmpty())
                    str.append(",");
                str.append(r.getValue());            
            }
        }
        if(type==2)//Depth
        {
            str.append("\nStart=v2:");                    
            for(Vertex<Integer> r: DepthFirstTraversal.depthFirstTraversal(graph, v2)){
                if(!str.isEmpty())
                    str.append(",");
                str.append(r.getValue());            
            }
            str.append("\nStart=v0:");                    
            for(Vertex<Integer> r: DepthFirstTraversal.depthFirstTraversal(graph, v0)){
                if(!str.isEmpty())
                    str.append(",");
                str.append(r.getValue());            
            }
        }
        System.out.println(str.toString());      
        
    }
    
    private void DepthFirstTraversalTestWithAdjacencyMatrix() {
        final byte[][] adjacencyMatrix = new byte[4][4];    
        // v0
        adjacencyMatrix[0][1] = 1;
        adjacencyMatrix[0][2] = 1;
        // v1
        adjacencyMatrix[1][2] = 1;
        // v2
        adjacencyMatrix[2][0] = 1;
        adjacencyMatrix[2][3] = 1;
        // v3
        adjacencyMatrix[3][3] = 1;       
        
        StringBuilder str=new StringBuilder();
        str.append("\nStart=v2:");                    
        for(int r:DepthFirstTraversal.depthFirstTraversal(4, adjacencyMatrix, 2)){
            if(!str.isEmpty())
                str.append(",");
            str.append(r);            
        }
        str.append("\nStart=v0:");                    
        for(int r:DepthFirstTraversal.depthFirstTraversal(4, adjacencyMatrix, 0)){
            if(!str.isEmpty())
                str.append(",");
            str.append(r);            
        }
        System.out.println(str.toString());        
        System.out.println("DepthFirstTraversalTestWithGraph");        
        BreadthAndDepthFirstTraversalTestWithGraph(2);
        
    }
    
    
    private void getDijkstraUndirected(){
        UndirectedGraph undirected = new UndirectedGraph();
        Vertex<Integer> start = undirected.v1;
        Vertex<Integer> end = undirected.v5;        
        
        Map<Vertex<Integer>, CostPathPair<Integer>> map 
                = Dijkstra.getShortestPaths(undirected.graph, start);
        
        // Compare results
        CostPathPair<Integer> path,pair;
        System.out.println("****Dijkstra.getShortestPaths del vertice inicial: "+start.getValue()+" ****");
        for (Vertex<Integer> v : map.keySet()) {
            System.out.println("v=" + v.getValue());
            path = map.get(v);
            System.out.println("Dijkstra's shortest path=" + path);
        }
        
        System.out.println("****Dijkstra.getShortestPath del vertice inicial: "+start.getValue()+" vertice final: "+end.getValue()+" ****");
        pair = Dijkstra.getShortestPath(undirected.graph, start, end);
        System.out.println("Ruta desde " + start.getValue() + " to " + 
                end.getValue()+ " (pair != null)= " + (pair != null));        
        System.out.println(pair);        
    }
    private void getKruskalUndirected(){
        UndirectedGraph undirected = new UndirectedGraph();
        CostPathPair<Integer> resultMST = Kruskal.getMinimumSpanningTree(undirected.graph);
        System.out.println("Kruskal's minimum spanning tree. resultMST=" + resultMST);   
    }
    private void getPrimUndirected(){
        System.out.println("Prim's minimum spanning tree error. pair4|result4="+primUndirected());                
    }
    private void getTopologicalSortOnDirectedGraph(){        
        Graph<Integer> digraph = topologicalSortOnDirectedGraph();
        List<Vertex<Integer>> result = TopologicalSort.sort(digraph);
        System.out.println("Los elementos del Digrafo es");
        System.out.println(digraph.toString());
        System.out.println("Las aristas del digrafo");
        System.out.println(digraph.getEdges().toString());
        System.out.println("Topological sort. results="+result);
        }
}
