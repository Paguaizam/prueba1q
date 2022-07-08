
package com.mycompany.practicapaul;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Paul Aguaiza
 */
public class MainWindow extends JFrame implements ActionListener {

    private JPanel configPanel;
    private JPanel dimensionPanel;
    private JPanel buttonsPanel;
    private JPanel formColorPanel;
    private DrawPanel drawPanel;
    private ArrayList<JLabel> labelList;
    private JComboBox jComboBoxFigure;
    private JComboBox jComboBoxColors;
    private JButton jButtonDraw;
    private JButton jButtonClear;

    public MainWindow(String title) {
        super(title);
        this.setSize(700, 800);
        this.setLocationRelativeTo(this);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        initComponents();
        jButtonDraw.addActionListener(this);
        jButtonClear.addActionListener(this);

    }

    private void initComponents() {

        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        configPanel = new JPanel();
        configPanel.setBorder(new TitledBorder("Configuracion"));
        formColorPanel = new JPanel();
        dimensionPanel = new JPanel();
        buttonsPanel = new JPanel();

        drawPanel = new DrawPanel(new Figure(0, Color.YELLOW, 0, 0));
        drawPanel.setBorder(new TitledBorder("Dibujo"));
        drawPanel.setPreferredSize(new Dimension(300, 600));
        drawPanel.setBackground(Color.WHITE);

        getContentPane().add(configPanel);
        configPanel.add(formColorPanel);
        configPanel.add(dimensionPanel);
        configPanel.add(buttonsPanel);

        getContentPane().add(drawPanel);

        initLabels();
        initComboBox();
        initButtons();
        setPanels();

    }

    private void setPanels() {
        formColorPanel.add(labelList.get(0));
        formColorPanel.add(jComboBoxFigure);
        formColorPanel.add(labelList.get(1));
        formColorPanel.add(jComboBoxColors);

        buttonsPanel.add(jButtonDraw);
        buttonsPanel.add(jButtonClear);

    }

    private void initLabels() {
        labelList = new ArrayList<>();

        labelList.add(new JLabel("Seleccionar Figura"));
        labelList.add(new JLabel("Seleccionar Color"));

    }

    private void initComboBox() {

        jComboBoxColors = new JComboBox();
        jComboBoxFigure = new JComboBox();

        jComboBoxFigure.addItem("Linea1");
        jComboBoxFigure.addItem("Linea2");
        jComboBoxFigure.addItem("Linea3");

        jComboBoxColors.addItem("Azul");
        jComboBoxColors.addItem("Rojo");
        jComboBoxColors.addItem("Verde");

    }

    private void initButtons() {
        jButtonClear = new JButton("Limpiar");
        jButtonDraw = new JButton("Dibujar");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (jButtonDraw == e.getSource()) {
            getData();
            getColors();
            JOptionPane.showMessageDialog(this, "Click en la pantalla para dibujar la figura");
        }else{
            drawPanel.repaint();
        }

    }

    private void getData() {
        drawPanel.getFigura().setFigura(jComboBoxFigure.getSelectedIndex());
    }

    private void getColors() {
       
        if (jComboBoxColors.getSelectedItem().equals("Azul")) {
            drawPanel.getFigura().setColor(Color.BLUE);
        }
        if (jComboBoxColors.getSelectedItem().equals("Rojo")) {
            drawPanel.getFigura().setColor(Color.RED);
        }
        if (jComboBoxColors.getSelectedItem().equals("Verde")) {
            drawPanel.getFigura().setColor(Color.GREEN);
        }
    }

}
