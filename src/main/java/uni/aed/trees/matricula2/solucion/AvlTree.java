package uni.aed.trees.matricula2.solucion;

import java.util.List;

public class AvlTree {
  private AvlTreeNode root;

  public AvlTreeNode getRoot() {
    return root;
  }

  public void addCourse(Curso curso) {
    root = addCourseRec(root, curso);
  }
  
  public AvlTreeNode findCourse(AvlTreeNode node, String codigoCurso) {
    if (node == null)
      return null;        
    
    if (node.curso.getCodigo().equals(codigoCurso))
      return node;
    
    return codigoCurso.compareTo(node.curso.getCodigo()) < 0
            ? findCourse(node.left, codigoCurso)
            : findCourse(node.right, codigoCurso);
  }

  private AvlTreeNode addCourseRec(AvlTreeNode node, Curso curso) {
    if (node == null)
      return new AvlTreeNode(curso);
    
    if (curso.getCodigo().compareTo(node.curso.getCodigo()) < 0)
      node.left = addCourseRec(node.left, curso);
    else if (curso.getCodigo().compareTo(node.curso.getCodigo()) > 0)
      node.right = addCourseRec(node.right, curso);
    else {
      System.out.println("El curso ya existe.");
      return node;
    }
    return balanceTree(node);
  }

  public boolean enrollStudent(String codigoCurso, Alumno alumno) {
    AvlTreeNode courseNode = findCourse(root, codigoCurso);
    if (courseNode == null) {
      System.out.println("Curso no encontrado.");
      return false;
    }
    if (courseNode.curso.getNumMatriculados() >= courseNode.curso.getMaxMatriculados()) {
      System.out.println("El curso ya alcanzó el límite de matriculados.");
      return false;
    }
    courseNode.curso.getAlumnosMatriculados().add(alumno);
    courseNode.curso.setNumMatriculados(courseNode.curso.getNumMatriculados() + 1);
    courseNode.curso.setMaxMatriculados(courseNode.curso.getMaxMatriculados() - 1);
    return true;
  }

  public boolean cancelEnrollment(String codigoCurso, String codigoAlumno) {
    // Paso 1: Encontrar el curso
    AvlTreeNode courseNode = findCourse(root, codigoCurso);
    if (courseNode == null) {
      System.out.println("Curso no encontrado: " + codigoCurso);
      return false;
    }
    System.out.println("Curso encontrado: " + codigoCurso);

    boolean removed = courseNode.curso.getAlumnosMatriculados().removeIf(alumno -> {
      System.out.println("Comparando alumno: " + alumno.getCodigo() + " con " + codigoAlumno);
      return alumno.getCodigo().equals(codigoAlumno);
    });

    if (removed) {
      System.out.println("Alumno eliminado: " + codigoAlumno);
      courseNode.curso.setNumMatriculados(courseNode.curso.getNumMatriculados() - 1);
      courseNode.curso.setMaxMatriculados(courseNode.curso.getMaxMatriculados() + 1);

      if (courseNode.curso.getNumMatriculados() == 0) {
        root = deleteCourseRec(root, courseNode.curso);
        System.out.println("El curso " + codigoCurso + " fue eliminado al quedar vacío.");
      }
      return true;
    } else {
      System.out.println("Alumno no encontrado: " + codigoAlumno);
      return false;
    }
  }


  public void displayReport() {
    if (root == null) {
      System.out.println("El árbol está vacío.");
      return;
    }
    System.out.println("Reporte de Matrícula (Formato de Árbol):");
    printTree(root, "", true);
  }

