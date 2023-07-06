/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.summerconding.bank.entities;

import com.summercoding.bank.utils.JDBC;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mbeyo
 */
public class Admin {

    int idadmin;

    String login;

    String password;
 
    String nom;

public void save( String login, String password, String nom) throws ClassNotFoundException, SQLException{
  String command = "INSERT INTO `admin` ( `login`, `password`, `nom`) VALUES (?,?,?)";

  PreparedStatement addstmt = JDBC.getConnexion().prepareStatement(command);
  addstmt.setObject(1,login);
  addstmt.setObject(2,password);
  addstmt.setObject(3,nom);
  addstmt.execute();
}

    public int getIdadmin() {
        return idadmin;
    }

    public void setIdadmin(int idadmin) {
        this.idadmin = idadmin;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Admin() {
    }

    public Admin(int idadmin, String login, String password, String nom) {
        this.idadmin = idadmin;
        this.login = login;
        this.password = password;
        this.nom = nom;
    }
    

 
    
     public Admin getOne(int idadmin) throws SQLException, ClassNotFoundException {
    
       String cmd = "select* from admin where idadmin = ?";

       PreparedStatement stmt = JDBC.getConnexion().prepareStatement(cmd);

       stmt.setObject(1,idadmin);

       ResultSet rs=stmt.executeQuery();

       while(rs.next()){
           return new Admin(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
    }
      return null;
}

     public Admin getByLoginAndPassword(String login, String password) throws ClassNotFoundException, SQLException{
    
       String cmd = "select * from admin where login = ? and password= ?";

       PreparedStatement stmt = JDBC.getConnexion().prepareStatement(cmd);

       stmt.setObject(1,login);
       stmt.setObject(2,password);

       ResultSet rs=stmt.executeQuery();

       while(rs.next()){
           return new Admin(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
        }
      return null;
    }

    public List<Admin> getAllAdmin() throws ClassNotFoundException, SQLException{
    
       String cmd = "select* from admin";

       PreparedStatement stmt = JDBC.getConnexion().prepareStatement(cmd);

       ResultSet rs=stmt.executeQuery();

       List<Admin> listAdmin = new ArrayList<>();

       while(rs.next()){
           listAdmin.add(new Admin(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
    }
      return listAdmin;
    }

    public void update( int idadmin, String login, String password, String nom) throws ClassNotFoundException, SQLException{
  String command = "UPDATE `admin` SET `login` =? , `password` =? , `nom` =? WHERE `admin`.`idadmin` =? ";

  PreparedStatement addstmt = JDBC.getConnexion().prepareStatement(command);
  addstmt.setObject(1,login);
  addstmt.setObject(2,password);
  addstmt.setObject(3,nom);
  addstmt.setObject(4,idadmin);
  addstmt.execute();
}

    public void delete( int idadmin) throws ClassNotFoundException, SQLException{
  String command = "  DELETE FROM `admin` WHERE `admin`.`idadmin` = ? ";

  PreparedStatement addstmt = JDBC.getConnexion().prepareStatement(command);
 
  addstmt.setObject(1,idadmin);
  addstmt.execute();
}

    @Override
    public String toString() {
        return "Admin{" + "idadmin=" + idadmin + ", login=" + login + ", password=" + password + ", nom=" + nom + '}';
    }



   public static void main(String arg[]) throws SQLException, ClassNotFoundException {

     Admin admin = new Admin();
     String result= admin.getOne(1).toString();
     System.out.println(result);
     
     result = admin.getByLoginAndPassword("toto","toto").toString();
     System.out.println(result);

     result = admin.getAllAdmin().toString();
     System.out.println(result);

      /*Admin admin  = new Admin();
         admin.save("zozo","zozo","zozo");*/

}

 }

   