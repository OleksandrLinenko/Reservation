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
public class FilmList {

    private List<Film> films = new ArrayList();

    public List<Film> getFilms() {
        return films;
    }

    public void add(Film film) {
        films.add(film);
    }

    public Film find(int id) {
        for (Film film : films) {
            if (film.getId() == id) {
                return film;
            }
        }

        return null;
    }

    public Film find(String name) {
        for (Film film : films) {
            if (film.getName().equals(name)) {
                return film;
            }
        }

        return null;
    }
}
