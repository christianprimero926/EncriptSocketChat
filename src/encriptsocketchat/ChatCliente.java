/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package encriptsocketchat;

import RSA.RSA;
import TRANSPOSICION.Transposicion;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

/**
 *
 * @author chris
 */
public class ChatCliente extends javax.swing.JFrame {

    private static String tipoAlgoritmo;
    private static final String host = "192.168.1.20";
    public final static String str1 = "!#$;*/=&?¿+_¡@*-°1234567890!#$;*/=&?¿+_¡@*-°1234567890";
    public final static String str2 = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ";

    static ServerSocket ss;
    static ServerSocket ss2;
    static ServerSocket ss3;
    static ServerSocket ss4;

    static Socket s;
    static Socket s2;
    static Socket s3;
    static Socket s4;

    static DataInputStream dis;
    static DataInputStream disN;
    static DataInputStream disD;
    static DataInputStream disT;

    static DataOutputStream dos;
    static DataOutputStream dosN;
    static DataOutputStream dosD;
    static DataOutputStream dosT;

    /**
     * Creates new form chat1
     */
    public ChatCliente() {
        initComponents();
        cifradoRSA = new RSA(10);
        crifradoTransposicion = new Transposicion();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaMsg = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jRadioButtonTransposicion = new javax.swing.JRadioButton();
        jRadioButtonSustitucion = new javax.swing.JRadioButton();
        jRadioButtonRSA = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jTextFieldMsg = new javax.swing.JTextField();
        jButtonEnviar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Chat Cliente"));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jTextAreaMsg.setColumns(20);
        jTextAreaMsg.setRows(20);
        jScrollPane1.setViewportView(jTextAreaMsg);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel2.setMinimumSize(new java.awt.Dimension(351, 20));
        jPanel2.setPreferredSize(new java.awt.Dimension(662, 100));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Algoritmos de Encriptacion"));
        jPanel4.setLayout(new java.awt.GridLayout(3, 2));

        jRadioButtonTransposicion.setText("Transposición");
        jPanel4.add(jRadioButtonTransposicion);

        jRadioButtonSustitucion.setText("Sustitución");
        jPanel4.add(jRadioButtonSustitucion);

        jRadioButtonRSA.setText("RSA");
        jPanel4.add(jRadioButtonRSA);

        jRadioButton4.setText("Otro...");
        jPanel4.add(jRadioButton4);

        jPanel2.add(jPanel4, java.awt.BorderLayout.LINE_END);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Envio de Mensaje"));
        jPanel3.setPreferredSize(new java.awt.Dimension(100, 66));

        jButtonEnviar.setText("Enviar");
        jButtonEnviar.setVerifyInputWhenFocusTarget(false);
        jButtonEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldMsg, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonEnviar)
                .addGap(17, 17, 17))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldMsg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEnviar))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEnviarActionPerformed
        try {
            if (jRadioButtonTransposicion.isSelected()) {
//                jRadioButtonRSA.setSelected(false);
//                jRadioButtonSustitucion.setSelected(false);
                tipoAlgoritmo = "Transposicion";
                String msg;
                String msgEncript;
                msg = jTextFieldMsg.getText();
                byte[] c;

                jTextFieldMsg.setText("");
                msgEncript = new String(c = crifradoTransposicion.encripta(msg.getBytes()));

                System.out.println("Valor Final encriptado : " + msgEncript);
                dos.writeUTF(msgEncript);
                jTextAreaMsg.setText(jTextAreaMsg.getText() + "\n Usted: " + msg);
                dosT.writeUTF(tipoAlgoritmo);

            } else if (jRadioButtonSustitucion.isSelected()) {
//                jRadioButtonRSA.setSelected(false);
//                jRadioButtonTransposicion.setSelected(false);
                tipoAlgoritmo = "Sustitucion";

                String msg;
                String msgEncript;
                msg = jTextFieldMsg.getText();
                msgEncript = jTextFieldMsg.getText();
                jTextFieldMsg.setText("");

                for (int i = 0; i < str1.length(); i++) {
                    msgEncript = msgEncript.replace(str2.charAt(i), str1.charAt(i));
                }
                System.out.println("Valor Final encriptado : " + msgEncript);
                dos.writeUTF(msgEncript);
                jTextAreaMsg.setText(jTextAreaMsg.getText() + "\n Usted: " + msg);
                dosT.writeUTF(tipoAlgoritmo);

            } else if (jRadioButtonRSA.isSelected()) {
//                jRadioButtonSustitucion.setSelected(false);
//                jRadioButtonTransposicion.setSelected(false);
                tipoAlgoritmo = "RSA";
                String msg = "";
                String msgFinalEncrip = "";
                BigInteger[] textoCifrado;
                msg = jTextFieldMsg.getText();
                textoCifrado = cifradoRSA.encripta(msg);
                jTextFieldMsg.setText("");

                for (BigInteger textoCifrado1 : textoCifrado) {
                    String msgEncriptado = "";
                    msgEncriptado = textoCifrado1.toString();
                    msgFinalEncrip = msgFinalEncrip + msgEncriptado + "\t";
                }
                System.out.println("Valor Final encriptado : " + msgFinalEncrip);

                dos.writeUTF(msgFinalEncrip);

                System.out.println("Este es el valor de N: " + cifradoRSA.bigIntObtenerN().toString());
                System.out.println("Este es el valor de d: " + cifradoRSA.bigIntObtenerD().toString());
                jTextAreaMsg.setText(jTextAreaMsg.getText() + "\n Usted: " + msg);
                dosN.writeUTF(cifradoRSA.bigIntObtenerN().toString());
                dosD.writeUTF(cifradoRSA.bigIntObtenerD().toString());
                dosT.writeUTF(tipoAlgoritmo);

            } else {
                tipoAlgoritmo = "Normal";
                String msg;
                msg = jTextFieldMsg.getText();
                jTextFieldMsg.setText("");
                dos.writeUTF(msg);
                jTextAreaMsg.setText(jTextAreaMsg.getText() + "\n Usted: " + msg);
                dosT.writeUTF(tipoAlgoritmo);
            }
        } catch (IOException ex) {
            System.out.println("encriptsocketchat.chat1.jButtonDesencriptarActionPerformed()" + ex);
        }
    }//GEN-LAST:event_jButtonEnviarActionPerformed

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
            java.util.logging.Logger.getLogger(ChatCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChatCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChatCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChatCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ChatCliente().setVisible(true);
        });

        try {

            String msgDesencriptado = "";
            String msjentrada = "";
            String msjRsaD = "";
            String msjRsaN = "";
            String tipoAlg = "";

            s = new Socket(host, 1449);
            s2 = new Socket(host, 1450);
            s3 = new Socket(host, 1451);
            s4 = new Socket(host, 1452);

            dis = new DataInputStream(s.getInputStream());
            disN = new DataInputStream(s2.getInputStream()); // N va por el puerto 1450
            disD = new DataInputStream(s3.getInputStream()); // D va por el puerto 1451
            disT = new DataInputStream(s4.getInputStream()); // Tipo de Algoritmo va por el puerto 1452            

            dos = new DataOutputStream(s.getOutputStream());
            dosN = new DataOutputStream(s2.getOutputStream());
            dosD = new DataOutputStream(s3.getOutputStream());
            dosT = new DataOutputStream(s4.getOutputStream());

            while (!msjentrada.equals("Exit")) {

                //ladoCliente ld = new ladoCliente();
                msjentrada = dis.readUTF(); //-- aqui si lo hace
                tipoAlg = disT.readUTF();

                System.out.println("Este es el mensaje del servidor:" + msjentrada); //---                 
                switch (tipoAlg) {
                    case "Transposicion":
                        jTextAreaMsg.setText(jTextAreaMsg.getText() + "\n Este es el mensaje del servidor encriptado con " + tipoAlg + ": ");
                        jTextAreaMsg.setText(jTextAreaMsg.getText() + "\n " + msjentrada);

                        String mensajeTran = new String(crifradoTransposicion.desencripta(msjentrada.getBytes()));
                        System.out.println("Valor desencriptado: " + mensajeTran);
                        jTextAreaMsg.setText(jTextAreaMsg.getText() + "\n Mensaje desencriptado del servidor: " + mensajeTran);
                        break;
                    case "Sustitucion":
                        jTextAreaMsg.setText(jTextAreaMsg.getText() + "\n Este es el mensaje del servidor encriptado con " + tipoAlg + ": ");
                        jTextAreaMsg.setText(jTextAreaMsg.getText() + "\n " + msjentrada);
                        String mensaje = msjentrada;
                        //System.out.println("\nMensaje cifrado  : " + mensaje);
                        for (int i = 0; i < str1.length(); i++) {
                            mensaje = mensaje.replace(str1.charAt(i), str2.charAt(i));
                        }
                        System.out.println("Valor desencriptado: " + mensaje);
                        jTextAreaMsg.setText(jTextAreaMsg.getText() + "\n Mensaje desencriptado del servidor: " + mensaje);
                        break;
                    case "RSA":
                        jTextAreaMsg.setText(jTextAreaMsg.getText() + "\n Este es el mensaje del servidor encriptado con " + tipoAlg + ": ");
                        jTextAreaMsg.setText(jTextAreaMsg.getText() + "\n Servidor: " + msjentrada);
                        msjRsaN = disN.readUTF();
                        msjRsaD = disD.readUTF();
                        BigInteger rsaN = new BigInteger(msjRsaN);
                        BigInteger rsaD = new BigInteger(msjRsaD);
                        System.out.println("Recibí este valor de D: " + msjRsaD);
                        System.out.println("Recibí este valor de N: " + msjRsaN);
                        String letra = "";
                        StringTokenizer st = new StringTokenizer(msjentrada);
                        BigInteger[] textoEncriptado = new BigInteger[st.countTokens()];
                        for (int i = 0; i < textoEncriptado.length; i++) {
                            letra = st.nextToken();
                            textoEncriptado[i] = new BigInteger(letra);
                        }
                        msgDesencriptado = cifradoRSA.desencripta(textoEncriptado, rsaD, rsaN);
                        System.out.println("Valor desencriptado: " + msgDesencriptado);
                        jTextAreaMsg.setText(jTextAreaMsg.getText() + "\n Mensaje desencriptado del servidor: " + msgDesencriptado);
                        break;
                    default:
                        System.out.println("entra");
                        jTextAreaMsg.setText(jTextAreaMsg.getText() + "\n Servidor: " + msjentrada);
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println("encriptsocketchat.ChatCliente.main(): " + e);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEnviar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButton4;
    private static javax.swing.JRadioButton jRadioButtonRSA;
    private static javax.swing.JRadioButton jRadioButtonSustitucion;
    private static javax.swing.JRadioButton jRadioButtonTransposicion;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTextArea jTextAreaMsg;
    private javax.swing.JTextField jTextFieldMsg;
    // End of variables declaration//GEN-END:variables
    private static RSA cifradoRSA;
    private static Transposicion crifradoTransposicion;
}
