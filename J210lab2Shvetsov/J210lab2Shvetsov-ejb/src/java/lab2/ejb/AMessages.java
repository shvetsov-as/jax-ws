/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2.ejb;

import java.io.Serializable;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* Абстрактный класс для хранения коллекций сообщений пользователей.
*/
public abstract class AMessages implements Serializable {
/**
* Коллекция сообщений типа Map, в которой ключ представлен логином
* пользователя, а значение - списком сообщений.
*/
protected static Map <String, List<String>> messages;

/**
* Конструктор по умолчанию.
*/
public AMessages() {
this.messages = new HashMap<>();

//dlia proverki
//ArrayList<String> al = new ArrayList<>();
//al.add("#Message from uuu 1#public AMessages()#");
//al.add("#Message from uuu 2#public AMessages()#");
//al.add("#Message from uuu 3#public AMessages()#");
//messages.put("uuu", al);

}

/**
* Метод возвращает сообщение заданного пользователя по индексу сообщения
* (порядковому номеру).
*
* @param user логин пользователя.
* @param index индекс сообщения
* @return сообщение пользователя или null, если такого пользователя нет или
* у него нет сообщения с данным индексом.
*/
public abstract String getMessage(String user, int index) throws InvalidParameterException;

/**
* Метод добавляет новое сообщение к коллекции заданного пользователя. Если
* пользователя с указанным логином нет в коллекции, то создаётся новый
* элемент коллекции с ключом с заданным параметром login.
*
* @param user логин пользователя.
* @param message сообщение пользователя.
* @return значение true в случае, если сообщение успешно добавлено, false -
* в случае, когда логин пользователя или сообщение являются недопустимыми.
*/
public abstract boolean addMessage(String user, String message);

/**
* Метод возвращает коллекци сообщений данного пользователя.
* @param user логин пользователя.
* @return коллекция сообщений пользователя.
*/
public abstract List<String> getMessageList(String user);

}
