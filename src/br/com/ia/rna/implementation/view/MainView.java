/*
    Artificial Neural Network implementation using Weka & imageJ API
    Copyright (C) 2018  Rafael de Araújo Paim

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.

    Contact info:
    email: rafael21_psp@hotmail.com
 */
package br.com.ia.rna.implementation.view;

import br.com.ia.rna.implementation.arff.ARFFPath;
import br.com.ia.rna.implementation.model.ModelControl;
import ij.ImagePlus;
import ij.process.ByteProcessor;
import ij.process.ColorProcessor;
import ij.process.ImageStatistics;
import java.awt.Image;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;



/**
 *
 * @author Rafael
 */
public class MainView extends javax.swing.JFrame {
    
    public static final String PROP_ARFFPATH = "arffPath"; //Static constant for the arffPath property
    
    private ARFFPath arffPath = new ARFFPath(); //ARFFPath object to store a retrieve the path to the image and the arff file
    private ModelControl model = new ModelControl(); //This will be used to load the model
    
    //==============Getters & Setters==================
    /**
     * Get the value of model
     *
     * @return the value of model
     */
    public ModelControl getModel() {
        return model;
    }

    /**
     * Set the value of model
     *
     * @param model new value of model
     */
    public void setModel(ModelControl model) {
        this.model = model;
    }


    public ARFFPath getArffPath() {
        return arffPath;
    }

    public void setArffPath(ARFFPath arffPath) {
        ARFFPath oldArffPath = this.arffPath;
        this.arffPath = arffPath;
        propertyChangeSupport.firePropertyChange(PROP_ARFFPATH, oldArffPath, arffPath);
    }
    
    //==========================================================
    
