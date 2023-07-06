/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summerconding.bank.gestionnaires;

import com.summerconding.bank.entities.Compte;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author mbeyo
 */
public class GestionnaireCompte {
    
    private Compte compte = new Compte();
    
    
    public void saveCompte( double solde,int iduser,int idadmin) throws ClassNotFoundException, SQLException{
        
        compte.save(solde,iduser,idadmin);
    }
    
    /*public List<Compte> listAllCompte() throws ClassNotFoundException, SQLException{
        
        return compte.getAllCompte();
    }*/
    
}