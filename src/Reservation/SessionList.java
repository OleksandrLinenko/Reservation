/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reservation;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author oleksandrlinenko
 */
public class SessionList {

    private List<Session> sessions = new ArrayList();

    public List<Session> getSessions() {
        return sessions;
    }

    public void add(Session session) {
        sessions.add(session);
    }

    public Session find(int id) {
        for (Session ses : sessions) {
            if (ses.getId() == id) {
                return ses;
            }
        }

        return null;
    }
}
