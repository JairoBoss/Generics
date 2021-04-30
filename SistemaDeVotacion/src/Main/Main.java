/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Gui.MainFrame;
import Model.Domicilio;
import Model.Votante;
import com.sun.jdi.connect.spi.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author megabit
 */
public class Main {

    private java.sql.Connection connection;
    private Statement st;
    private ResultSet rs;

    public Main() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "postgres", "321");
            this.st = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    public void mostrarElementos() throws SQLException {
        try {
            rs = this.st.executeQuery("select * from planillaTemporal");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        while (rs.next()) {
            System.out.println(String.format("Partido %s, NoVotos %d", rs.getString(1), rs.getInt(2)));
        }
    }
    
    public void añadirVoto(String partido){
        try {            
            this.st.executeUpdate(String.format("update planillaTemporal set novotos = novotos + 1 where partido = '%s'", partido));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
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
    
    public static void main(String[] args) throws SQLException {
        Main a = new Main();
        
        a.ganador();
        a.mostrarElementos();
        
        new MainFrame();
    }
}
