/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import Main.Main;
import java.sql.SQLException;

/**
 *
 * @author megabit
 */
public class MainFrame extends JFrame {

    private JButton pri;
    private JButton prd;
    private JButton pan;
    private JButton morena;
    private JButton resultado;

    private Main votacion;
    private Ganador gana;

    public MainFrame() throws SQLException {

        super("Votos");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(416, 473);

        votacion = new Main();

        pri = new JButton("PRI");
        pri.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                votacion.añadirVoto("PRI");
                //System.exit(0);
            }
        });

        prd = new JButton("PRD");
        prd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                votacion.añadirVoto("PRD");
                //System.exit(0);
            }
        });

        pan = new JButton("PAN");
        pan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                votacion.añadirVoto("PAN");
                //System.exit(0);
            }
        });

        morena = new JButton("MORENA");
        morena.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                votacion.añadirVoto("MORENA");
                //System.exit(0);
            }
        });

        gana = new Ganador(this);

        resultado = new JButton("Resultado");
        resultado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                gana.setVisible(true);
                System.exit(0);

            }
        });

        super.add(pri);
        super.add(prd);
        super.add(pan);
        super.add(morena);
        super.add(resultado);

        GridLayout gridLayout = new GridLayout(5, 1);
        gridLayout.setHgap(10);
        gridLayout.setVgap(40);
        this.setLayout(gridLayout);

        super.setVisible(true);
    }
}
