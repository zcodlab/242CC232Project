package uni.aed.trees.matricula2.solucion;

public class AvlTreeNode {
  protected Curso curso;    
  protected int height;
  protected AvlTreeNode left;
  protected AvlTreeNode right;

  public AvlTreeNode(Curso curso) {
    this.curso = curso;
    this.height = 1;
    this.left = null;
    this.right = null;
  }

  @Override
  public String toString() {
    return curso.toString();
  }
}
