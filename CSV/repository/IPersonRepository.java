package CSV.repository;

import java.util.ArrayList;

import CSV.model.person;

    public interface IPersonRepository {
    public void formatName(ArrayList<person> ls);

    public void formatAddress(ArrayList<person> ls);

    public  void importFile(ArrayList<person> ls);

    public  void exportFile(ArrayList<person> ls);
}


