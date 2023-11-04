package CSV.repository;

import java.util.ArrayList;

import CSV.dataAccess.function;
import CSV.model.person;

public class PersonRepository implements IPersonRepository{

     function function = new function();

    @Override
    public void formatName(ArrayList<person> ls) {
        function.formatName(ls);
    }

    @Override
    public void formatAddress(ArrayList<person> ls) {
        function.formatAddress(ls);
    }

    @Override
    public void importFile(ArrayList<person> ls) {
       function.importFile(ls);
    }

    @Override
    public void exportFile(ArrayList<person> ls) {
        function.exportFile(ls);
    }
}

