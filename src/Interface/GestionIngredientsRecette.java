/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Controleurs.Creation;
import Controleurs.Destruction;
import Controleurs.Lecture;
import Controleurs.Modification;
import client.lourd.nesti.Categories;
import client.lourd.nesti.Ingredients;
import client.lourd.nesti.Themes;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Elrick
 */
public class GestionIngredientsRecette extends javax.swing.JFrame {
    static String nomRecettePassée;
    static Object themeActuel;
    /**
     * Creates new form gestionIngredientsRecette
     */
    public GestionIngredientsRecette() {
        initComponents();
        initTableIngredientsGlobaux();
        initTableIngredientsRecette();
        initComboCategories();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tableIngredients = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableIngredients1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ComboCategorie = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableIngredients.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numéro", "Nom"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableIngredients);

        tableIngredients1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numéro", "Nom", "Quantité", "Unité (g, cl ou ml)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tableIngredients1);

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("Ingredients de la recette");
        jTextField1.setFocusable(false);

        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("Tous les ingredients");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton1.setText("---->");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton3.setText("Retour");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton4.setText("Valider");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton5.setText("Supprimer");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton6.setText("Vider la table");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel1.setText("Modifiez vos valeurs");

        jLabel2.setText("Dans les champs du tableau");

        ComboCategorie.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Categorie" }));
        ComboCategorie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboCategorieActionPerformed(evt);
            }
        });

        jLabel3.setText("Tri des ingredients :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(281, 281, 281)
                .addComponent(jTextField1)
                .addGap(53, 53, 53))
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(329, 329, 329)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(ComboCategorie, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)))
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane3)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(231, 231, 231)
                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(27, 27, 27)
                        .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(31, 31, 31))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ComboCategorie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (tableIngredients.getSelectedRow() != -1) {

            DefaultTableModel model = (DefaultTableModel) tableIngredients1.getModel();
            int idRec = Lecture.getUneRecette(nomRecettePassée).getID();
            int idIng = Integer.parseInt(tableIngredients.getValueAt(tableIngredients.getSelectedRow(), 0).toString());
                Creation.ajoutIngredientRecette(idIng, idRec);
                Object[] row = new Object[3];
                row[0] = tableIngredients.getValueAt(tableIngredients.getSelectedRow(), 0);
                row[1] = tableIngredients.getValueAt(tableIngredients.getSelectedRow(), 1);
                row[2] = 0;
                model.addRow(row);

            }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (tableIngredients1.getSelectedRow() != -1) {

            DefaultTableModel model = (DefaultTableModel) tableIngredients1.getModel();
            int idIng = Integer.parseInt(tableIngredients1.getValueAt(tableIngredients1.getSelectedRow(), 0).toString());
            int idRec = Lecture.getUneRecette(nomRecettePassée).getID();
            Destruction.deleteIngredientRecette(idIng, idRec);
            model.removeRow(tableIngredients1.getSelectedRow());}
            
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        int nombreDeRow = tableIngredients1.getRowCount();
        
        for(int i = nombreDeRow-1; i >=0; i--){
            DefaultTableModel model = (DefaultTableModel) tableIngredients1.getModel();
            int idIng = Integer.parseInt(tableIngredients1.getValueAt(i, 0).toString());
            int idRec = Lecture.getUneRecette(nomRecettePassée).getID();
            Destruction.deleteIngredientRecette(idIng, idRec);
            model.removeRow(i);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
      
        String unite;
        
        for( int i = tableIngredients1.getRowCount() -1; i >= 0; i--){
            int idIng = Integer.parseInt(tableIngredients1.getValueAt(i, 0).toString());
            int idRec = Lecture.getUneRecette(nomRecettePassée).getID();
            int quantite = Integer.parseInt(tableIngredients1.getValueAt(i, 2).toString());
            
            if(tableIngredients1.getValueAt(i, 3) != null){
                unite = tableIngredients1.getValueAt(i, 3).toString();
            }
            else{
                unite = "";
            }
            Modification.modificationIngredientsRecette(idIng, idRec, quantite, unite);   
        }
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Destruction.deleteRecette(nomRecettePassée);
        this.dispose();        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void ComboCategorieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboCategorieActionPerformed
        if (ComboCategorie.getSelectedIndex() != 0) {
            ArrayList<Ingredients> lesIngredients = Lecture.getLesIngredientsSelonCategorie(ComboCategorie.getSelectedItem().toString());
            DefaultTableModel model = (DefaultTableModel) tableIngredients.getModel();

            
            if (lesIngredients != null) {
                Object[] row = new Object[2];
                
                if (model.getRowCount() != 0) {
                    model.setRowCount(0);
                }
                for (int i = 0; i <= lesIngredients.size() - 1; i++) {
                    Ingredients unIngredient = lesIngredients.get(i);
                    row[0] = unIngredient.getId();
                    row[1] = unIngredient.getNom();
                    model.addRow(row);
                }
            } else {
                if (model.getRowCount() != 0) {
                    model.setRowCount(0);}
            }

        }else{
            initTableIngredientsGlobaux();
        }
    }//GEN-LAST:event_ComboCategorieActionPerformed
    private void initTableIngredientsGlobaux(){
        ArrayList<Ingredients> lesIngredients = Lecture.getLesIngredients();
        DefaultTableModel model = (DefaultTableModel) tableIngredients.getModel();
        if(lesIngredients != null){
        Object[] row = new Object[2];

        if(model.getRowCount()!= 0){
            model.setRowCount(0);
        }
            for (int i = 0; i <= lesIngredients.size() - 1; i++){
            Ingredients unIngredient = lesIngredients.get(i);
            row[0] = unIngredient.getId();
            row[1] = unIngredient.getNom();

            model.addRow(row);
        } 
        }
    }
    private void initTableIngredientsRecette(){
        ArrayList<Ingredients> lesIngredients = Lecture.getLesIngredientsDeUneRecette(nomRecettePassée);
        DefaultTableModel model = (DefaultTableModel) tableIngredients1.getModel();
        if(lesIngredients != null){
        Object[] row = new Object[4];

        if(model.getRowCount()!= 0){
            model.setRowCount(0);
        }
            for (int i = 0; i <= lesIngredients.size() - 1; i++){
            Ingredients unIngredient = lesIngredients.get(i);
            row[0] = unIngredient.getId();
            row[1] = unIngredient.getNom();
            row[2] = unIngredient.getQuantite();
            row[3] = unIngredient.getUnite();
            model.addRow(row);
        } 
        }
    }
    private void initComboCategories(){
        ArrayList<Categories> lesCat = Lecture.getLesCategories();
        for (int i = 0; i <= lesCat.size() - 1; i++) {
            Categories categorie = lesCat.get(i);
            ComboCategorie.addItem(categorie.getNomCategorie());
        }
    }

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
            java.util.logging.Logger.getLogger(GestionIngredientsRecette.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionIngredientsRecette.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionIngredientsRecette.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionIngredientsRecette.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionIngredientsRecette().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboCategorie;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTable tableIngredients;
    private javax.swing.JTable tableIngredients1;
    // End of variables declaration//GEN-END:variables
}
