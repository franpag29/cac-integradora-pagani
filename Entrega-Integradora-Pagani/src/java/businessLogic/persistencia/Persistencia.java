/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businessLogic.persistencia;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author franc
 */
public class Persistencia {

    private Connection coneccion;
    private ResultSet resultados;
    private PreparedStatement declaracionLista;
    private ResultSetMetaData resultadosDatos;

    

    private String servidor, baseDeDatos, usuario, clave, ejecutar;

    public Connection conectarse() {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            servidor = "localhost:3306/";
            baseDeDatos = "cacintegradora";
            usuario = "root";
            clave = "";
            
                coneccion = DriverManager.getConnection("jdbc:mysql://" + servidor +
                        baseDeDatos+"?autoReconnect=true&useSSL=false"
                        ,usuario, clave);
             

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return coneccion;
    }
    
    
    //************************************************************************************//
    
    public ResultSet consultaSQL(String busqueda){
        
        try {
            declaracionLista= conectarse().prepareStatement(busqueda);
            resultados=declaracionLista.executeQuery();
            resultadosDatos=resultados.getMetaData();
        } catch (SQLException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultados;
    }
    
    public void ejecutarSQL(String orden){
        
        try {
            Statement sentencia= conectarse().createStatement();
            sentencia.executeLargeUpdate(orden);
        } catch (SQLException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      
    }
    
   
    
   

    //------- GETTERS Y SETTERS
    public Connection getConeccion() {
        return coneccion;
    }

    public void setConeccion(Connection coneccion) {
        this.coneccion = coneccion;
    }

    public void setResultados(ResultSet resultados) {
        this.resultados = resultados;
    }

    public void setDeclaracionLista(PreparedStatement declaracionLista) {
        this.declaracionLista = declaracionLista;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
    }

    public void setBaseDeDatos(String baseDeDatos) {
        this.baseDeDatos = baseDeDatos;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setEjecutar(String ejecutar) {
        this.ejecutar = ejecutar;
    }

    public ResultSet getResultados() {
        return resultados;
    }

    public PreparedStatement getDeclaracionLista() {
        return declaracionLista;
    }

    public String getServidor() {
        return servidor;
    }

    public String getBaseDeDatos() {
        return baseDeDatos;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getClave() {
        return clave;
    }

    public String getEjecutar() {
        return ejecutar;
    }
    
    public ResultSetMetaData getResultadosDatos() {
        return resultadosDatos;
    }
}
