/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businessLogic;

/**
 *
 * @author franc
 */
public class Usuario {
    
    private String Usuario;
    private String passWord;
    private String nombreApellido;

    public Usuario(String Usuario, String passWord, String nombreApellido) {
        this.Usuario = Usuario;
        this.passWord = passWord;
        this.nombreApellido = nombreApellido;
    }
    
    
    
    
    //---------- getters y setters--------------
    public String getUsuario() {
        return Usuario;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }
    
    

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    @Override
    public String toString() {
        return "Usuario{" + "Usuario=" + Usuario + ", passWord=" + passWord + ", nombreApellido=" + nombreApellido + '}';
    }
    
    
            
    
}
