/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summercoding.bank.controlleur;

import com.summerconding.bank.entities.Admin;
import com.summerconding.bank.entities.Compte;
import com.summerconding.bank.entities.Utilisateur;
import com.summerconding.bank.gestionnaires.GestionnaireAdmin;
import com.summerconding.bank.gestionnaires.GestionnaireCompte;
import com.summerconding.bank.gestionnaires.GestionnaireUtilisateur;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author mbeyo
 */
public class Controleur {
    GestionnaireAdmin gestionnaireAdmin = new GestionnaireAdmin();
    
    GestionnaireUtilisateur gestionnaireUtilisateur = new GestionnaireUtilisateur();
    
    GestionnaireCompte gestionnaireCompte = new GestionnaireCompte();
    
    
    
    public Admin routeVersLogin(String login, String pwd) throws ClassNotFoundException, SQLException{
        
        return gestionnaireAdmin.login(login , pwd);
    }
    
    
     public void routeVersSaveAdmin(String login, String pwd, String nom) throws ClassNotFoundException, SQLException{
        
         gestionnaireAdmin.saveAdmin(login , pwd,nom);
    }
     
     
     
     
     
     public void routeVersSaveUtilisateur(  String login, String password, String nom, String prenom, LocalDate datenaiss, String genre, int idadmin) throws ClassNotFoundException, SQLException{
         
         gestionnaireUtilisateur.saveUtilisateur(login, password, nom, prenom, datenaiss, genre, idadmin);
        }
     
         
    public List<Admin> routeVersListAllAdmin() throws ClassNotFoundException, SQLException{
        
        return gestionnaireAdmin.listAllAdmin();
    }
    
    
    public void routeVersSaveCompte(double solde, int idadmin, int iduser) throws ClassNotFoundException, SQLException{
        
        gestionnaireCompte.saveCompte(solde,iduser,idadmin);
    }
    
    public List<Utilisateur> routeVersListUtilisateur() throws ClassNotFoundException, SQLException{
        
        return gestionnaireUtilisateur.listAllUtilisateur();
        
    }
}

