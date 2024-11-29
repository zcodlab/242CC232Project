package uni.aed.graphs;

import uni.aed.graphs.shortestpath.CostPathPair;
import java.util.ArrayList;
import java.util.List;
import uni.aed.graphs.recubrimiento.Prim;

public class DataGraph {   
    
    protected static class UndirectedGraph{//1.grafo no dirigido
        private final List<Vertex<Integer>> verticies = new ArrayList<>();
        protected final Vertex<Integer> v1 = new Vertex<>(1);
        protected final Vertex<Integer> v2 = new Vertex<>(2);
        protected final Vertex<Integer> v3 = new Vertex<>(3);
        protected final Vertex<Integer> v4 = new Vertex<>(4);
        protected final Vertex<Integer> v5 = new Vertex<>(5);
        protected final Vertex<Integer> v6 = new Vertex<>(6);
        protected final Vertex<Integer> v7 = new Vertex<>(7);
        protected final Vertex<Integer> v8 = new Vertex<>(8);
        {
        verticies.add(v1);
        verticies.add(v2);
        verticies.add(v3);
        verticies.add(v4);
        verticies.add(v5);
        verticies.add(v6);
        verticies.add(v7);
        verticies.add(v8);}
        
        private final List<Edge<Integer>> edges = new ArrayList<>();
        protected final Edge<Integer> e1_2 = new Edge<>(7, v1, v2);
        protected final Edge<Integer> e1_3 = new Edge<>(9, v1, v3);
        protected final Edge<Integer> e1_6 = new Edge<>(14, v1, v6);
        protected final Edge<Integer> e2_3 = new Edge<>(10, v2, v3);
        protected final Edge<Integer> e2_4 = new Edge<>(15, v2, v4);
        protected final Edge<Integer> e3_4 = new Edge<>(11, v3, v4);
        protected final Edge<Integer> e3_6 = new Edge<>(2, v3, v6);
        protected final Edge<Integer> e5_6 = new Edge<>(9, v5, v6);
        protected final Edge<Integer> e4_5 = new Edge<>(6, v4, v5);
        protected final Edge<Integer> e1_7 = new Edge<>(1, v1, v7);
        protected final Edge<Integer> e1_8 = new Edge<>(1, v1, v8);
        
        {edges.add(e1_2);
        edges.add(e1_3);
        edges.add(e1_6);
        edges.add(e2_3);
        edges.add(e2_4);
        edges.add(e3_4);
        edges.add(e3_6);
        edges.add(e5_6);
        edges.add(e4_5);
        edges.add(e1_7);
        edges.add(e1_8);}
        
        protected final Graph<Integer> graph = new Graph<>(verticies, edges);             
    }
    protected static class DirectedGraph{//2.grafo dirigido
        private final List<Vertex<Integer>> verticies = new ArrayList<>();
        
        protected final Vertex<Integer> v1 = new Vertex<>(1);        
        protected final Vertex<Integer> v2 = new Vertex<>(2);
        protected final Vertex<Integer> v3 = new Vertex<>(3);
        protected final Vertex<Integer> v4 = new Vertex<>(4);
        protected final Vertex<Integer> v5 = new Vertex<>(5);
        protected final Vertex<Integer> v6 = new Vertex<>(6);
        protected final Vertex<Integer> v7 = new Vertex<>(7);
        protected final Vertex<Integer> v8 = new Vertex<>(8);
        
        {verticies.add(v1);
        verticies.add(v2);
        verticies.add(v3);
        verticies.add(v4);
        verticies.add(v5);
        verticies.add(v6);
        verticies.add(v7);
        verticies.add(v8);}
        
