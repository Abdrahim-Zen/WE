/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.univaq.Test;

import it.univaq.webmarket.framework.security.SecurityHelpers;

/**
 *
 * @author abrah
 */
public class generatore {
    
    public static void main(String[] args) throws Exception {
        String password = "userpass3"; // la password che vuoi dare all'utente zero
        String hash = SecurityHelpers.getPasswordHashPBKDF2(password);
        System.out.println("Hash da salvare nel DB: " + hash);
    }
    
}
