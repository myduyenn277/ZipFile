package CSV;

import java.util.ArrayList;

import CSV.controller.personController;
import CSV.model.person;

public class Main {
   public static void main(String[] args) {
        personController personController = new personController();
        ArrayList<person> ls = new ArrayList<>();
        ls.add(new person(1, "duong nguyen tan trung", "TanTrung@gmail.com", "'0334477557", "    Ngu Hanh Son -    Da nang"));
        ls.add(new person(2, "Vo My Duyen  ", "myduyen@gmail.com", "0904285952", "Quang Nam"));
        personController.input(ls);
        personController.run();
    }  
}
