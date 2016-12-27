package projectisro;

import java.util.logging.Level;
import java.util.logging.Logger;
//import testtable.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.EventObject;
import javax.naming.Context;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author admin
 */
public class input extends javax.swing.JFrame {
    //TableColumnModel columns;

    /** Creates new form input */
    Context c;
    JFileChooser fc;
    ArrayList<String> a;
    int x1 = 32, y1 = 128;
    boolean check = true;
    int maxsr;
    float minsr;
    int maxc,maxf;
    int minc,minf;
    BufferedReader rd;
    String valtoalloc1=null;
    //  String result,res;
   // int x1=projectConfig.nf;
    //int y1=projectConfig.nc;
    //JTable jTable1;
    File f;
    int tv1,tv2;
    ArrayList al = new ArrayList();
    TableCellRenderer r;

    public input() {
       
        initComponents();
        jTable1.setColumnSelectionAllowed(true);
       // JComboBox myBox = new JComboBox(dataVector);
        DefaultComboBoxModel theModel = (DefaultComboBoxModel)jComboBox1.getModel();
        theModel.removeAllElements();
       
        jComboBox1.addActionListener(new ActionListener() {
       
            @Override
            public void actionPerformed(ActionEvent e) {
            String s=  (String) jComboBox1.getSelectedItem();
            System.out.println("Sampling Rate = "+s);
            String fr1=  Float.toString(projectConfig.fr);
            float fv= Float.parseFloat(s);// sampling rate
            float fv1= Float.parseFloat(fr1);// frame rate
            //Float.toString(minsr)
             System.out.println("Frame Rate = "+fr1);
               if(s.equals(fr1))
                {
                   System.out.println("equal");
                   maxf=0;
                   minf=0;
                   maxc= projectConfig.nc-1;
                   minc=0;
                   jSpinner1.setModel(new SpinnerNumberModel(minc, 0, maxc, 1));
                   jSpinner2.setModel(new SpinnerNumberModel(minf, 0, maxf, 1));
               }   
               if(fv<fv1)
               {
               float g= fv1/fv; 
                    maxf=0;
                    minf=0;
                    maxc= (int) (projectConfig.nc/g)-1;
                    minc=0;
                    jSpinner1.setModel(new SpinnerNumberModel(minc, 0, maxc, 1));
                    jSpinner2.setModel(new SpinnerNumberModel(minf, 0, maxf, 1));
               }
               if(fv>fv1)
               {
                    maxc=  projectConfig.nc-1;
                    minc=0;
                    float g= fv/fv1;
                    System.out.println("g="+g);
                    minf=0;
                    maxf= (int)(g-1);
                    System.out.println("maxf="+maxf);
                    jSpinner1.setModel(new SpinnerNumberModel(minc, 0, maxc, 1));
                    jSpinner2.setModel(new SpinnerNumberModel(minf, 0, maxf, 1));
                    

               }
            }
        });
           
        maxsr = projectConfig.nf;
        minsr = (projectConfig.fr / (projectConfig.nc));
        jComboBox1.addItem(Float.toString(minsr));
        while (minsr <= maxsr) {
            minsr = minsr * 2;
            if (minsr >= 1) {
                int g = (int) minsr;
                jComboBox1.addItem(Integer.toString(g));
            } else {
                jComboBox1.addItem(Float.toString(minsr));
            }
        }

        //jComboBox1.addItem(Integer.toString(maxsr));
        f = new File("text.txt");
        if (f.exists()) {
            System.out.println("File exists");
        }
        if (!f.exists()) {
            try {
                f.createNewFile();
                //  output = new BufferedWriter(new FileWriter(f));
                //  output.append(result);
                // output.close();
            } catch (IOException ex) {
                Logger.getLogger(input.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
       // jSpinner1.setModel(new SpinnerNumberModel(1, 0, 100, 1));
        this.setTitle(projectConfig.pn);
        this.setResizable(false);
        jRadioButton1.setSelected(true);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();//
        this.setBounds(0, 0, (int) d.getWidth(), (int) d.getHeight() - 40);
        a = new ArrayList<String>();
        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
           
        ButtonGroup bg = new ButtonGroup();
        bg.add(jRadioButton1);
        bg.add(jRadioButton2);
        jButton1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                tv1= Integer.parseInt(jTextField1.getText());
                tv2= Integer.parseInt(jTextField2.getText());
                //String word = Integer.toHexString(Integer.parseInt(jTextField1.getText()));
                //String pkg = Integer.toHexString(Integer.parseInt(jTextField2.getText()));
                String word = jTextField1.getText();
                String pkg = jTextField2.getText();
                Object spnv = jSpinner1.getValue();
                Object cbv = jComboBox1.getSelectedItem();
                Object spnv2 = jSpinner2.getValue();
                BufferedWriter output;

                try {
                    int word1 = Integer.parseInt(word);
                    int pkg1 = Integer.parseInt(pkg);
                    String sp = " ", result = null;
                    result = spnv + " " + " " + cbv + " " + spnv2 + " " + word + " " + pkg;
                    //result= result + result;
                    // result= result + "\n";
                    //////////////////////////////////////////////////////////////////////////////////////
                    String byofword = Integer.toBinaryString(word1);

                    String byofpkg = Integer.toBinaryString(pkg1);
                    String datarate = projectConfig.dr;
                   if("INSAT".equals(datarate))
                    {   
                         
                    //String valtoalloc1=null;
                      if(tv1 <= 2047 && tv2 <= 31)
                      {
                        if(byofpkg.length()!=5)
                        {
                        for(int q=0;q<5;q++)
                            {
                            byofpkg="0"+byofpkg;
                            if(byofpkg.length()==5)
                                break;                                         
                            }
                        }
                    if(byofword.length()!=11)
                    {
                        for(int q=0;q<11;q++)
                        {
                            byofword="0"+byofword;
                            if(byofword.length()==11)
                                break;                                         
                        }
                    }
                    if(byofpkg.length()==5&&byofword.length()==11)
                    {
                        String toAllocword=byofpkg+byofword;
                     //   long num = Long.parseLong(toAllocword);
                        int valtoalloc= Integer.parseInt(toAllocword,2);
                        valtoalloc1 = Integer.toHexString(valtoalloc);
                    }
                      if(byofpkg.length()<5&&byofword.length()>11)
		    {
			for(int q=0;q<5;q++)
                        {
                            byofpkg="0"+byofpkg;
                            if(byofpkg.length()==11)
                                break;                                         
                        }
			String toAllocword=byofpkg+byofword;
			int valtoalloc= Integer.parseInt(toAllocword,2);
                        valtoalloc1 = Integer.toHexString(valtoalloc); 

		    }


		    if(byofpkg.length()>5&&byofword.length()>11)
		    {
			
			String toAllocword=byofpkg+byofword;
			int valtoalloc= Integer.parseInt(toAllocword,2);
                        valtoalloc1 = Integer.toHexString(valtoalloc); 
	            }
                    System.out.println("INSAT:"+valtoalloc1);
                      }
                      else
                      {
                          jTextField1.setText(null);
                          jTextField2.setText(null);
                          JOptionPane.showMessageDialog(rootPane, "The value of word and package id exceeds the maximum value");
                      }
                }     
                
                
                /*valtoalloc1 is the value to be allocated if its INSAT
                 * 
                 * 
                 * */
                //////////////////////////////////////////
                // irs
                //////////////////////////////////////////
                
                
if("IRS".equals(datarate))
                {
                 if(tv1 <= 511 && tv2 <= 127)
                 {
                    if(byofpkg.length()<7)
                    {
                        for(int q=0;q<7;q++)
                        {
                            byofpkg="0"+byofpkg;
                            if(byofpkg.length()==7)
                                break;                                         
                        }
                    }
                    if(byofword.length()<9)
                    {
                        for(int q=0;q<11;q++)
                        {
                            byofword="0"+byofword;
                            if(byofword.length()==9)
                                break;                                         
                        }
                    }
                    if(byofpkg.length()==7&&byofword.length()==9)
                    {
                        String toAllocword=byofpkg+byofword;
                     //   long num = Long.parseLong(toAllocword);
                        int valtoalloc= Integer.parseInt(toAllocword,2);
                        valtoalloc1 = Integer.toHexString(valtoalloc);
                    }
		    if(byofpkg.length()>7&&byofword.length()<9)
		    {
			for(int q=0;q<9;q++)
                        {
                            byofword="0"+byofword;
                            if(byofword.length()==9)
                                break;                                         
                        }
			String toAllocword=byofpkg+byofword;
			int valtoalloc= Integer.parseInt(toAllocword,2);
                        valtoalloc1 = Integer.toHexString(valtoalloc); 

		    }

		    if(byofpkg.length()<7&&byofword.length()>9)
		    {
			for(int q=0;q<7;q++)
                        {
                            byofpkg="0"+byofpkg;
                            if(byofpkg.length()==7)
                                break;                                         
                        }
			String toAllocword=byofpkg+byofword;
			int valtoalloc= Integer.parseInt(toAllocword,2);
                        valtoalloc1 = Integer.toHexString(valtoalloc); 

		    }
		    if(byofpkg.length()>7&&byofword.length()>9)
		    {
			String toAllocword=byofpkg+byofword;
			int valtoalloc= Integer.parseInt(toAllocword,2);
                        valtoalloc1 = Integer.toHexString(valtoalloc); 
                        
	            }
		    System.out.println("IRS:"+valtoalloc1);
                
                    while(valtoalloc1.length()<4)
                    {
                        valtoalloc1= "0"+valtoalloc1;
                        
                    }
                    System.out.println("valtoalloc1 after appending"+valtoalloc1);
                    ////////////////////////////////////////////////////////////////////////////////////
                    output = new BufferedWriter(new FileWriter(f, true));
                    output.write(result);
                    output.newLine();
                    output.flush();
                    output.close();
                 }
                  else
                {
                    JOptionPane.showMessageDialog(rootPane, "The value of word and package id exceeds the maximum value" );
                }
                }
               
                } catch (IOException ex) {
                    Logger.getLogger(input.class.getName()).log(Level.SEVERE, null, ex);
                }

                for (int j = 0; j < x1; j++) {
                    for (int k = 1; k < y1; k++) {
                        jTable1.setValueAt("1111", j, k);
                    }
                }
        //                jTable1.setValueAt("hello0000000000000", 4, 4);
            }
        });
        jButton2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            
                for (int j = 0; j < x1; j++) {
                    for (int k = 1; k < y1; k++) {
                        jTable1.setValueAt("0000", j, k);
                    }
                }
            }
        });
        jButton3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new PresentConfiguration().setVisible(true);
            }
        });
        // jTable1.setModel(new javax.swing.table.DefaultTableModel(20, 20));
         for (int i =0 ; i < y1; i++) {
             {
                 
             
        jTable1.setCellEditor(new TableCellEditor() {

            @Override
            public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
                // throw new UnsupportedOperationException("Not supported yet.");
      
                return table;
            }

            @Override
            public Object getCellEditorValue() {
                return 0;
            }

            @Override
            public boolean isCellEditable(EventObject anEvent) {
                return true;
            }

            @Override
            public boolean shouldSelectCell(EventObject anEvent) {
                return true;
            }

            @Override
            public boolean stopCellEditing() {
                return true;
            }

            @Override
            public void cancelCellEditing() {
                
            }

            @Override
            public void addCellEditorListener(CellEditorListener l) {
                //throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void removeCellEditorListener(CellEditorListener l) {
            }
        });

            TableColumnModel columnModel = jTable1.getColumnModel();
           // TableColumn column1 = columnModel.getColumn(0);
            //column1.setHeaderValue("");
            TableColumn column = columnModel.getColumn(i);
            column.setMinWidth(20);
         
            column.setHeaderValue("C" + i);
             }

            // column.setHeaderRenderer(new HeaderRenderer());
        }
        JTableHeader anHeader = jTable1.getTableHeader();
        anHeader.setForeground(Color.RED);
        anHeader.setBackground(Color.BLUE);
       /* for (int i = 0; i < x1; i++) {
            jTable1.setValueAt("R" + (i), i, 0);

        }*/
        for (int j = 0; j < x1; j++) {
            for (int k = 0; k < y1; k++) {
                jTable1.setValueAt("0000", j, k);
            }
        }
        //jTable1.setDefaultRenderer(Object.class, new MyTableCellRender()); 
        jRadioButton2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                if (fc == null) {
                    fc = new JFileChooser("C://");
                }
                int result = fc.showDialog(jRadioButton2, null);
                if (result == JFileChooser.APPROVE_OPTION) {

                    try {
                        //URL path = fc.getSelectedFile().toURI().toURL();
                        File inFile = fc.getSelectedFile();
                        BufferedReader bf = new BufferedReader(new FileReader(inFile));
                        System.out.println("HELLOOOOOOOOOOOOOOOOOOOOOOOO");
                        String s = " ";
                        String words[] = null;
                        while ((s = bf.readLine()) != null) {
                            words = s.split(" ");
                            for (int i = 0; i < words.length; i++) {
                                a.add(words[i]);
                            }
                            System.out.println("String=" + s);

                        }
                        

                        /*for (int i = 0; i < a.size(); i++) 
                        { 
                        System.out.println("words=" + a.get(i));
                        jSpinner1.setValue(Integer.parseInt(a.get(i)));
                        jComboBox1.addItem(23);
                        jComboBox1.setSelectedItem(10);
                        
                        for(int j=0;j<a.size();j=j+5)
                        {
                        jSpinner1.setValue(Integer.parseInt(a.get(j)));
                        
                        }
                        }*/
                    } catch (IOException ex) {
                    }


                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jSpinner2 = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable(x1,y1){
            public Component prepareRenderer(
                TableCellRenderer renderer, int row, int column)
            {

                Component c = super.prepareRenderer(renderer, row, column);
                if(column== -1)
                setBackground(Color.red);
                else
                setBackground(Color.GREEN);
                return c;
            }
        };
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Channel No");

        jLabel2.setText("Sampling Rate");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select.."}));

        jLabel3.setText("Starting Frame No");

        jLabel4.setText("Word No");

        jLabel5.setText("Pkg Id");

        jRadioButton1.setText("Manual");

        jRadioButton2.setText("File");

        jButton1.setText("Ok");

        jButton2.setText("Restart");

        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        JTable rowTable = new RowNumberTable(jTable1);
        jScrollPane1.setRowHeaderView(rowTable);
        jScrollPane1.setCorner(JScrollPane.UPPER_LEFT_CORNER,
            rowTable.getTableHeader());

        jButton3.setText("Present Config");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton2)
                        .addGap(46, 46, 46)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(61, 61, 61)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(311, 311, 311))
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1175, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(121, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(input.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(input.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(input.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(input.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new input().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
