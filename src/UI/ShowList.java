/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;

import Reservation.Film;
import Reservation.FilmList;

/**
 *
 * @author oleksandrlinenko
 */
public class ShowList {
    
    public static ShowList create() {
        return new ShowList();
    }
    
    public void showFilms(FilmList films) {
        for (Film film : films.getFilms()) {
            Message.create().show(String.format("%s", film.toString()));
        }
    }
}
