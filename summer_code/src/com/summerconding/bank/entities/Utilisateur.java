/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.summerconding.bank.entities;

import com.summercoding.bank.utils.JDBC;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
//import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Utilisateur {
   
   int iduser;

    String login;

    String password;
 
    String nom;

    String prenom;

     LocalDate datenaiss;

    String genre;

    int idadmin;

    public Utilisateur() {
        
    }

    public Utilisateur(int iduser, String login, String password, String nom, String prenom, LocalDate datenaiss, String genre, int idadmin) {
        this.iduser = iduser;
        this.login = login;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.datenaiss = datenaiss;
        this.genre = genre;
        this.idadmin = idadmin;
    }

    
   

public void save( String login, String password, String nom, String prenom, LocalDate datenaiss, String genre, int idadmin) throws ClassNotFoundException, SQLException{
  String command = "INSERT INTO `utilisateur` ( `login`, `password`, `nom`,`prenom`, `datenaiss`, `genre`, `idadmin` ) VALUES (?,?,?,?,?,?,?)";

  PreparedStatement addstmt = JDBC.getConnexion().prepareStatement(command);
  addstmt.setObject(1,login);
  addstmt.setObject(2,password);
  addstmt.setObject(3,nom);
  addstmt.setObject(4,prenom);
  addstmt.setObject(5,datenaiss);
  addstmt.setObject(6,genre);
  addstmt.setObject(7,idadmin);

  addstmt.execute();
}

  public int getidUser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
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

     public String getPrenom() {
        return prenom;
    }

    public void setPrenomom(String prenom) {
        this.prenom = prenom;
    }

     public LocalDate getDatenaiss() {
        return datenaiss;
    }

    public void setDatenaiss( LocalDate datenaiss) {
        this.datenaiss = datenaiss;
    }

     public void setGenre(String genre) {
        this.genre = genre;
    }

     public String getGenre() {
        return genre;
    }

     public int getIdadmin() {
        return idadmin;
    }

    public void setIdadmin(int idadmin) {
        this.idadmin = idadmin;
    }

    

    
     public Utilisateur getOne(int iduser) throws SQLException, ClassNotFoundException {
    
       String cmd = "select* from utilisateur where iduser = ?";

       PreparedStatement stmt = JDBC.getConnexion().prepareStatement(cmd);

       stmt.setObject(1,iduser);

       ResultSet rs=stmt.executeQuery();

       while(rs.next()){
           return new Utilisateur(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDate(6).toLocalDate(),rs.getString(7),rs.getInt(8));
    }
      return null;
}
     
     
      public Utilisateur getByLoginAndPassword(String login, int password) throws ClassNotFoundException, SQLException{
    
       String cmd = "select * from utilisateur where login = ? and password= ?";

       PreparedStatement stmt = JDBC.getConnexion().prepareStatement(cmd);

       stmt.setObject(1,login);
       stmt.setObject(2,password);

       ResultSet rs=stmt.executeQuery();

       while(rs.next()){
           return new Utilisateur(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDate(6).toLocalDate(),rs.getString(7),rs.getInt(8));
        }
      return null;
    }
    
    
      public List<Utilisateur> getAllUtilisateur() throws ClassNotFoundException, SQLException{
    
       String cmd = "select* from utilisateur";

       PreparedStatement stmt = JDBC.getConnexion().prepareStatement(cmd);

       ResultSet rs=stmt.executeQuery();

       List<Utilisateur> listUtilisateur = new ArrayList<>();

       while(rs.next()){
           listUtilisateur.add(new Utilisateur(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDate(6).toLocalDate(),rs.getString(7),rs.getInt(8)));
    }
      return listUtilisateur;
    }
    
      
       public void update( int iduser, String login, int password, String nom, String prenom, LocalDate datenaiss, String genre, int idadmin) throws ClassNotFoundException, SQLException{
  String command = "UPDATE `utilisateur` SET `login` = ?, `password` = ?, `nom` = ?, `prenom` = ?, `datenaiss` = ? WHERE `utilisateur`.`iduser` = ? ";

  PreparedStatement addstmt = JDBC.getConnexion().prepareStatement(command);
   addstmt.setObject(1,login);
  addstmt.setObject(2,password);
  addstmt.setObject(3,nom);
  addstmt.setObject(4,prenom);
  addstmt.setObject(5,datenaiss);
  addstmt.setObject(6,genre);
  addstmt.setObject(7,idadmin);
  addstmt.execute();
}
       
       public void delete( int iduser) throws ClassNotFoundException, SQLException{
  String command = "  DELETE FROM `utilisateur` WHERE `utilisateur`.`iduser` = ? ";

  PreparedStatement addstmt = JDBC.getConnexion().prepareStatement(command);
 
  addstmt.setObject(1,iduser);
  addstmt.execute();
}

    @Override
    public String toString() {
        return "Utilisateur{" + "iduser=" + iduser + ", login=" + login + ", password=" + password + ", nom=" + nom + ", prenom=" + prenom + ", datenaiss=" + datenaiss + ", genre=" + genre + ", idadmin=" + idadmin + '}';
    }
        
     
     
    
    
    public static void main(String arg[]) throws ClassNotFoundException, SQLException{
            
     Utilisateur utilisateur = new Utilisateur();
     String result= utilisateur.getOne(1).toString();
     System.out.println(result);
     
     result = utilisateur.getByLoginAndPassword("pipi",125).toString();
     System.out.println(result);

     result = utilisateur.getAllUtilisateur().toString();
     System.out.println(result);
     
      /*Utilisateur utilisateur = new Utilisateur();
         utilisateur.save("tata",111,"tata","tata",LocalDate.of(2005,Month.APRIL,22),"feminin",1);*/

}

 
}
