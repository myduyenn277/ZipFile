package CSV.controller;

import java.util.ArrayList;

import CSV.model.person;
import CSV.repository.PersonRepository;
import CSV.view.Menu;

public class personController extends Menu {

    PersonRepository personRepository = new PersonRepository();
    ArrayList<person> persons = new ArrayList<>();

    public void input(ArrayList<person> ls) {
        this.persons = ls;
    }

    static String[] option = { "Import CSV.",
            "Format Address.",
            "Format Name.",
            "Export CSV.",
            "Exit" };

    public personController() {
        super("Programming", option);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                personRepository.importFile(persons);
                break;
            case 2:
                personRepository.formatAddress(persons);
                break;
            case 3:
                personRepository.formatName(persons);
                break;
            case 4:
                personRepository.exportFile(persons);
                break;
            case 5:
                System.out.println("Doneeeee");
                break;
            default:
                break;
        }
    }

}
