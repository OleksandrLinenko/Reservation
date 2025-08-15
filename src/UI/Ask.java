/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;

import java.util.Scanner;

/**
 *
 * @author oleksandrlinenko
 */
public class Ask {

    private static Scanner sc = new Scanner(System.in);

    public static Ask create() {
        return new Ask();
    }

    public String askString(String string) {
        Message.create().show(string);
        return sc.next();
    }

    public int askInt(String string) {
        Message.create().show(string);
        return sc.nextInt();
    }
}
