package nl.bld.bibliotheek.app.controller;

import nl.bld.bibliotheek.app.view.MainMenuView;

import java.util.Scanner;

public class MainMenuController {

    private int inputGebruiker;

    public void choiceMenu() {
        MainMenuView mainMenuView = new MainMenuView();
        mainMenuView.showOptions();

        Scanner scanner = new Scanner(System.in);
        int userInput = scanner.nextInt();

        switch (inputGebruiker) {
            case 1:
                //  klassenaam.loanController();

                break;
            case 2:
                //  klassenaam.adminController();
                break;
        }
    }
}
