
package sozlukk;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class sozluk extends javax.swing.JFrame {

    String adres = "jdbc:derby://localhost:1527/sozluk";
    String kullanici = "DYILMAZ";
    String sifre = "123";
    private Connection con = null;
    private String driver = "org.apache.derby.jdbc.ClientDriver";
    private Statement st;
    private ResultSet res;

    public sozluk() {
        initComponents();
        //TabloDoldur();
        System.out.println(System.getProperty("user.dir")+"\\src\\sozlukk\\kelimelerim.xlsx");
        try {
            st = bagac();
            res = st.executeQuery("SELECT * FROM KELIME");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "hata : " + ex.toString());
        }

        //KayitGetir("ilk");
                                                        //HH:mm:ss
        SimpleDateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date(System.currentTimeMillis());
        jLabelDate.setText(formatter.format(date));
    }

    public void KayitGetir(String yon) {

        try {
            switch (yon) {

                case "ilk":

                    jLabel_RESIM_YÜKLE.setText("");
                    res.first();
                    break;
                case "son":
                    res.last();
                    break;

            }
            jTextField_TR.setText(res.getString("TURKCE"));
            jTextField_ENG.setText(res.getString("INGILIZCE"));
            jTextField_DEU.setText(res.getString("ALMANCA"));
            jLabel_RESIM_YÜKLE.setIcon(new ImageIcon(new ImageIcon(res.getBytes("RESIM")).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
            

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "kayıt bulunamadı");

        }
    }

    public Statement bagac() throws Exception {

        Class.forName(driver).newInstance();
        con = DriverManager.getConnection(adres, kullanici, sifre);
        return con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

    }

    /* public void TabloDoldur() {
        
      TabloDoldur();
    }*/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        sozlukPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("sozlukPU").createEntityManager();
        kelimeQuery = java.beans.Beans.isDesignTime() ? null : sozlukPUEntityManager.createQuery("SELECT k FROM Kelime k");
        kelimeList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : kelimeQuery.getResultList();
        kelimeQuery1 = java.beans.Beans.isDesignTime() ? null : sozlukPUEntityManager.createQuery("SELECT k FROM Kelime k");
        kelimeList1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : kelimeQuery1.getResultList();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_KELIME_IKI = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jTextField_KELIME_ARA = new javax.swing.JTextField();
        jLabel_ımage = new javax.swing.JLabel();
        jLabelDate = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton_SON = new javax.swing.JButton();
        jButton_SIL = new javax.swing.JButton();
        jButton_EKLE = new javax.swing.JButton();
        jButton_YENI = new javax.swing.JButton();
        jLabel_RESIM_YÜKLE = new javax.swing.JLabel();
        jButton_ILK = new javax.swing.JButton();
        jButton_GÜNCELLE = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField_ENG = new javax.swing.JTextField();
        jTextField_DEU = new javax.swing.JTextField();
        jTextField_TR = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_KELIME = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jTextField_duzenlenek_kelıme = new javax.swing.JTextField();
        jButton_EXCELEAKTAR = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jTable_KELIME_IKI.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jTable_KELIME_IKI.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable_KELIME_IKI.setRowHeight(100);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, kelimeList1, jTable_KELIME_IKI);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${turkce}"));
        columnBinding.setColumnName("Turkce");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${ingilizce}"));
        columnBinding.setColumnName("Ingilizce");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${almanca}"));
        columnBinding.setColumnName("Almanca");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${kelimeResim}"));
        columnBinding.setColumnName("Resim");
        columnBinding.setColumnClass(javax.swing.ImageIcon.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jTable_KELIME_IKI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_KELIME_IKIMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable_KELIME_IKIMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(jTable_KELIME_IKI);
        if (jTable_KELIME_IKI.getColumnModel().getColumnCount() > 0) {
            jTable_KELIME_IKI.getColumnModel().getColumn(0).setResizable(false);
            jTable_KELIME_IKI.getColumnModel().getColumn(1).setResizable(false);
            jTable_KELIME_IKI.getColumnModel().getColumn(2).setResizable(false);
            jTable_KELIME_IKI.getColumnModel().getColumn(3).setResizable(false);
            jTable_KELIME_IKI.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("KELİME ARA :");

        jTextField_KELIME_ARA.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jTextField_KELIME_ARA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_KELIME_ARAKeyReleased(evt);
            }
        });

        jLabelDate.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField_KELIME_ARA, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 240, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel_ımage, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93)
                        .addComponent(jLabelDate, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_KELIME_ARA, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_ımage, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDate, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("ANASAYFA", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 153));

        jButton_SON.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton_SON.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sozlukk/last-track-icon-son.png"))); // NOI18N
        jButton_SON.setText("SON ");
        jButton_SON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SONActionPerformed(evt);
            }
        });

        jButton_SIL.setBackground(new java.awt.Color(204, 204, 255));
        jButton_SIL.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton_SIL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sozlukk/Actions-window-close-icon.png"))); // NOI18N
        jButton_SIL.setText("SİL !");
        jButton_SIL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SILActionPerformed(evt);
            }
        });

        jButton_EKLE.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton_EKLE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sozlukk/google-plus-icon.png"))); // NOI18N
        jButton_EKLE.setText("EKLE");
        jButton_EKLE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EKLEActionPerformed(evt);
            }
        });

        jButton_YENI.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton_YENI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sozlukk/new-icon.png"))); // NOI18N
        jButton_YENI.setText("YENİ");
        jButton_YENI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_YENIActionPerformed(evt);
            }
        });

        jLabel_RESIM_YÜKLE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sozlukk/Images-icon.png"))); // NOI18N
        jLabel_RESIM_YÜKLE.setText("Resim Seçiniz ");
        jLabel_RESIM_YÜKLE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_RESIM_YÜKLEMouseClicked(evt);
            }
        });

        jButton_ILK.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton_ILK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sozlukk/first-track-icon-ilk.png"))); // NOI18N
        jButton_ILK.setText("İLK");
        jButton_ILK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ILKActionPerformed(evt);
            }
        });

        jButton_GÜNCELLE.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton_GÜNCELLE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sozlukk/Apps-system-software-update-icon.png"))); // NOI18N
        jButton_GÜNCELLE.setText("GÜNCELLE");
        jButton_GÜNCELLE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_GÜNCELLEActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText(" TÜRKÇE :");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText(" İNGİLİZCE :");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText(" ALMANCA :");

        jTextField_ENG.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jTextField_DEU.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jTextField_TR.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jTextField_TR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_TRActionPerformed(evt);
            }
        });

        jTable_KELIME.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jTable_KELIME.setRowHeight(100);

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, kelimeList, jTable_KELIME);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${turkce}"));
        columnBinding.setColumnName("Turkce");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${ingilizce}"));
        columnBinding.setColumnName("Ingilizce");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${almanca}"));
        columnBinding.setColumnName("Almanca");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${kelimeResim}"));
        columnBinding.setColumnName("Resim");
        columnBinding.setColumnClass(javax.swing.ImageIcon.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jTable_KELIME.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable_KELIMEMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_KELIME);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Düzenlenecek Kelime : ");

        jTextField_duzenlenek_kelıme.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jTextField_duzenlenek_kelıme.setForeground(new java.awt.Color(204, 0, 0));
        jTextField_duzenlenek_kelıme.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_duzenlenek_kelımeKeyReleased(evt);
            }
        });

        jButton_EXCELEAKTAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sozlukk/Button-Upload-icon.png"))); // NOI18N
        jButton_EXCELEAKTAR.setText("EXCELE AKTAR");
        jButton_EXCELEAKTAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EXCELEAKTARActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField_duzenlenek_kelıme)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField_TR, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField_DEU, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_ENG, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton_SIL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_EKLE, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                            .addComponent(jButton_YENI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton_ILK, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_GÜNCELLE, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_SON, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton_EXCELEAKTAR, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_RESIM_YÜKLE, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton_EXCELEAKTAR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton_YENI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField_TR, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton_ILK, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_ENG, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_DEU, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField_duzenlenek_kelıme, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton_EKLE, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_GÜNCELLE, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton_SIL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_SON, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel_RESIM_YÜKLE, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(514, 514, 514))
        );

        jTabbedPane1.addTab("AYARLAR", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_duzenlenek_kelımeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_duzenlenek_kelımeKeyReleased
        TableRowSorter<TableModel> tableRowSorter = new TableRowSorter<>(jTable_KELIME.getModel());
        jTable_KELIME.setRowSorter(tableRowSorter);
        tableRowSorter.setRowFilter(RowFilter.regexFilter(jTextField_duzenlenek_kelıme.getText().toString()));
    }//GEN-LAST:event_jTextField_duzenlenek_kelımeKeyReleased

    private void jTable_KELIMEMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_KELIMEMousePressed
        int secilen_satir = jTable_KELIME.getSelectedRow();

        jTable_KELIME.setSelectionBackground(Color.YELLOW);
        jTable_KELIME.setSelectionForeground(Color.BLACK);

        if (secilen_satir == -1) {
            //secilmedi
        } else {
            jTextField_TR.setText(jTable_KELIME.getValueAt(secilen_satir, 1).toString());
            jTextField_ENG.setText(jTable_KELIME.getValueAt(secilen_satir, 2).toString());
            jTextField_DEU.setText(jTable_KELIME.getValueAt(secilen_satir, 3).toString());
            jLabel_RESIM_YÜKLE.setIcon((ImageIcon) (jTable_KELIME.getValueAt(secilen_satir, 4)));
            jLabel_RESIM_YÜKLE.setText("");

        }
    }//GEN-LAST:event_jTable_KELIMEMousePressed

    private void jTextField_TRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_TRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_TRActionPerformed

    private void jButton_GÜNCELLEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_GÜNCELLEActionPerformed
        int secileSatir = jTable_KELIME.getSelectedRow();
        if (secileSatir == -1) {
            JOptionPane.showMessageDialog(null, "Lütfen Bir Seçim Yapınız ");
        } else {
            String sorgu = " UPDATE KELIME SET TURKCE=?,INGILIZCE=?,ALMANCA=? WHERE ID = ?";
            int id = Integer.parseInt(jTable_KELIME.getValueAt(secileSatir, 0).toString());
            try {
                Connection bag = DriverManager.getConnection(adres, kullanici, sifre);

                PreparedStatement ps = bag.prepareStatement(sorgu);
                ps.setString(1, jTextField_TR.getText().toString());
                ps.setString(2, jTextField_ENG.getText().toString());
                ps.setString(3, jTextField_DEU.getText().toString());
                ps.setInt(4, id);
                ps.executeUpdate();
                ps.close();
                bag.close();

                System.out.println("başarıyla güncellendi ! ");

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, " hata " + ex.toString());
            }
        }

    }//GEN-LAST:event_jButton_GÜNCELLEActionPerformed

    private void jButton_ILKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ILKActionPerformed
        KayitGetir("ilk");

    }//GEN-LAST:event_jButton_ILKActionPerformed

    private void jLabel_RESIM_YÜKLEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_RESIM_YÜKLEMouseClicked
        JFileChooser resimSecici = new JFileChooser();
        int secim = resimSecici.showOpenDialog(this);
        if (secim == JFileChooser.APPROVE_OPTION) {
            dosya = resimSecici.getSelectedFile();
            resimAd = dosya.getName();
            resimAdres = dosya.getPath();
            ImageIcon resim = new ImageIcon(resimAdres);
            jLabel_RESIM_YÜKLE.setIcon(resim);
            jLabel_RESIM_YÜKLE.setText(" ");

        }
    }//GEN-LAST:event_jLabel_RESIM_YÜKLEMouseClicked

    private void jButton_YENIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_YENIActionPerformed
        jTextField_TR.setText("");
        jTextField_ENG.setText("");
        jTextField_DEU.setText("");
        jLabel_RESIM_YÜKLE.setIcon(null);
        jLabel_RESIM_YÜKLE.setText(" Resim Yüklemek için tıklayınız ! ");
        jTextField_duzenlenek_kelıme.setText("");
        TableRowSorter<TableModel> tableRowSorter = new TableRowSorter<>(jTable_KELIME.getModel());
        jTable_KELIME.setRowSorter(tableRowSorter);
        tableRowSorter.setRowFilter(RowFilter.regexFilter(jTextField_duzenlenek_kelıme.getText().toString()));
    }//GEN-LAST:event_jButton_YENIActionPerformed

    private void jButton_EKLEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EKLEActionPerformed
        String adres = "jdbc:derby://localhost:1527/sozluk";
        String kullanici = "DYILMAZ";
        String sifre = "123";
        String TR = jTextField_TR.getText();
        String ENG = jTextField_ENG.getText();
        String DEU = jTextField_DEU.getText();
        String sorgu = "INSERT INTO KELIME (turkce,ingilizce,almanca,resim) VALUES (?,?,?,?)";
        if (dosya == null) {
            JOptionPane.showMessageDialog(this, "Lütfen Resim Seçiniz ! ");
        } else {
            try {
                Connection bag = DriverManager.getConnection(adres, kullanici, sifre);
                FileInputStream fis = new FileInputStream(dosya);
                PreparedStatement ps = bag.prepareStatement(sorgu);
                ps.setString(1, TR);
                ps.setString(2, ENG);
                ps.setString(3, DEU);
                ps.setBinaryStream(4, fis, (int) dosya.length());
                ps.executeUpdate();
                ps.close();
                fis.close();
                bag.close();
                // TabloDoldur();
                System.out.println("kayıt Başarıyla Eklendi ");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "kayıt yapılamadı ! " + ex.toString());
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "dosya bulunmadı ! " + ex.toString());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "dosya işlem hatası ! " + ex.toString());
            }
        }
    }//GEN-LAST:event_jButton_EKLEActionPerformed

    private void jButton_SILActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SILActionPerformed
        int secilenSatir = jTable_KELIME.getSelectedRow();
        if (secilenSatir == -1) {
            JOptionPane.showMessageDialog(null, "lütfen bir seçim yapınız !");

        } else {
            Object[] options = {"EVET", "HAYIR"};
            int onay = JOptionPane.showOptionDialog(this, "Silmek istediğine emin misin", "UYARI", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (onay == 0) {
                String ID = jTable_KELIME.getValueAt(secilenSatir, 0).toString();

                try {
                    Connection bag = DriverManager.getConnection(adres, kullanici, sifre);
                    Statement st = bag.createStatement();
                    st.executeUpdate("DELETE FROM KELIME WHERE id = " + ID);
                    bag.close();

                } catch (SQLException ex) {
                    Logger.getLogger(sozluk.class.getName()).log(Level.SEVERE, null, ex);

                }
            }
        }
    }//GEN-LAST:event_jButton_SILActionPerformed

    private void jButton_SONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SONActionPerformed
        KayitGetir("son");
    }//GEN-LAST:event_jButton_SONActionPerformed

    private void jButton_EXCELEAKTARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EXCELEAKTARActionPerformed
        String DOSYA_ADI = System.getProperty("user.dir")+"\\src\\sozlukk\\kelimelerim.xlsx";
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Kelimeler");
        Object[][] kelimeler = new Object[jTable_KELIME.getRowCount()][4];
        kelimeler[0][0] = "ID";
        kelimeler[0][1] = "TURKCE";
        kelimeler[0][2] = "INGILIZCE";
        kelimeler[0][3] = "ALMANCA";
        for (int i = 1; i < jTable_KELIME.getRowCount(); i++) {
            kelimeler[i][0] = jTable_KELIME.getValueAt(i, 0);
            kelimeler[i][1] = jTable_KELIME.getValueAt(i, 1);
            kelimeler[i][2] = jTable_KELIME.getValueAt(i, 2);
            kelimeler[i][3] = jTable_KELIME.getValueAt(i, 3);
        }
        int satirNo = 0;
       JOptionPane.showMessageDialog(null, " Exel Tablosu Oluşturuluyor ");/* System.out.println("excel tablosu oluşturuluyor ! ");*/
        for (Object[] kelime : kelimeler) {
            Row row = sheet.createRow(satirNo++);
            int colNum = 0;
            for (Object field : kelime) {
                Cell cell = row.createCell(colNum++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
        }

        try {
            FileOutputStream outputStream = new FileOutputStream(DOSYA_ADI);
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        JOptionPane.showMessageDialog(this,System.getProperty("user.dir")+"\\src\\kelimelerim.xlsx\n" + " Kaydedilen Konum  = " );
    }//GEN-LAST:event_jButton_EXCELEAKTARActionPerformed

    private void jTextField_KELIME_ARAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_KELIME_ARAKeyReleased

        TableRowSorter<TableModel> tableRowSorter = new TableRowSorter<>(jTable_KELIME_IKI.getModel());
        jTable_KELIME_IKI.setRowSorter(tableRowSorter);
        tableRowSorter.setRowFilter(RowFilter.regexFilter(jTextField_KELIME_ARA.getText().toString()));
    }//GEN-LAST:event_jTextField_KELIME_ARAKeyReleased

    private void jTable_KELIME_IKIMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_KELIME_IKIMousePressed
        int secilen_satir = jTable_KELIME.getSelectedRow();

        jTable_KELIME_IKI.setSelectionBackground(Color.YELLOW);
        jTable_KELIME_IKI.setSelectionForeground(Color.BLACK);
        if (secilen_satir == -1) {
            //secilmedi
        } else {
            jTextField_TR.setText(jTable_KELIME.getValueAt(secilen_satir, 1).toString());
            jTextField_ENG.setText(jTable_KELIME.getValueAt(secilen_satir, 2).toString());
            jTextField_DEU.setText(jTable_KELIME.getValueAt(secilen_satir, 3).toString());
            jLabel_RESIM_YÜKLE.setIcon((ImageIcon) (jTable_KELIME.getValueAt(secilen_satir, 4)));
            jLabel_RESIM_YÜKLE.setText("");
        }
    }//GEN-LAST:event_jTable_KELIME_IKIMousePressed
    
    private void jTable_KELIME_IKIMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_KELIME_IKIMouseClicked
    
        
        int secilen_satir = jTable_KELIME_IKI.getSelectedRow();
        if (jTable_KELIME_IKI.getValueAt(secilen_satir, 4) != null) {

            ImageIcon image1 = (ImageIcon)jTable_KELIME_IKI.getValueAt(secilen_satir, 4);
            Image image2 = image1.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);
            ImageIcon image3 = new ImageIcon(image2);
            jLabel_ımage.setIcon(image3);
        }else {
            System.out.println("resim yok");
        }
      
    }//GEN-LAST:event_jTable_KELIME_IKIMouseClicked
    private String resimAd, resimAdres;
    private File dosya = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       /* XSSFWorkbook dosya = new XSSFWorkbook();
        XSSFSheet sayfa = dosya.createSheet("Kelime");
        Object[][] tablo = {
            {"ID","TURKCE","INGILIZCE","ALMANCA","RESIM"},
            
           };
        int satirNo = 0;
        System.out.println("Excel Dosyası Oluşturuluyor...");
        for(Object[] tabloSatir : tablo){
            Row satir = sayfa.createRow(satirNo++);
            int sütunNo = 0;
            for(Object tabloHucre : tabloSatir){
                 Cell hucre = satir.createCell(sütunNo++);
                  if(tabloHucre instanceof String){
                      hucre.setCellValue((String) tabloHucre);
                      
                  }else if(tabloHucre instanceof Integer){
                      hucre.setCellValue((Integer) tabloHucre);
                  }
                 String DOSYA_ADI = System.getProperty("user.dir")+"\\src\\sozlukk\\kelimelerim.xlsx";
                  try{
                      FileInputStream excelDosya = new FileInputStream(new File(Dosya));
                      Workbook Kelime = new XSSFWorkbook(excelDosya);
                      Sheet sayfaa = Kelime.getSheetAt(0);//1.çalışma sayfasını alır
                      Iterator<Row> kademeSatir = sayfa.iterator();
                      while(kademeSatir.hasNext()){
                          Row satirr = kademeSatir.next();
                          Iterator<Cell> kademeHucre = satirr.iterator();
                          while(kademeHucre.hasNext()){
                              Cell hucree = kademeHucre.next();
                              if(hucre.getCellType() == CellType.STRING){
                                  System.out.print(hucree.getStringCellValue() + "--");
                                  
                              }else if(hucree.getCellType() == CellType.NUMERIC){
                                  System.out.print(hucree.getNumericCellValue() + "--");
                              }
                          }
                          System.out.println("");
                      }
                                                       
                              } catch (FileNotFoundException ex) {
                                System.out.println("Hata : " + ex.toString());
                  } catch (IOException ex) {
                      System.out.println("Hata: " + ex.toString());
                  }
                
            }
            
        }*/
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("System".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(sozluk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(sozluk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(sozluk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(sozluk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new sozluk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_EKLE;
    private javax.swing.JButton jButton_EXCELEAKTAR;
    private javax.swing.JButton jButton_GÜNCELLE;
    private javax.swing.JButton jButton_ILK;
    private javax.swing.JButton jButton_SIL;
    private javax.swing.JButton jButton_SON;
    private javax.swing.JButton jButton_YENI;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelDate;
    private javax.swing.JLabel jLabel_RESIM_YÜKLE;
    private javax.swing.JLabel jLabel_ımage;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable_KELIME;
    private javax.swing.JTable jTable_KELIME_IKI;
    private javax.swing.JTextField jTextField_DEU;
    private javax.swing.JTextField jTextField_ENG;
    private javax.swing.JTextField jTextField_KELIME_ARA;
    private javax.swing.JTextField jTextField_TR;
    private javax.swing.JTextField jTextField_duzenlenek_kelıme;
    private java.util.List<sozlukk.Kelime> kelimeList;
    private java.util.List<sozlukk.Kelime> kelimeList1;
    private javax.persistence.Query kelimeQuery;
    private javax.persistence.Query kelimeQuery1;
    private javax.persistence.EntityManager sozlukPUEntityManager;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
