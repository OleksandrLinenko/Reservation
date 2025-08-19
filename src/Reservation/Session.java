/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reservation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author oleksandrlinenko
 */
public class Session {

    private int id;
    private int filmId;
    private LocalDateTime time;
    private int maxSeats;

    public Session(int id, int filmId, LocalDateTime time, int maxSeats) {
        if (id <= 0 || filmId <= 0 || maxSeats <= 0) {
            throw new IllegalArgumentException("Illegal argument");
        }
        this.id = id;
        this.filmId = filmId;
        this.time = time;
        this.maxSeats = maxSeats;
    }

    public int getId() {
        return id;
    }

    public int getFilmId() {
        return filmId;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public int getMaxSeats() {
        return maxSeats;
    }

    @Override
    public String toString() {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return date.format(formatter);
    }

}