    //This makes property modification compatibility possible
    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
    //======================================================
    
    
    /**
     * Creates new form MainView
     */
    public MainView() {
        initComponents();
        btnClassify.setEnabled(false);
        txtReady.setVisible(false);
        txtReady.setText("Done!");
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jPanel1 = new javax.swing.JPanel();
        txtMainText = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtTestImagePath = new javax.swing.JLabel();
        jtImageTestPath = new javax.swing.JTextField();
        btnClassify = new javax.swing.JButton();
        btnGenerateARFF = new javax.swing.JButton();
        txtReady = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtModelPath = new javax.swing.JLabel();
        jtModelPath = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtMainText.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        txtMainText.setText("ANN Implementation using Weka & ImageJ API");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtMainText)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(txtMainText)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        txtTestImagePath.setText("Set your image path:");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${arffPath.filePath}"), jtImageTestPath, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        btnClassify.setText("Classify Image");
        btnClassify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClassifyActionPerformed(evt);
            }
        });

        btnGenerateARFF.setText("Generate ARFF file");
        btnGenerateARFF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateARFFActionPerformed(evt);
            }
        });

        txtReady.setFocusable(false);
        txtReady.setInheritsPopupMenu(false);

        jLabel1.setText("MIT License");

        jLabel2.setText("Copyright (C) 2018  Rafael de Araújo Paim");

        txtModelPath.setText("Set your model path:");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${model.modelPath}"), jtModelPath, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jtModelPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtModelPathActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(txtReady, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTestImagePath)
                            .addComponent(btnGenerateARFF)
                            .addComponent(txtModelPath))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtImageTestPath)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnClassify, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jtModelPath))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtModelPath)
                    .addComponent(jtModelPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTestImagePath)
                    .addComponent(jtImageTestPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClassify)
                    .addComponent(btnGenerateARFF))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtReady, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerateARFFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateARFFActionPerformed
        //This section is the code that generates and creates the ARFF File

        //Constructs a mutable sequence of characters
        StringBuilder arff = new StringBuilder();
        arff.append("@relation AP2\n");
        //These are the attributes chosen to extract features fom the image, all taken from the ImageStatistics class of ImageJ API
        arff.append("@attribute min numeric\n"); 
        arff.append("@attribute maxcount numeric\n"); 
        arff.append("@attribute umean numeric\n"); 
        arff.append("@attribute skewness numeric\n"); 
        arff.append("@attribute stddev numeric\n"); 
        arff.append("@attribute xCenterOfMass numeric\n"); 
        arff.append("@attribute yCenterOfMass numeric\n"); 
        arff.append("@attribute mean numeric\n"); 
        arff.append("@attribute areaFraction numeric\n"); 
        arff.append("@attribute histMax numeric\n"); 
        arff.append("@attribute histMin numeric\n"); 
        arff.append("@attribute median numeric\n"); 
        arff.append("@attribute xCentroid numeric\n");  
        arff.append("@attribute yCentroid numeric\n"); 
        arff.append("@attribute upperThreshold numeric\n"); 
        arff.append("@attribute pixelCount numeric\n"); 
        arff.append("@attribute dmode numeric\n"); 
        arff.append("@attribute area numeric\n");
        /*These are the instance's classes that the model trained for, this is the information tha classifier will 
        give to the user, i.e which class a given image belongs*/
        arff.append("@attribute class {airplanes, faces, brain, leopards, motorbikes, grand_piano, watch, bonsai, car_side, chandelier}\n");
        arff.append("@data\n");

        String filePath = arffPath.getFilePath(); //Gets the path of the image
        //These are classes from the imageJ API to process images, analyze and measure features from them
        ImagePlus imagePlus;
        Image image;
        ColorProcessor cProcessor;
        ByteProcessor processor;
        ImageStatistics data;

        File file = new File(filePath); //Creates a new file using the image path stores in the filePath variable
        File[] files = file.listFiles(); /*This array retrieves a list of files that are inside the folder of some directory, if
        the path chosen has more than one image, the program will use the first image file of that folder*/

        for(int i=0;i<1;i++){
            File fileTmp = files[i]; //Gets a image from the list
            imagePlus = new ImagePlus(fileTmp.getAbsolutePath()); //Constructs an image using the image's absolute file path
            image = imagePlus.getImage(); //Retrives that image
            cProcessor = new ColorProcessor(image); //Color processor object tha can manipulate color attibutes of the image
            //This creates a ByteProcessor object with a image that was converted to a binary Image
            processor = new ByteProcessor(cProcessor.convertToByte(true).createImage());
            processor.smooth(); //Smoothens the image
            processor.findEdges(); //Calculates the image's borders, filtering most of the external noises 
            processor.setThreshold(160, 255, 1); //Uses a threshold to filter even more noises
            data = processor.getStatistics(); //This variable stores all the values of measurable features from the ByteProcessor object.
            
            //In this part, the program get's the values of the attributes chosen to build the dataset for the model 
            String instance = data.min+","
                            +data.maxCount+","
                            +data.umean+","
                            +data.skewness+","
                            +data.stdDev+","
                            +data.xCenterOfMass+","
                            +data.yCenterOfMass+","
                            +data.mean+","
                            +data.areaFraction+","
                            +data.histMin+","
                            +data.histMax+","
                            +data.median+","
                            +data.xCentroid+","
                            +data.yCentroid+","
                            +data.upperThreshold+","
                            +data.pixelCount+","
                            +data.dmode+","
                            +data.area+","
                            +"?"+"\n"; 
            arff.append(instance); //Sets all those texts in the StringBuilder object

            //This part is responsible to create the arff file itself
            try{
                File test = new File(filePath+"test.arff"); //Creates a file inside the image file path
                arffPath.setArffPath(filePath+"test.arff"); //Sets the arff file path, it's necessary later to get this path
            if(test.exists()){ //Checks if the file already exists and if so, removes it
                    test.delete();
            }
                test.createNewFile(); //Creates an empty file
                FileWriter writer = new FileWriter(test.getAbsoluteFile()); //Constructs a FileWriter object with the arff file path as a parameter
                BufferedWriter bufferedWriter = new BufferedWriter(writer); //Passes the FileWtriter object to a BufferedWriter object
                bufferedWriter.write(arff.toString()); //Writes the entire StringBuilder object in the file
                bufferedWriter.close(); //Closes the BufferedReader
            }catch(IOException e){
                System.out.println("ARFF file generation process has thrown an Exception!"); /*If some error occurs in this part of the code, this message will show on
                So it's possible to know if the problem was in this part of the code*/
            }
                txtReady.setVisible(true); //Pops up a text on the screen saying the ARFF file generation was completed
                btnClassify.setEnabled(true); //Enables the button to classify the image
                System.out.println("ARFF file generation process occured successfully!"); //This is shown on console every time this part of the code is done successfullly
        }   
    }//GEN-LAST:event_btnGenerateARFFActionPerformed

    private void btnClassifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClassifyActionPerformed
        //This part is responsible for loading the trained model and letting it classify the image for the user
        try {
            //sets the Classifier using the SerializationHelper class to deserialize the .model file into an object and typecasting it to the classifier type
            model.setModel((MultilayerPerceptron)weka.core.SerializationHelper.read(model.getModelPath()));
            DataSource source = new DataSource(arffPath.getArffPath()); //Constructs a DataSource with the ARFF file as a parameter
            Instances instances = source.getDataSet(); //Retrieve a set of weighted instances (in this case, just one)
            instances.setClassIndex(instances.numAttributes()-1); //Sets the class index
            Instance newInstance = instances.firstInstance(); //Retrieves the first instance of the class
            double predictionClass = model.getModel().classifyInstance(newInstance); //Uses the model to classify it and store the prediction into a variable
            alertUser(predictionClass); //Based on the predictionClass, a message is shown on the screen saying the model's guessing
            System.out.println("Predicted: "+predictionClass); //Shows on the console the predicted class index
        } catch (Exception ex) {
            System.out.println("Classification process has thrown an Exception!");
        }
    }//GEN-LAST:event_btnClassifyActionPerformed

    private void jtModelPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtModelPathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtModelPathActionPerformed
        
    public void alertUser(double prediction){ //This method receive the number of the class predicted by the model and base on that, shows 
        //which class the model guessed
        if(prediction==0.0){
            JOptionPane.showMessageDialog(this, "This image looks like an airplane", "ANN Classification", JOptionPane.INFORMATION_MESSAGE);
            txtReady.setVisible(false);
        }
        if(prediction==1.0){
            JOptionPane.showMessageDialog(this, "This image looks like a face", "ANN Classification", JOptionPane.INFORMATION_MESSAGE);
            txtReady.setVisible(false);
        }
        if(prediction==2.0){
            JOptionPane.showMessageDialog(this, "This image looks like a brain", "ANN Classification", JOptionPane.INFORMATION_MESSAGE);
            txtReady.setVisible(false);
        }
        if(prediction==3.0){
            JOptionPane.showMessageDialog(this, "This image looks like a leopard", "ANN Classification", JOptionPane.INFORMATION_MESSAGE);
            txtReady.setVisible(false);
        }
        if(prediction==4.0){
            JOptionPane.showMessageDialog(this, "This image looks like a motorbike", "ANN Classification", JOptionPane.INFORMATION_MESSAGE);
            txtReady.setVisible(false);
        }
        if(prediction==5.0){
            JOptionPane.showMessageDialog(this, "This image looks like a grand piano", "ANN Classification", JOptionPane.INFORMATION_MESSAGE);
            txtReady.setVisible(false);
        }
        if(prediction==6.0){
            JOptionPane.showMessageDialog(this, "This image looks like a watch", "ANN Classification", JOptionPane.INFORMATION_MESSAGE);
            txtReady.setVisible(false);
        }
        if(prediction==7.0){
            JOptionPane.showMessageDialog(this, "This image looks like a bonsai", "ANN Classification", JOptionPane.INFORMATION_MESSAGE);
            txtReady.setVisible(false);
        }
        if(prediction==8.0){
            JOptionPane.showMessageDialog(this, "This image looks like a side of a car", "ANN Classification", JOptionPane.INFORMATION_MESSAGE);
            txtReady.setVisible(false);
        }
        if(prediction==9.0){
            JOptionPane.showMessageDialog(this, "This image looks like a chandelier", "ANN Classification", JOptionPane.INFORMATION_MESSAGE);
            txtReady.setVisible(false);
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
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClassify;
    private javax.swing.JButton btnGenerateARFF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jtImageTestPath;
    private javax.swing.JTextField jtModelPath;
    private javax.swing.JLabel txtMainText;
    private javax.swing.JLabel txtModelPath;
    private javax.swing.JLabel txtReady;
    private javax.swing.JLabel txtTestImagePath;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
