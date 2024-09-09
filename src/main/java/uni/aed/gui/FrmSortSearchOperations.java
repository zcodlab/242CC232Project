/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uni.aed.gui;

import java.util.Arrays;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import uni.aed.search.Search;
import uni.aed.sort.Sort;

/**
 *
 * @author zemr
 */
public class FrmSortSearchOperations extends javax.swing.JFrame {
    private final DefaultListModel dlmInicial=new DefaultListModel();
    private final DefaultListModel dlmFinal=new DefaultListModel();
    private final String CADENA_VACIA="";
    private final int NO_ENCONTRADO=-1;
    private int result=NO_ENCONTRADO;
    
    /**
     * Creates new form FrmSortSearchOperations
     */
    public FrmSortSearchOperations() {
        initComponents();
        jlInicial.setModel(dlmInicial);
        jlFinal.setModel(dlmFinal);
    }
    
    private void Insertar(){
        String data=jtfData.getText();
        if(!dlmInicial.contains(data))
            dlmInicial.addElement(data);
        jtfData.setText(CADENA_VACIA);
    }
    private void searchLineal(){
        //validar si el componente jlist tiene data
        int N=dlmInicial.size();
        if(N<1)
        { JOptionPane.showMessageDialog(this, "La lista se encuentra vacia",
                "ERROR", JOptionPane.ERROR);            
          return;
        }
        //validar que se haya consignado el elemento a buscar
        if(jtfData.getText().isEmpty())
        { JOptionPane.showMessageDialog(this, "Debe consignar el valor que desea buscar",
                "ERROR", JOptionPane.ERROR);            
          return;
        }
        Integer[] X=Arrays.stream(dlmInicial.toArray())
                .map(obj->Integer.valueOf(obj.toString())).toArray(Integer[]::new);
        Search search=new Search();
        result=search.searchLineal(X, Integer.parseInt(jtfData.getText()));
        jtfComplejidad.setText(search.SEARCH_LINEAL_COMPLEJIDAD_WORSTCASE);
        jtfComparaciones.setText(Integer.toString(search.getnComp()));
        if(result==search.NO_ENCONTRADO)
            JOptionPane.showMessageDialog(this, "El valor buscado no se encontro en la lista",
                "WARNING", JOptionPane.WARNING_MESSAGE);            
        else{
            jlInicial.setSelectedIndex(result);//Seleccion el row con el valor
            jlInicial.requestFocusInWindow();//coloca el foco en la lista
            jlInicial.requestFocus();
            JOptionPane.showMessageDialog(this, "El valor buscado se encontro en la lista en el registro " 
                    + (result + 1),"EXITO", JOptionPane.OK_OPTION);            
        }
    }
    private void searchBinaria(){
        int N=dlmFinal.size();
        if(N<1)
        { JOptionPane.showMessageDialog(this, "La lista se encuentra vacia",
                "ERROR", JOptionPane.ERROR_MESSAGE);            
          return;
        }
        //validar que se haya consignado el elemento a buscar
        if(jtfData.getText().isEmpty())
        { JOptionPane.showMessageDialog(this, "Debe consignar el valor que desea buscar",
                "ERROR", JOptionPane.ERROR_MESSAGE);            
          return;
        }
        Integer[] X=Arrays.stream(dlmFinal.toArray())
                .map(obj->Integer.valueOf(obj.toString())).toArray(Integer[]::new);
        Search search=new Search();
        result=search.searchBinaria(X, Integer.parseInt(jtfData.getText()));
        jtfComplejidad.setText(search.SEARCH_BINARY_COMPLEJIDAD_WORSTCASE);
        jtfComparaciones.setText(Integer.toString(search.getnComp()));
        if(result==search.NO_ENCONTRADO)
            JOptionPane.showMessageDialog(this, "El valor buscado no se encontro en la lista",
                "WARNING", JOptionPane.WARNING_MESSAGE);            
        else{
            jlFinal.setSelectedIndex(result);//Seleccion el row con el valor
            jlFinal.requestFocusInWindow();//coloca el foco en la lista
            jlFinal.requestFocus();
            JOptionPane.showMessageDialog(this, "El valor buscado se encontro en la lista en el registro " 
                    + (result + 1),"EXITO", JOptionPane.PLAIN_MESSAGE);            
        }
        
    }
    private void Sort(){
        int N=dlmInicial.size();
        if(N<1)
        { JOptionPane.showMessageDialog(this, "La lista se encuentra vacia",
                "ERROR", JOptionPane.ERROR);            
          return;
        }        
        Integer[] X=Arrays.stream(dlmInicial.toArray())
                .map(obj->Integer.valueOf(obj.toString())).toArray(Integer[]::new);
        Sort sort=new Sort();
        sort.setY(X);
        switch(jcbSort.getSelectedIndex()){
            case 0 ->{ X=sort.selectionWuSort();}
            case 1 ->{X=sort.bubbleWuSort();}
        }
        dlmFinal.removeAllElements();
        for(Integer x:X)
            dlmFinal.addElement(x);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jtfData = new javax.swing.JTextField();
        jbSearch = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jrbSearchLineal = new javax.swing.JRadioButton();
        jrbSearchBinaria = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlInicial = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jlFinal = new javax.swing.JList<>();
        jcbSort = new javax.swing.JComboBox<>();
        jbSort = new javax.swing.JButton();
        jtfComparaciones = new javax.swing.JTextField();
        jtfComplejidad = new javax.swing.JTextField();
        jlComparaciones = new javax.swing.JLabel();
        jlComplejidad = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Algoritmos de Busqueda y Ordenamiento");

        jPanel1.setPreferredSize(new java.awt.Dimension(540, 134));

        jtfData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfDataActionPerformed(evt);
            }
        });

        jbSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search-icon20.png"))); // NOI18N
        jbSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSearchActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search Algorithms:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 0, 102))); // NOI18N

        buttonGroup1.add(jrbSearchLineal);
        jrbSearchLineal.setSelected(true);
        jrbSearchLineal.setText("Lineal");

        buttonGroup1.add(jrbSearchBinaria);
        jrbSearchBinaria.setText("Binaria");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jrbSearchBinaria)
                    .addComponent(jrbSearchLineal))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jrbSearchLineal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jrbSearchBinaria)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jtfData, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jtfData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jlInicial.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Registrados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 0, 102))); // NOI18N
        jScrollPane1.setViewportView(jlInicial);

        jlFinal.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Ordenados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 0, 102))); // NOI18N
        jScrollPane2.setViewportView(jlFinal);

        jcbSort.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccion", "Burbuja" }));

        jbSort.setText("Sort");
        jbSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSortActionPerformed(evt);
            }
        });

        jtfComparaciones.setEditable(false);
        jtfComparaciones.setBackground(new java.awt.Color(204, 204, 204));

        jtfComplejidad.setEditable(false);
        jtfComplejidad.setBackground(new java.awt.Color(204, 204, 204));
        jtfComplejidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfComplejidadActionPerformed(evt);
            }
        });

        jlComparaciones.setText("#Comparaciones");

        jlComplejidad.setText("Complejidad Asintótica:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jcbSort, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(jbSort, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlComparaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlComplejidad, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfComparaciones)
                            .addComponent(jtfComplejidad))
                        .addGap(12, 12, 12)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jcbSort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbSort, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfComparaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlComparaciones))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlComplejidad, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfComplejidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jtfDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfDataActionPerformed
        // TODO add your handling code here:
        Insertar();
    }//GEN-LAST:event_jtfDataActionPerformed

    private void jbSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSearchActionPerformed
        // TODO add your handling code here:
        if(jrbSearchLineal.isSelected())
            searchLineal();
        if(jrbSearchBinaria.isSelected())
            searchBinaria();
    }//GEN-LAST:event_jbSearchActionPerformed

    private void jbSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSortActionPerformed
        // TODO add your handling code here:
        Sort();
    }//GEN-LAST:event_jbSortActionPerformed

    private void jtfComplejidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfComplejidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfComplejidadActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmSortSearchOperations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmSortSearchOperations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmSortSearchOperations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmSortSearchOperations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmSortSearchOperations().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbSearch;
    private javax.swing.JButton jbSort;
    private javax.swing.JComboBox<String> jcbSort;
    private javax.swing.JLabel jlComparaciones;
    private javax.swing.JLabel jlComplejidad;
    private javax.swing.JList<String> jlFinal;
    private javax.swing.JList<String> jlInicial;
    private javax.swing.JRadioButton jrbSearchBinaria;
    private javax.swing.JRadioButton jrbSearchLineal;
    private javax.swing.JTextField jtfComparaciones;
    private javax.swing.JTextField jtfComplejidad;
    private javax.swing.JTextField jtfData;
    // End of variables declaration//GEN-END:variables
}