  private void printTree(AvlTreeNode node, String prefix, boolean isTail) {
    if (node != null) {
      System.out.println(prefix + (isTail ? "+++ " : "--- ") +
              node.curso.getNombre() + " (Código: " + node.curso.getCodigo() + "), Matriculados: "
              + node.curso.getNumMatriculados() + "/" + node.curso.getMaxMatriculados());

      if (!node.curso.getAlumnosMatriculados().isEmpty()) {
        System.out.println(prefix + (isTail ? "    " : "|   ") + "Alumnos Matriculados:");
        for (Alumno alumno : node.curso.getAlumnosMatriculados()) {
          System.out.println(prefix + (isTail ? "    " : "|   ") + "  " +
                  alumno.getCodigo() + " - " + alumno.getNombres() + " " + alumno.getApellidos());
        }
      }

      if (node.left != null || node.right != null) {
        printTree(node.left, prefix + (isTail ? "    " : "|   "), node.right == null);
        printTree(node.right, prefix + (isTail ? "    " : "|   "), true);
      }
    }
  }

  private AvlTreeNode balanceTree(AvlTreeNode node) {
    updateHeight(node);
    int balance = getBalance(node);

    if (balance > 1) {
      if (getBalance(node.right) < 0) {
        node.right = rotateRight(node.right);
      }
      return rotateLeft(node);
    }
    if (balance < -1) {
      if (getBalance(node.left) > 0) {
        node.left = rotateLeft(node.left);
      }
      return rotateRight(node);
    }
    return node;
  }

  public void populateCoursesFile(AvlTreeNode node, List<String> lines) {
    if (node != null) {
      populateCoursesFile(node.left, lines);
      lines.add(node.curso.getCodigo() + "\t" + node.curso.getNombre()+ "\t" + node.curso.getNumMatriculados()+ "\t" + node.curso.getMaxMatriculados());
      populateCoursesFile(node.right, lines);
    }
  }

  public void populateEnrollmentsFile(AvlTreeNode node, List<String> lines) {
    if (node != null) {
      populateEnrollmentsFile(node.left, lines);
      for (Alumno alumno : node.curso.getAlumnosMatriculados())
        lines.add(node.curso.getCodigo() + "\t" + alumno.getCodigo() + "\t" + alumno.getNombres() + "\t" + alumno.getApellidos());      
      populateEnrollmentsFile(node.right, lines);
    }
  }

  private AvlTreeNode deleteCourseRec(AvlTreeNode node, Curso curso) {
    if (node == null)
      return null;    
    if (curso.getCodigo().compareTo(node.curso.getCodigo()) < 0)
      node.left = deleteCourseRec(node.left, curso);
    else if (curso.getCodigo().compareTo(node.curso.getCodigo()) > 0)
      node.right = deleteCourseRec(node.right, curso);
    else {
      if (node.left == null)
        return node.right;
      else if (node.right == null) {
        return node.left;
    }
      AvlTreeNode temp = findMin(node.right);
      node.curso.setCodigo(temp.curso.getCodigo());
      node.curso.setNombre(temp.curso.getNombre());
      node.curso.setAlumnosMatriculados(temp.curso.getAlumnosMatriculados());      
      node.curso.setNumMatriculados(temp.curso.getNumMatriculados());      
      node.curso.setMaxMatriculados(temp.curso.getMaxMatriculados());      
      node.right = deleteCourseRec(node.right, temp.curso);
    }
    return balanceTree(node);
  }

  private AvlTreeNode findMin(AvlTreeNode node) {
    while (node.left != null) {
      node = node.left;
    }
    return node;
  }

  private void updateHeight(AvlTreeNode node) {
    node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
  }

  private int getHeight(AvlTreeNode node) {
    return (node == null) ? 0 : node.height;
  }

  private int getBalance(AvlTreeNode node) {
    return (node == null) ? 0 : getHeight(node.right) - getHeight(node.left);
  }

  private AvlTreeNode rotateLeft(AvlTreeNode x) {
    AvlTreeNode y = x.right;
    AvlTreeNode z = y.left;
    y.left = x;
    x.right = z;
    updateHeight(x);
    updateHeight(y);
    return y;
  }

  private AvlTreeNode rotateRight(AvlTreeNode y) {
    AvlTreeNode x = y.left;
    AvlTreeNode z = x.right;
    x.right = y;
    y.left = z;
    updateHeight(y);
    updateHeight(x);
    return x;
  }
}
