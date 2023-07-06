/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summerconding.bank.gestionnaires;

import com.summerconding.bank.entities.Admin;
import com.summerconding.bank.entities.Utilisateur;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author mbeyo
 */
public class GestionnaireUtilisateur {
    
    private Utilisateur utilisateur = new Utilisateur();

   /* public Utilisateur login(String login, int pwd) throws ClassNotFoundException, SQLException{
        
        return utilisateur.getByLoginAndPassword(login, pwd);
    }*/

    public void saveUtilisateur( String login, String password, String nom, String prenom, LocalDate datenaiss, String genre, int idadmin) throws ClassNotFoundException, SQLException {
        
        utilisateur.save(login, password, nom, prenom, datenaiss, genre, idadmin);
    }   
    
    
    public List<Utilisateur> listAllUtilisateur() throws ClassNotFoundException, SQLException{
     
     return utilisateur.getAllUtilisateur();
}
   
    
}
