/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2.ejb;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author User
 */
@Stateless
@LocalBean
public class MessageKeeper extends AMessages {

    @Override
    public String getMessage(String user, int index) throws InvalidParameterException {
        System.out.println("method getMessage in MessageKeeper started");
        String errMessage = "User not found";
        if (messages.containsKey(user)) {
            List<String> listMsg = messages.get(user);
            if (listMsg != null) {
                if (index < 0 || index >= listMsg.size()) {
                    errMessage = "message " + index + " not found";
                    return errMessage;
                } else {
                    return listMsg.get(index);
                }
            } else {
                errMessage = "message list is empty";
                return errMessage;
            }
        } else {
            return errMessage;
        }
    }

    @Override
    public boolean addMessage(String user, String message) {
        System.out.println("method addMessage in MessageKeeper started");
        List<String> listMsg;
        //int i = 0;
        if (messages.containsKey(user)) {
            listMsg = messages.get(user);

        } else {
            listMsg = new ArrayList<>();
            listMsg.add("Заглушка нулевого индекса (Первое сообщение - первое по порядку номеров)");
            //i = 1;
        }
        listMsg.add(message);//add(message);

        messages.put(user, listMsg);
        return true;
    }

    @Override
    public List<String> getMessageList(String user) {
        System.out.println("method getMessageList in MessageKeeper started");
        return messages.get(user);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