        protected final List<Edge<Integer>> edges = new ArrayList<>();
        protected final Edge<Integer> e1_2 = new Edge<>(7, v1, v2);
        protected final Edge<Integer> e1_3 = new Edge<>(9, v1, v3);
        protected final Edge<Integer> e1_6 = new Edge<>(14, v1, v6);
        protected final Edge<Integer> e2_3 = new Edge<>(10, v2, v3);
        protected final Edge<Integer> e2_4 = new Edge<>(15, v2, v4);
        protected final Edge<Integer> e3_4 = new Edge<>(11, v3, v4);
        protected final Edge<Integer> e3_6 = new Edge<>(2, v3, v6);
        protected final Edge<Integer> e6_5 = new Edge<>(9, v6, v5);
        protected final Edge<Integer> e6_8 = new Edge<>(14, v6, v8);
        protected final Edge<Integer> e4_5 = new Edge<>(6, v4, v5);
        protected final Edge<Integer> e4_7 = new Edge<>(16, v4, v7);
        protected final Edge<Integer> e1_8 = new Edge<>(30, v1, v8);
        
        {edges.add(e1_2);
        edges.add(e1_3);
        edges.add(e1_6);
        edges.add(e2_3);
        edges.add(e2_4);
        edges.add(e3_4);
        edges.add(e3_6);
        edges.add(e6_5);
        edges.add(e6_8);
        edges.add(e4_5);
        edges.add(e4_7);
        edges.add(e1_8);}
        
        protected final Graph<Integer> graph = new Graph<>(Graph.TYPE.DIRECTED, verticies, edges);                
        
    }
    protected static class DirectedWithNegativeWeights{//3.Grafos dirigidos con pesos negativos
        protected final List<Vertex<Integer>> verticies = new ArrayList<>();
        protected final Vertex<Integer> v1 = new Vertex<>(1);
        protected final Vertex<Integer> v2 = new Vertex<>(2);
        protected final Vertex<Integer> v3 = new Vertex<>(3);
        protected final Vertex<Integer> v4 = new Vertex<>(4);
        
        {verticies.add(v1);
        verticies.add(v2);
        verticies.add(v3);
        verticies.add(v4);}
        
        protected final List<Edge<Integer>> edges = new ArrayList<>();
        protected final Edge<Integer> e1_4 = new Edge<>(2, v1, v4);  // w->z
        protected final Edge<Integer> e2_1 = new Edge<>(6, v2, v1);  // x->w
        protected final Edge<Integer> e2_3 = new Edge<>(3, v2, v3);  // x->y
        protected final Edge<Integer> e3_1 = new Edge<>(4, v3, v1);  // y->w
        protected final Edge<Integer> e3_4 = new Edge<>(5, v3, v4);  // y->z
        protected final Edge<Integer> e4_2 = new Edge<>(-7, v4, v2); // z->x
        protected final Edge<Integer> e4_3 = new Edge<>(-3, v4, v3); // z->y
        
        {edges.add(e1_4);
        edges.add(e2_1);
        edges.add(e2_3);
        edges.add(e3_1);
        edges.add(e3_4);
        edges.add(e4_2);
        edges.add(e4_3);}
        
        protected final Graph<Integer> graph = new Graph<>(Graph.TYPE.DIRECTED, verticies, edges);
    }    
    
  public static Graph<Integer> topologicalSortOnDirectedGraph() {
    // DIRECTED GRAPH
    final List<Vertex<Integer>> verticies = new ArrayList<>();
    final Vertex<Integer> cv1 = new Vertex<>(1);
    final Vertex<Integer> cv2 = new Vertex<>(2);
    final Vertex<Integer> cv3 = new Vertex<>(3);
    final Vertex<Integer> cv4 = new Vertex<>(4);
    final Vertex<Integer> cv5 = new Vertex<>(5);
    final Vertex<Integer> cv6 = new Vertex<>(6);
    
    verticies.add(cv1);    
    verticies.add(cv2);    
    verticies.add(cv3);
    verticies.add(cv4);    
    verticies.add(cv5);    
    verticies.add(cv6);

    final List<Edge<Integer>> edges = new ArrayList<>();
    final Edge<Integer> ce1_2 = new Edge<>(1, cv1, cv2);
    final Edge<Integer> ce2_4 = new Edge<>(2, cv2, cv4);
    final Edge<Integer> ce4_3 = new Edge<>(3, cv4, cv3);
    final Edge<Integer> ce3_6 = new Edge<>(4, cv3, cv6);
    final Edge<Integer> ce5_6 = new Edge<>(5, cv5, cv6);
    final Edge<Integer> ce4_5 = new Edge<>(6, cv4, cv5);
    
    edges.add(ce1_2);    
    edges.add(ce2_4);
    edges.add(ce4_3);    
    edges.add(ce3_6);    
    edges.add(ce5_6);
    edges.add(ce4_5);

    final Graph<Integer> digraph = new Graph<>(Graph.TYPE.DIRECTED, verticies, edges);
    return digraph;
    }    

