/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;

import Commands.CancleTicketCommand;
import Commands.ChangeTicketCommand;
import Commands.LoadDataCommand;
import Commands.ReserveTicketCommand;
import Commands.SaveDataCommand;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author oleksandrlinenko
 */
public class MainMenu {

    private static Scanner sc = new Scanner(System.in);

    public static MainMenu create() {
        return new MainMenu();
    }

    public void show() throws IOException {
        boolean endProgram = false;
        do {
            menu();
            int option = readOption();
            endProgram = doOption(option);
        } while (!endProgram);
    }

    private void menu() {
        Message.create().show("1. Load data from file");
        Message.create().show("2. Reserve the ticker");
        Message.create().show("3. Change information about reserved ticket");
        Message.create().show("4. Cancel the reservation");
        Message.create().show("5. Save data about reservation to the file");
        Message.create().show("0. End program");
    }

    private int readOption() {
        Message.create().show("Set the option: ");
        int option;
        try {
            option = sc.nextInt();
        } catch (InputMismatchException ex) {
            return -1;
        }

        return option;
    }

    private boolean doOption(int option) throws IOException {
        switch (option) {
            case 0:
                return true;
            case 1:
                loadData();
                break;
            case 2:
                reserveTicket();
                break;
            case 3:
                changeTicket();
                break;
            case 4:
                cancleTicket();
                break;
            case 5:
                saveData();
                break;
            default:
                Message.create().show("Undefined option");
        }

        return false;
    }

    public static void loadData() {
        LoadDataCommand.create().handle();
    }

    public static void reserveTicket() {
        try {
            ReserveTicketCommand.create().handle();
        } catch (Exception ex) {
            ErrorMessage.create().show(ex.getMessage());
        }
    }

    public static void changeTicket() {
        try {
            ChangeTicketCommand.create().handle();
        } catch (Exception ex) {
            ErrorMessage.create().show(ex.getMessage());
        }
    }

    public static void cancleTicket() {
        try {
            CancleTicketCommand.create().handle();
        } catch (Exception ex) {
            ErrorMessage.create().show(ex.getMessage());
        }
    }

    public static void saveData() {
        SaveDataCommand.create().handle();
    }
}
