/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2.web;

import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import lab2.ejb.MessageKeeper;

/**
 *
 * @author User
 */
@WebService(serviceName = "IDemo")//"IDemoImpl" zamenim dlia vneshnih clientov
public class IDemoImpl implements IDemo {

    //Podkluchaem Bean
    @EJB
    private MessageKeeper messageKeeper;
    
    
    @Override
    public boolean add(String user, String message) {
        System.out.println("method add in WebService IDemoImpl started");
        return messageKeeper.addMessage(user, message);//perenapravliaem parametrbI v MessageKeeper
    }

    @Override
    public String getMessage(String user, int index) {
        System.out.println("method getMessage in WebService IDemoImpl started");
        return messageKeeper.getMessage(user, index);
    }

    @Override
    public List<String> getAllMessage(String user) {
        System.out.println("method getAllMessage in WebService IDemoImpl started");
        return messageKeeper.getMessageList(user);
    }
}
