/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2.web;

import java.util.List;

/**
* Интерфейс определяет методы для работы с коллекциями сообщений пользователей.
*/
public interface IDemo {

/**
* Метод позволяет добавить к коллекции заданного пользователя новое
* сообщение.
*
* @param user логин пользователя.
* @param message добавляемое сообщение.
* @return значение true в случае, если сообщение успешно добавлено, false -
* случае, когда логин пользователя или сообщение равны null или пусты.
*/
public boolean add(String user, String message);

/**
* Метод позволяет получить сообщение заданного пользователя по его индексу
* (порядковому номеру). Порядковый номер присваивается сообщению
* автоматически при его помещении в коллекцию сообщений пользователя. Для
* каждого пользователя ведётся отдельная нумерация сообщений.
*
* @param user логин пользователя.
* @param index индекс (порядковый номер).
* @return сообщение данного пользователя с индексом index или null, если
* такого пользователя нет или у заданного пользователя нет сообщения с
* таким индексом.
*/
public String getMessage(String user, int index);

/**
* Метод позволяет получить коллекцию всех сообщений заданного пользователя.
*
* @param user логин пользователя.
* @return коллекция сообщений заданного пользователя.
*/
public List<String> getAllMessage(String user);

}
