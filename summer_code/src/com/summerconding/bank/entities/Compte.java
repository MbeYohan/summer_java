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
public class Compte {

     int idcompte;
      double solde;
      int iduser;
       int idadmin;

    

   

    public int getIdcompte() {
        return idcompte;
    }

    public void setIdcompte(int idcompte) {
        this.idcompte = idcompte;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public int getIdadmin() {
        return idadmin;
    }

    public void setIdadmin(int idadmin) {
        this.idadmin = idadmin;
    }


public void save( double solde, int iduser, int idadmin) throws ClassNotFoundException, SQLException{
         String command = "INSERT INTO `compte` (`solde`, `iduser`, `idadmin`) VALUES (?,?,?)";

        PreparedStatement addstmt = JDBC.getConnexion().prepareStatement(command);
        addstmt.setObject(1,solde);
        addstmt.setObject(2,iduser);
        addstmt.setObject(3,idadmin);

        addstmt.execute();
}

    public Compte(int idcompte, double solde, int iduser, int idadmin) {
        this.idcompte = idcompte;
        this.solde = solde;
        this.iduser = iduser;
        this.idadmin = idadmin;
    }

    public Compte() {
    }


    public Compte getOne(int idcompte) throws SQLException, ClassNotFoundException {
    
       String cmd = "select* from compte where idcompte = ?";

       PreparedStatement stmt = JDBC.getConnexion().prepareStatement(cmd);

       stmt.setObject(1,idcompte);

       ResultSet rs=stmt.executeQuery();

       while(rs.next()){
           return new Compte(rs.getInt(1),rs.getDouble(2),rs.getInt(3),rs.getInt(4));
    }
      return null;
}
    
     public List<Compte> getAllCompte() throws ClassNotFoundException, SQLException{
    
       String cmd = "select* from compte";

       PreparedStatement stmt = JDBC.getConnexion().prepareStatement(cmd);

       ResultSet rs=stmt.executeQuery();

       List<Compte> listCompte = new ArrayList<>();

       while(rs.next()){
           listCompte.add(new Compte(rs.getInt(1),rs.getDouble(2),rs.getInt(3),rs.getInt(4)));
    }
      return listCompte;
    }
     
     public void update( int idcompte,double solde, int iduser, int idadmin) throws ClassNotFoundException, SQLException{
  String command = "UPDATE `compte` SET `solde` = ? WHERE `compte`.`idcompte` =? ";

  PreparedStatement addstmt = JDBC.getConnexion().prepareStatement(command);
  addstmt.setObject(1,solde);
  addstmt.setObject(2,iduser);
  addstmt.setObject(3,idadmin);
  addstmt.execute();
}
     
      public void delete( int idcompte) throws ClassNotFoundException, SQLException{
  String command = "DELETE FROM `compte` WHERE `compte`.`idcompte` = ? ";

  PreparedStatement addstmt = JDBC.getConnexion().prepareStatement(command);
 
  addstmt.setObject(1,idcompte);
  addstmt.execute();
}

    @Override
    public String toString() {
        return "Compte{" + "idcompte=" + idcompte + ", solde=" + solde + ", iduser=" + iduser + ", idadmin=" + idadmin + '}';
    }

    
     public static void main(String arg[]) throws ClassNotFoundException, SQLException{
         /*Compte compte = new Compte();
         compte.save(1000000,1,1);*/
         
     Compte compte = new Compte();
     String result= compte.getOne(1).toString();
     System.out.println(result);
     
     result = compte.getAllCompte().toString();
     System.out.println(result);

    }
}
    