    public static String primUndirected() {
        final UndirectedGraph undirected = new UndirectedGraph();
        Vertex<Integer> start = undirected.v1;        
        final CostPathPair<Integer> resultMST = Prim.getMinimumSpanningTree(undirected.graph, start);

        // Ideal MST
        int cost = 35;
        List<Edge<Integer>> list = new ArrayList<>();
        list.add(undirected.e1_7);
        list.add(undirected.e1_8);
        list.add(undirected.e1_2);
        list.add(undirected.e1_3);
        list.add(undirected.e3_6);
        list.add(new Edge<>(9, undirected.v6, undirected.v5));
        list.add(new Edge<>(6, undirected.v5, undirected.v4));
        CostPathPair<Integer> idealMST = new CostPathPair<>(cost, list);
        System.out.println("Prim's minimum spanning tree error. resultMST="+resultMST+" idealMST="+idealMST);

        // Prim on a graph with cycles
        final List<Vertex<Integer>> cyclicVerticies = new ArrayList<>();
        final Vertex<Integer> cv1 = new Vertex<>(1);
        final Vertex<Integer> cv2 = new Vertex<>(2);
        final Vertex<Integer> cv3 = new Vertex<>(3);
        final Vertex<Integer> cv4 = new Vertex<>(4);
        final Vertex<Integer> cv5 = new Vertex<>(5);

        cyclicVerticies.add(cv1);            
        cyclicVerticies.add(cv2);            
        cyclicVerticies.add(cv3);            
        cyclicVerticies.add(cv4);            
        cyclicVerticies.add(cv5);

        final List<Edge<Integer>> cyclicEdges = new ArrayList<>();
        final Edge<Integer> ce1_2 = new Edge<>(3, cv1, cv2);
        final Edge<Integer> ce2_3 = new Edge<>(2, cv2, cv3);
        final Edge<Integer> ce3_4 = new Edge<>(4, cv3, cv4);
        final Edge<Integer> ce4_1 = new Edge<>(1, cv4, cv1);
        final Edge<Integer> ce4_5 = new Edge<>(1, cv4, cv5);

        cyclicEdges.add(ce1_2);            
        cyclicEdges.add(ce2_3);            
        cyclicEdges.add(ce3_4);            
        cyclicEdges.add(ce4_1);            
        cyclicEdges.add(ce4_5);

        final Graph<Integer> cyclicUndirected = new Graph<>(Graph.TYPE.UNDIRECTED, cyclicVerticies, cyclicEdges);
        start = cv1;
        CostPathPair<Integer> pair4 = Prim.getMinimumSpanningTree(cyclicUndirected, cyclicUndirected.getVertices().get(0));            
        // Ideal MST
        cost = 7;
        List<Edge<Integer>> list4 = new ArrayList<>();
        list4.add(new Edge<>(1, cv1, cv4));
        list4.add(ce4_5);
        list4.add(ce1_2);
        list4.add(ce2_3);
        CostPathPair<Integer> result4 = new CostPathPair<>(cost, list4);

        StringBuilder str=new StringBuilder();
        str.append(pair4);
        str.append(list4);
        return str.toString();
    }
}
