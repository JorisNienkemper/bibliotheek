package nl.bld.bibliotheek.app.view;

public class MainMenuView {

    public void showOptions() {

        System.out.println("""
                -------------------------------------------
                | Please choose one of the options below: |
                |                                         |
                | Option 1: Loan menu                     |
                | Option 2: Admin menu                    |
                | Option 3: Leave application             |
                -------------------------------------------
                Enter your number: """);

    }

    public void exitMessage() {
        System.out.println("You're leaving the application.");
    }
}
