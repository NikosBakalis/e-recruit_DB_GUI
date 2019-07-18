/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamysql.helper;

import javamysql.database.ICRUDImpl;
import javamysql.model.User;

/**
 *
 * @author Nikolas
 */
public class Controller {
    
    private static Controller controller;
    private final ICRUDImpl iCRUDImpl;
    
    private Controller() {
        this.iCRUDImpl = new ICRUDImpl();
        this.iCRUDImpl.openConnection();
    }
    
    public static Controller getController() {
        if(controller == null) {
            controller = new Controller();
        }
        return controller;
    }

    public User login(String username, String password) {
        return this.iCRUDImpl.getUser(username, password);
    }
    
}
