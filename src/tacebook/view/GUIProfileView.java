/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package tacebook.view;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import tacebook.controller.ProfileController;
import tacebook.model.Comment;
import tacebook.model.Message;
import tacebook.model.Post;
import tacebook.model.Profile;

/**
 *
 * @author abel.iglesiasmoure
 */
public class GUIProfileView extends javax.swing.JDialog implements ProfileView {

    /**
     * ArrayList cos perf�s que me solicitaron amizade.
     */
    private ArrayList<Profile> FriendShipArrayList;

    /**
     * Mant�n a referencia ao obxecto controlador.
     */
    private final ProfileController profileController;

    /**
     * Indica o n�mero de publicaci�ns que se mostran na visualizaci�n.
     */
    private int postsShowed = 10;

    /**
     * Para formatear as datas.
     */
    private final SimpleDateFormat formatter;

    /**
     * Creates new form GUIProfileView
     *
     * @param parent
     * @param modal
     * @param profileController
     */
    public GUIProfileView(java.awt.Frame parent, boolean modal, ProfileController profileController) {
        super(parent, modal);
        this.FriendShipArrayList = new ArrayList<>();
        this.profileController = profileController;
        this.formatter = new SimpleDateFormat("dd-MM-yyy '�s' HH:mm:ss");

        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Cada vez que se interact�a cos post
        jTablePosts.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                //Cargo os datos dos comentarios
                int row = jTablePosts.getSelectedRow();

                if (row != -1) {
                    Post post = (Post) jTablePosts.getValueAt(row, 2);

                    ArrayList<Comment> comments = post.getComments();

                    DefaultTableModel myModel = (DefaultTableModel) jTableComments.getModel();
                    myModel.setRowCount(0);

                    for (int i = 0; i < comments.size() && !comments.isEmpty(); i++) {
                        Comment comment = comments.get(i);
                        myModel.addRow(new Object[]{
                            comment.getText(),
                            comment.getSourceProfile(),
                            formatter.format(comment.getDate())
                        });
                    }

                }

            }
        });

        //Cada vez que se fai doble click nas mensaxes privadas
        jTableMessages.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                JTable table = (JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);
                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    jButtonReadMessageActionPerformed(null);
                }
            }
        });
        
        //Cada vez que se fai doble click nun amigo entramos no seu perfil
        jTableFriends.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                JTable table = (JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);
                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    jButtonShowBiographyActionPerformed(null);
                }
            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelHeader = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelUserProfile = new javax.swing.JLabel();
        jLabelTacebookLogo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabelStatusUser = new javax.swing.JLabel();
        jPanelFooter = new javax.swing.JPanel();
        jButtonBackBiography = new javax.swing.JButton();
        jButtonSendMessageFooter = new javax.swing.JButton();
        jButtonChangeStatus = new javax.swing.JButton();
        jButtonCloseSesion = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelBiografia = new javax.swing.JPanel();
        jSplitBiografia = new javax.swing.JSplitPane();
        jPanelNorte = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabelPostShowed = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePosts = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jButtonNewPost = new javax.swing.JButton();
        jButtonNewComment = new javax.swing.JButton();
        jButtonNewLike = new javax.swing.JButton();
        jButtonShowLastPosts = new javax.swing.JButton();
        jPanelSur = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableComments = new javax.swing.JTable();
        jPanelAmigos = new javax.swing.JPanel();
        jSplitBiografia1 = new javax.swing.JSplitPane();
        jPanelNorte1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableFriends = new javax.swing.JTable();
        jPanelButtonsFriends = new javax.swing.JPanel();
        jButtonShowBiography = new javax.swing.JButton();
        jButtonSendMessage = new javax.swing.JButton();
        jPanelSurBiografia = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jButtonAceptFriend = new javax.swing.JButton();
        jButtonRejectFriend = new javax.swing.JButton();
        jButtonNewFriendShipRequest = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jListFriendshipRequest = new javax.swing.JList<>();
        jPanelMensaxes = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableMessages = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jButtonReadMessage = new javax.swing.JButton();
        jButtonDeleteMessage = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("tacebook - Perfil de usuario");

        jPanelHeader.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 5));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tacebook/view/user.png"))); // NOI18N
        jLabel1.setText("Perfil do usuario: ");
        jPanel2.add(jLabel1);

        jLabelUserProfile.setText("jLabel2");
        jPanel2.add(jLabelUserProfile);

        jPanelHeader.add(jPanel2);

        jLabelTacebookLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tacebook/view/tacebook-logo.jpg"))); // NOI18N
        jPanelHeader.add(jLabelTacebookLogo);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tacebook/view/anatomy.png"))); // NOI18N
        jLabel3.setText("Estado actual: ");
        jPanel1.add(jLabel3);

        jLabelStatusUser.setText("jLabel4");
        jPanel1.add(jLabelStatusUser);

        jPanelHeader.add(jPanel1);

        getContentPane().add(jPanelHeader, java.awt.BorderLayout.NORTH);

        jButtonBackBiography.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tacebook/view/reverse.png"))); // NOI18N
        jButtonBackBiography.setText("Volver a mi�a biograf�a");
        jButtonBackBiography.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackBiographyActionPerformed(evt);
            }
        });
        jPanelFooter.add(jButtonBackBiography);

        jButtonSendMessageFooter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tacebook/view/letter.png"))); // NOI18N
        jButtonSendMessageFooter.setText("Enviar mensaxe privada");
        jPanelFooter.add(jButtonSendMessageFooter);

        jButtonChangeStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tacebook/view/anatomy.png"))); // NOI18N
        jButtonChangeStatus.setText("Cambiar estado");
        jButtonChangeStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChangeStatusActionPerformed(evt);
            }
        });
        jPanelFooter.add(jButtonChangeStatus);

        jButtonCloseSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tacebook/view/exit.png"))); // NOI18N
        jButtonCloseSesion.setText("Pechar sesi�n");
        jButtonCloseSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseSesionActionPerformed(evt);
            }
        });
        jPanelFooter.add(jButtonCloseSesion);

        getContentPane().add(jPanelFooter, java.awt.BorderLayout.SOUTH);

        jTabbedPane1.setToolTipText("");

        jPanelBiografia.setLayout(new java.awt.BorderLayout());

        jSplitBiografia.setDividerLocation(250);
        jSplitBiografia.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitBiografia.setToolTipText("");

        jPanelNorte.setLayout(new java.awt.BorderLayout());

        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        jPanel7.add(jLabelPostShowed);

        jLabel2.setText("�ltimas publicaci�ns:");
        jPanel7.add(jLabel2);

        jPanelNorte.add(jPanel7, java.awt.BorderLayout.NORTH);

        jScrollPane1.setFocusTraversalPolicyProvider(true);

        jTablePosts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Autor", "Texto", "Me gustas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTablePosts);

        jPanelNorte.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 10));

        jButtonNewPost.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tacebook/view/post-it.png"))); // NOI18N
        jButtonNewPost.setText("Nova publicaci�n");
        jButtonNewPost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewPostActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonNewPost);

        jButtonNewComment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tacebook/view/speech-bubbles.png"))); // NOI18N
        jButtonNewComment.setText("Comentar");
        jButtonNewComment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewCommentActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonNewComment);

        jButtonNewLike.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tacebook/view/facebook-hand.png"))); // NOI18N
        jButtonNewLike.setText("G�stame");
        jButtonNewLike.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewLikeActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonNewLike);

        jButtonShowLastPosts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tacebook/view/icon-plus.png"))); // NOI18N
        jButtonShowLastPosts.setText("Ver anteriores publicaci�ns");
        jButtonShowLastPosts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonShowLastPostsActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonShowLastPosts);

        jPanelNorte.add(jPanel3, java.awt.BorderLayout.SOUTH);

        jSplitBiografia.setTopComponent(jPanelNorte);

        jPanelSur.setAutoscrolls(true);
        jPanelSur.setLayout(new java.awt.BorderLayout());

        jLabel4.setText("Comentarios:");
        jPanelSur.add(jLabel4, java.awt.BorderLayout.PAGE_START);

        jTableComments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Texto", "De", "Data"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableComments);

        jPanelSur.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jSplitBiografia.setRightComponent(jPanelSur);

        jPanelBiografia.add(jSplitBiografia, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Biograf�a", new javax.swing.ImageIcon(getClass().getResource("/tacebook/view/post-it.png")), jPanelBiografia, ""); // NOI18N

        jPanelAmigos.setLayout(new java.awt.BorderLayout());

        jSplitBiografia1.setDividerLocation(250);
        jSplitBiografia1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitBiografia1.setToolTipText("");

        jPanelNorte1.setLayout(new java.awt.BorderLayout());

        jLabel5.setText("Lista de amig@s:");
        jPanelNorte1.add(jLabel5, java.awt.BorderLayout.NORTH);

        jScrollPane3.setFocusTraversalPolicyProvider(true);

        jTableFriends.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTableFriends);

        jPanelNorte1.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        jPanelButtonsFriends.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 10));

        jButtonShowBiography.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tacebook/view/post-it.png"))); // NOI18N
        jButtonShowBiography.setText("Ver biograf�a");
        jButtonShowBiography.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonShowBiographyActionPerformed(evt);
            }
        });
        jPanelButtonsFriends.add(jButtonShowBiography);

        jButtonSendMessage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tacebook/view/letter.png"))); // NOI18N
        jButtonSendMessage.setText("Enviar mensaxe privada");
        jButtonSendMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSendMessageActionPerformed(evt);
            }
        });
        jPanelButtonsFriends.add(jButtonSendMessage);

        jPanelNorte1.add(jPanelButtonsFriends, java.awt.BorderLayout.SOUTH);

        jSplitBiografia1.setTopComponent(jPanelNorte1);

        jPanelSurBiografia.setAutoscrolls(true);
        jPanelSurBiografia.setLayout(new java.awt.BorderLayout());

        jLabel6.setText("Tes solicitudes de amizade dos seguintes perf�s:");
        jPanelSurBiografia.add(jLabel6, java.awt.BorderLayout.PAGE_START);

        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 5));

        jButtonAceptFriend.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tacebook/view/accept.png"))); // NOI18N
        jButtonAceptFriend.setText("Aceptar solicitude");
        jButtonAceptFriend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptFriendActionPerformed(evt);
            }
        });
        jPanel5.add(jButtonAceptFriend);

        jButtonRejectFriend.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tacebook/view/reject.png"))); // NOI18N
        jButtonRejectFriend.setText("Rexeitar solicitude");
        jButtonRejectFriend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRejectFriendActionPerformed(evt);
            }
        });
        jPanel5.add(jButtonRejectFriend);

        jButtonNewFriendShipRequest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tacebook/view/handshake.png"))); // NOI18N
        jButtonNewFriendShipRequest.setText("Nova solicitude de amizade");
        jButtonNewFriendShipRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewFriendShipRequestActionPerformed(evt);
            }
        });
        jPanel5.add(jButtonNewFriendShipRequest);

        jPanelSurBiografia.add(jPanel5, java.awt.BorderLayout.PAGE_END);

        jScrollPane6.setViewportView(jListFriendshipRequest);

        jPanelSurBiografia.add(jScrollPane6, java.awt.BorderLayout.CENTER);

        jSplitBiografia1.setRightComponent(jPanelSurBiografia);

        jPanelAmigos.add(jSplitBiografia1, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Amig@s", new javax.swing.ImageIcon(getClass().getResource("/tacebook/view/people.png")), jPanelAmigos, ""); // NOI18N

        jPanelMensaxes.setLayout(new java.awt.BorderLayout());

        jLabel7.setText("Mensaxes privadas:");
        jPanelMensaxes.add(jLabel7, java.awt.BorderLayout.PAGE_START);

        jTableMessages.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Lida", "Data", "De", "Texto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(jTableMessages);

        jPanelMensaxes.add(jScrollPane5, java.awt.BorderLayout.CENTER);

        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 5));

        jButtonReadMessage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tacebook/view/email.png"))); // NOI18N
        jButtonReadMessage.setText("Ler mensaxe");
        jButtonReadMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReadMessageActionPerformed(evt);
            }
        });
        jPanel6.add(jButtonReadMessage);

        jButtonDeleteMessage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tacebook/view/reject.png"))); // NOI18N
        jButtonDeleteMessage.setText("Eliminar mensaxe");
        jButtonDeleteMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteMessageActionPerformed(evt);
            }
        });
        jPanel6.add(jButtonDeleteMessage);

        jPanelMensaxes.add(jPanel6, java.awt.BorderLayout.PAGE_END);

        jTabbedPane1.addTab("Mensaxes privadas", new javax.swing.ImageIcon(getClass().getResource("/tacebook/view/chat.png")), jPanelMensaxes, ""); // NOI18N

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.CENTER);
        jTabbedPane1.getAccessibleContext().setAccessibleName("Biograf�a");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNewPostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewPostActionPerformed
        String text = JOptionPane.showInputDialog("Introduce o texto da publicaci�n");

        if (text != null) {
            profileController.newPost(text, profileController.getShownProfile());
        }
    }//GEN-LAST:event_jButtonNewPostActionPerformed

    private void jButtonNewCommentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewCommentActionPerformed
        // Recupero a fila seleccionada
        int row = jTablePosts.getSelectedRow();

        if (row != -1) {
            Post post = (Post) jTablePosts.getValueAt(row, 2);
            String text = JOptionPane.showInputDialog("Introduce o texto do comentario");

            if (text != null) {
                profileController.newComment(post, text);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debes seleccionar unha publicaci�n", "Atenci�n", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonNewCommentActionPerformed

    private void jButtonNewLikeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewLikeActionPerformed
        // Recupero a fila seleccionada
        int row = jTablePosts.getSelectedRow();

        if (row != -1) {
            Post post = (Post) jTablePosts.getValueAt(row, 2);
            profileController.newLike(post);
        } else {
            JOptionPane.showMessageDialog(this, "Debes seleccionar unha publicaci�n", "Atenci�n", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonNewLikeActionPerformed

    private void jButtonShowLastPostsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonShowLastPostsActionPerformed
        int numberPosts = profileController.getPostsShowed();

        if (numberPosts != Integer.MIN_VALUE) {
            postsShowed = numberPosts;
            profileController.reloadProfile();
        }
    }//GEN-LAST:event_jButtonShowLastPostsActionPerformed

    private void jButtonChangeStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChangeStatusActionPerformed
        String status = JOptionPane.showInputDialog("Introduce o teu novo estado:");

        if (status != null) {
            profileController.updateProfileStatus(status);
        }
    }//GEN-LAST:event_jButtonChangeStatusActionPerformed

    private void jButtonCloseSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseSesionActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonCloseSesionActionPerformed

    private void jButtonSendMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSendMessageActionPerformed
        String message = JOptionPane.showInputDialog("Introduce o texto da mensaxe:");

        if (message != null) {
            int row = jTableFriends.getSelectedRow();

            if (row != -1) {
                Profile destProfile = (Profile) jTableFriends.getValueAt(row, 0);
                profileController.newMessage(destProfile, message);
            } else {
                JOptionPane.showMessageDialog(this, "Debes seleccionar unha mensaxe", "Atenci�n", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButtonSendMessageActionPerformed

    private void jButtonReadMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReadMessageActionPerformed
        int row = jTableMessages.getSelectedRow();

        if (row != -1) {
            Message message = (Message) jTableMessages.getValueAt(row, 3);

            profileController.markMessageAsRead(message);

            String from = "De: " + message.getSourceProfile();
            String date = "Data: " + formatter.format(message.getDate());
            String text = "Texto:";
            String contetnText = message.getText();

            JPanel panel = new JPanel(new GridLayout(4, 1, 5, 5));
            JLabel labelFrom = new JLabel(from);
            JLabel labelDate = new JLabel(date);
            JLabel labelText = new JLabel(text);
            JLabel labelContent = new JLabel(contetnText);

            panel.add(labelFrom);
            panel.add(labelDate);
            panel.add(labelText);
            panel.add(labelContent);

            int option = JOptionPane.showOptionDialog(this, panel, "Ler mensaxe", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[]{"Volver", "Eliminar", "Responder"}, 0);

            switch (option) {
                case 1:
                    jButtonDeleteMessageActionPerformed(null);
                    break;
                case 2:
                    String messageSend = JOptionPane.showInputDialog("Introduce o texto da mensaxe:");

                    if (messageSend != null) {
                        profileController.newMessage(message.getSourceProfile(), messageSend);
                    }
                    break;
            }

        } else {
            JOptionPane.showMessageDialog(this, "Debes seleccionar unha mensaxe", "Atenci�n", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonReadMessageActionPerformed

    private void jButtonDeleteMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteMessageActionPerformed
        int row = jTableMessages.getSelectedRow();

        if (row != -1) {
            Message message = (Message) jTableMessages.getValueAt(row, 3);
            profileController.deleteMessage(message);
        } else {
            JOptionPane.showMessageDialog(this, "Debes seleccionar unha mensaxe", "Atenci�n", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonDeleteMessageActionPerformed

    private void jButtonAceptFriendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptFriendActionPerformed
        int selected = jListFriendshipRequest.getSelectedIndex();

        if (selected != -1) {
            Profile profile = FriendShipArrayList.get(selected);
            FriendShipArrayList.remove(selected);

            profileController.acceptFriendshipRequest(profile);
        } else {
            JOptionPane.showMessageDialog(this, "Debes seleccionar unha solicitude de amizade", "Atenci�n", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAceptFriendActionPerformed

    private void jButtonRejectFriendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRejectFriendActionPerformed
        int selected = jListFriendshipRequest.getSelectedIndex();
        if (selected != -1) {
            Profile profile = FriendShipArrayList.get(selected);
            FriendShipArrayList.remove(selected);

            profileController.rejectFriendshipRequest(profile);
        } else {
            JOptionPane.showMessageDialog(this, "Debes seleccionar unha solicitude de amizade", "Atenci�n", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonRejectFriendActionPerformed

    private void jButtonNewFriendShipRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewFriendShipRequestActionPerformed
        String nameProfile = JOptionPane.showInputDialog("Introduce o nome do perfil ao que queres enviar a solicitude:");

        if (nameProfile != null) {
            profileController.newFriendshipRequest(nameProfile);
        }
    }//GEN-LAST:event_jButtonNewFriendShipRequestActionPerformed

    private void jButtonShowBiographyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonShowBiographyActionPerformed
        int row = jTableFriends.getSelectedRow();

        if (row != -1) {
            Profile profile = (Profile) jTableFriends.getValueAt(row, 0);
            profileController.setShownProfile(profile);
        } else {
            JOptionPane.showMessageDialog(this, "Debes seleccionar un amig@", "Atenci�n", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonShowBiographyActionPerformed

    private void jButtonBackBiographyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackBiographyActionPerformed
        //O usuario da sesi�n volve a ver o seu perfil
        profileController.setShownProfile(profileController.getSessionProfile());
    }//GEN-LAST:event_jButtonBackBiographyActionPerformed

    @Override
    public int getPostsShowed() {
        String numberPostsText = JOptionPane.showInputDialog("Introduce o texto do comentario");
        int numberPosts = Integer.MIN_VALUE;

        if (numberPostsText != null) {
            try {
                numberPosts = Integer.parseInt(numberPostsText);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Debes introducir un n�mero", "Atenci�n", JOptionPane.WARNING_MESSAGE);
            }
        }

        return numberPosts;
    }

    @Override
    public void showProfileMenu(Profile profile) {
        Profile sesionProfile = profileController.getSessionProfile();
        Profile shownProfile = profileController.getShownProfile();

        //Vexo se o usuario que inicia a sesi�n � o mesmo que o perfil que est� vendo
        boolean equalsProfile = sesionProfile.getName().equals(shownProfile.getName());

        // Mostro cando non coinciden os perfis
        jButtonSendMessageFooter.setVisible(!equalsProfile);
        jButtonBackBiography.setVisible(!equalsProfile);
        
        //Mostro cando coinciden os perfis
        jButtonChangeStatus.setVisible(equalsProfile);
        jPanelSurBiografia.setVisible(equalsProfile);
        jPanelButtonsFriends.setVisible(equalsProfile);
        jTabbedPane1.setEnabledAt(2, equalsProfile);

        //Cambio o contido da cabeceira
        jLabelUserProfile.setText(profile.getName());
        jLabelStatusUser.setText(profile.getStatus());
        jLabelPostShowed.setText(Integer.toString(postsShowed));

        //Actualizar tabla de posts
        ArrayList<Post> posts = profile.getPosts();
        DefaultTableModel modelPosts = (DefaultTableModel) jTablePosts.getModel();
        modelPosts.setRowCount(0);

        for (int i = 0; i < posts.size() && i < postsShowed && !posts.isEmpty(); i++) {
            Post post = posts.get(i);
            modelPosts.addRow(new Object[]{
                formatter.format(post.getDate()),
                post.getAuthor(),
                post,
                post.getProfileLikes().size()});
        }

        //Limpiar a tabla de comentarios
        DefaultTableModel myModel = (DefaultTableModel) jTableComments.getModel();
        myModel.setRowCount(0);

        //Actualizar a tabla de amigos
        ArrayList<Profile> friends = profile.getFriends();
        DefaultTableModel modelFriends = (DefaultTableModel) jTableFriends.getModel();
        modelFriends.setRowCount(0);

        for (Profile friend : friends) {
            modelFriends.addRow(new Object[]{
                friend,
                friend.getStatus()});
        }

        //Actualizar a lista de amizades
        ArrayList<Profile> friendsRequest = profile.getFriendshipRequests();
        String[] TextRequests = new String[friendsRequest.size()];

        for (int i = 0; i < friendsRequest.size(); i++) {
            Profile friendShip = friendsRequest.get(i);
            FriendShipArrayList.add(friendShip);

            String text = friendShip + " quere establecer amizade contigo.";
            TextRequests[i] = text;
        }

        jListFriendshipRequest.setListData(TextRequests);

        //Cargo as mensaxes privadas
        ArrayList<Message> messages = profile.getMessages();
        DefaultTableModel modelMessages = (DefaultTableModel) jTableMessages.getModel();
        modelMessages.setRowCount(0);
        
        boolean notReadMessages = false;

        for (Message message : messages) {
            notReadMessages = true;
            modelMessages.addRow(new Object[]{
                message.isRead(),
                formatter.format(message.getDate()),
                message.getSourceProfile(),
                message
            });
        }
        
        //Po�o en negrita se hay mensaxes sen leer
        jTabbedPane1.getComponentAt(2).setFont(new Font("Liberation Sans", Font.BOLD, 15));
       
        

        //Fago a tabla visible
        setVisible(true);

    }

    @Override
    public void showProfileNotFoundMessage() {
        JOptionPane.showMessageDialog(this, "Non se atopou un perfil con ese nome!", "Error", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void showCannotLikeOwnPostMessage() {
        JOptionPane.showMessageDialog(this, "Non se pode dar me gusta a unha publicaci�n propia", "Error", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void showAlreadyLikedPostMessage() {
        JOptionPane.showMessageDialog(this, "Non se pode facer like sobre unha publicaci�n sobre a que xa se fixo like", "Error", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void showIsAlreadyFriendMessage(String profileName) {
        JOptionPane.showMessageDialog(this, "Xa tes amizade con " + profileName, "Error", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void showExistsFrienshipRequestMessage(String profileName) {
        JOptionPane.showMessageDialog(this, profileName + " xa che enviou unha solicitude de amizade!", "Error", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void showDuplicateFrienshipRequestMessage(String profileName) {
        JOptionPane.showMessageDialog(this, "Xa tes unha solicitude de amizade con " + profileName, "Error", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void showConnectionErrorMessage() {
        JOptionPane.showMessageDialog(this, "Erro na conexi�n co almac�n de datos!", "Error", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void showReadErrorMessage() {
        JOptionPane.showMessageDialog(this, "Erro na lectura de datos!", "Error", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void showWriteErrorMessage() {
        JOptionPane.showMessageDialog(this, "Erro na escritura dos datos!", "Error", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void showNotFriendshipYourself() {
        JOptionPane.showMessageDialog(this, "Non se pode establecer amizade contigo mesmo!", "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptFriend;
    private javax.swing.JButton jButtonBackBiography;
    private javax.swing.JButton jButtonChangeStatus;
    private javax.swing.JButton jButtonCloseSesion;
    private javax.swing.JButton jButtonDeleteMessage;
    private javax.swing.JButton jButtonNewComment;
    private javax.swing.JButton jButtonNewFriendShipRequest;
    private javax.swing.JButton jButtonNewLike;
    private javax.swing.JButton jButtonNewPost;
    private javax.swing.JButton jButtonReadMessage;
    private javax.swing.JButton jButtonRejectFriend;
    private javax.swing.JButton jButtonSendMessage;
    private javax.swing.JButton jButtonSendMessageFooter;
    private javax.swing.JButton jButtonShowBiography;
    private javax.swing.JButton jButtonShowLastPosts;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelPostShowed;
    private javax.swing.JLabel jLabelStatusUser;
    private javax.swing.JLabel jLabelTacebookLogo;
    private javax.swing.JLabel jLabelUserProfile;
    private javax.swing.JList<String> jListFriendshipRequest;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanelAmigos;
    private javax.swing.JPanel jPanelBiografia;
    private javax.swing.JPanel jPanelButtonsFriends;
    private javax.swing.JPanel jPanelFooter;
    private javax.swing.JPanel jPanelHeader;
    private javax.swing.JPanel jPanelMensaxes;
    private javax.swing.JPanel jPanelNorte;
    private javax.swing.JPanel jPanelNorte1;
    private javax.swing.JPanel jPanelSur;
    private javax.swing.JPanel jPanelSurBiografia;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSplitPane jSplitBiografia;
    private javax.swing.JSplitPane jSplitBiografia1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableComments;
    private javax.swing.JTable jTableFriends;
    private javax.swing.JTable jTableMessages;
    private javax.swing.JTable jTablePosts;
    // End of variables declaration//GEN-END:variables
}