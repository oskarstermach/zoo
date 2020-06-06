package pl.ostermach.zoo;

import java.io.IOException;
import java.util.Scanner;


public class AppManager {
    private ApplicationService applicationService;

    public AppManager(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    public void controlApplicationFlow() throws IOException {
        Scanner in = new Scanner(System.in);
        while (true) {
            showSelectionMenu();
            AppOperation appOperation = handleInput(in.nextLine());
            switch (appOperation) {
                case ADD:
                    applicationService.addNewEntry();
                    break;
                case DELETE:
                    applicationService.deleteEntry();
                    break;
                case UPDATE:
                    applicationService.updateEntry();
                    break;
                case GET:
                    applicationService.getEntries();
                    break;
                case FIND:
                    applicationService.findById();
                    break;
                default:
                    System.out.println("Unrecognized operation!");
            }
        }
    }

    public AppOperation handleInput(String choice) {
        if (choice.matches("[0-9]{1}")) {
            return AppOperation.INVALID;
        } else {
            return choice.toUpperCase().matches("[ADUGTF]") ?
                    AppOperation.get(choice.toUpperCase()) : AppOperation.INVALID;
        }
    }

    private void showSelectionMenu() {
        System.out.println("----------------------------------------\n[A] New entry\n[D] Delete entry\n[U] Update entry\n[G] Get entries\n[F] Find entries\n----------------------------------------");
    }
}
