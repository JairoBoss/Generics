/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Main.Main;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author megabit
 */
public class Ganador extends JDialog {

    private JLabel lblGanador;
    private java.sql.Connection connection;
    private Statement st;
    private ResultSet rs;

    public Ganador(JFrame parent) throws SQLException {
        super(parent, true);
        super.setTitle("Ganador");
//        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(200, 200);

        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "postgres", "321");
            this.st = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        lblGanador = new JLabel(ganador());

        super.add(lblGanador);

    }
    
    public String ganador() throws SQLException{
        int mayor = 0;
        String pGanador ="";
        try {
            rs = this.st.executeQuery("select * from planillaTemporal");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        while (rs.next()) {
            if (rs.getInt(2) > mayor) {
                mayor = rs.getInt(2);
                pGanador = rs.getString(1);
            }
        }
        return (String.format("Gano el partido %s, con un total de %d votos",pGanador,mayor));
    }

}