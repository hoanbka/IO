package student.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class GUI extends Frame implements ActionListener {
    private Frame mainFrame = new Frame("");
    private Frame addFrame = new Frame("Add Student");
    private Frame removeFrame = new Frame("Remove student");
    private Frame findbyIDFrame = new Frame("Find student by ID");

    private Button addBtn;
    private Button removeBtn;
    private Button findStdByIDBtn;
    private Button findStdByNameBtn;
    private Button writeToBinaryFile;
    private Button writeToTextFile;
    private Button readFromBinaryFileBtn;
    private Button readFromTextFileBtn;
    private Button showStdBtn;
    private Button closeMainBtn;
    private Button closeAddBtn;
    private Button clearAddBtn;
    private Button closeRemoveBtn;
    private Button closeFindBtn;
    private Button clearFindBtn;


    private Label nameLable;
    private Label ageLable;
    private Label idLable;
    private Label idFindLable;

    private TextField nameTxt;
    private TextField ageTxt;
    private TextField idTxt;
    private TextField idFindTxt;

    private int addCount = 0;
    private int addStdCount = 0;
    private int removeStdCount = 0;
    private int removeCount = 0;
    private int writeToTxtCount = 0;
    private int findByIDCount = 0;
    private int findCount = 0;


    StudentManager stdMng = new StudentManager();
    List<Student> students = stdMng.getStudents();

    public GUI() {
        mainFrame.setLayout(new FlowLayout());
        mainFrame.setTitle("Student Information System");
        mainFrame.setSize(350, 200);
        mainFrame.setBackground(Color.cyan);
        mainFrame.setVisible(true);

        addBtn = new Button("Add Student");
        mainFrame.add(addBtn);
        addBtn.addActionListener(this);

        removeBtn = new Button("Remove student");
        mainFrame.add(removeBtn);
        removeBtn.addActionListener(this);

        closeMainBtn = new Button("Close");
        mainFrame.add(closeMainBtn);
        closeMainBtn.addActionListener(this);

        writeToBinaryFile = new Button("writeToBinaryFile");
        mainFrame.add(writeToBinaryFile);
        writeToBinaryFile.addActionListener(this);

        writeToTextFile = new Button("writeToTextFile");
        mainFrame.add(writeToTextFile);
        writeToTextFile.addActionListener(this);

        findStdByIDBtn = new Button("FindByID");
        mainFrame.add(findStdByIDBtn);
        findStdByIDBtn.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addBtn) {
            addStdCount++;
            mainFrame.setVisible(false);

            addFrame.setLayout(new FlowLayout());
            addFrame.setTitle("Add student");
            addFrame.setSize(500, 200);
            addFrame.setBackground(Color.cyan);
            addFrame.setVisible(true);
            if (addStdCount == 1) {

                nameLable = new Label("NAME");
                nameLable.setAlignment(Label.LEFT);
                nameLable.setBackground(Color.GRAY);
                addFrame.add(nameLable);


                nameTxt = new TextField(10);
                addFrame.add(nameTxt);

                ageLable = new Label("AGE");
                ageLable.setAlignment(Label.LEFT);
                ageLable.setBackground(Color.GRAY);
                addFrame.add(ageLable);

                ageTxt = new TextField(10);
                addFrame.add(ageTxt);

                idLable = new Label("ID");
                idLable.setAlignment(Label.LEFT);
                idLable.setBackground(Color.GRAY);
                addFrame.add(idLable);

                idTxt = new TextField(10);
                addFrame.add(idTxt);

            } else {
                nameTxt.setText("");
                ageTxt.setText("");
                idTxt.setText("");
            }

            Button add = new Button("Add");
            if (addStdCount == 1) {
                addFrame.add(add);
            }

            add.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {

                    addCount++;

                    try {
                        String name = nameTxt.getText();
                        int age = Integer.parseInt(ageTxt.getText());
                        String ID = idTxt.getText();

                        if (stdMng.addStudent(new Student(name, age, ID))) {

                            JOptionPane.showMessageDialog(null, "successfully", "Message", JOptionPane.INFORMATION_MESSAGE);

                        } else {

                            JOptionPane.showMessageDialog(null, "Failed", "Message", JOptionPane.INFORMATION_MESSAGE);

                        }
                    } finally {
                        if (addCount == 1) {
                            closeAddBtn = new Button("Close");
                            addFrame.setSize(600, 200);

                            addFrame.add(closeAddBtn);
                            closeAddBtn.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    addFrame.dispose();
                                    mainFrame.setVisible(true);
                                }
                            });

                            Button clearAddBtn = new Button("Clear");
                            addFrame.add(clearAddBtn);
                            clearAddBtn.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    nameTxt.setText("");
                                    ageTxt.setText("");
                                    idTxt.setText("");
                                }
                            });
                        }
                    }

                }
            });

        } else if (e.getSource() == removeBtn)

        {
            removeStdCount++;
            mainFrame.setVisible(false);

            Button remove = new Button("Remove");
            removeFrame.setLayout(new FlowLayout());
            removeFrame.setTitle("Remove Student");
            removeFrame.setSize(300, 200);
            removeFrame.setBackground(Color.cyan);
            removeFrame.setVisible(true);

            if (removeStdCount == 1) {

                Label idLable = new Label("ID");
                idLable.setAlignment(Label.LEFT);
                idLable.setBackground(Color.GRAY);
                removeFrame.add(idLable);

                idTxt = new TextField(10);
                removeFrame.add(idTxt);

                removeFrame.add(remove);
            } else {
                idTxt.setText("");
            }
            remove.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    removeCount++;
                    String removedID = idTxt.getText();

                    int reply = JOptionPane.showConfirmDialog(null, "OK?", "message", JOptionPane.YES_NO_OPTION);
                    if (reply == JOptionPane.YES_OPTION) {
                        if (stdMng.removeStudent(removedID)) {
                            JOptionPane.showMessageDialog(null, "successfully", "Message", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "failed", "Message", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    if (removeCount == 1) {
                        closeRemoveBtn = new Button("Close");
                        removeFrame.setSize(500, 200);

                        removeFrame.add(closeRemoveBtn);
                        closeRemoveBtn.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                removeFrame.dispose();
                                mainFrame.setVisible(true);
                            }
                        });

                        clearAddBtn = new Button("Clear");
                        removeFrame.add(clearAddBtn);
                        clearAddBtn.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                idTxt.setText("");
                            }
                        });
                    }
                }
            });
        } else if (e.getSource() == closeMainBtn) {

            mainFrame.dispose();

        } else if (e.getSource() == writeToBinaryFile) {


        } else if (e.getSource() == writeToTextFile) {

            writeToTxtCount++;
            try {
                StudentDataAccess.writeToTextFile(students);
                JOptionPane.showMessageDialog(null, "successfully", "Message", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e1) {
                JOptionPane.showMessageDialog(null, "failed", "Message", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (e.getSource() == findStdByIDBtn) {
            mainFrame.setVisible(false);

            findByIDCount++;

            findStdByIDBtn = new Button("Find");
            findbyIDFrame.setLayout(new FlowLayout());
            findbyIDFrame.setTitle("Find the student by ID");
            findbyIDFrame.setSize(300, 200);
            findbyIDFrame.setBackground(Color.cyan);
            findbyIDFrame.setVisible(true);
            if (findByIDCount == 1) {
                idFindLable = new Label("ID");
                idFindLable.setAlignment(Label.LEFT);
                idFindLable.setBackground(Color.GRAY);
                findbyIDFrame.add(idFindLable);

                idFindTxt = new TextField(10);
                findbyIDFrame.add(idFindTxt);

                findbyIDFrame.add(findStdByIDBtn);
            } else {
                idFindTxt.setText("");
            }

            findStdByIDBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    findCount++;

                    String findID = idFindTxt.getText();
                    Student std = stdMng.findStudentByID(findID);
                    if (std != null) {

                        JOptionPane.showMessageDialog(null, std.toString(), "Message", JOptionPane.INFORMATION_MESSAGE);
                    } else {

                        JOptionPane.showMessageDialog(null, "No such student", "Message", JOptionPane.INFORMATION_MESSAGE);
                    }

                    if (findCount == 1) {
                        closeFindBtn = new Button("Close");
                        findbyIDFrame.setSize(500, 200);

                        findbyIDFrame.add(closeFindBtn);
                        closeFindBtn.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                findbyIDFrame.dispose();
                                mainFrame.setVisible(true);
                            }
                        });

                        clearFindBtn = new Button("Clear");
                        findbyIDFrame.add(clearFindBtn);
                        clearFindBtn.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                idFindTxt.setText("");
                            }
                        });
                    }
                }

            });

        }
    }

    public static void main(String[] args) {
        try {
            new GUI();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

