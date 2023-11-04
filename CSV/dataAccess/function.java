package CSV.dataAccess;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import CSV.model.person;

public class function {
    
 final String COMMA_DELIMITER = ",";
    final String NEW_LINE_SEPARATOR = "\n";
    Scanner in = new Scanner(System.in);
    public void formatName(ArrayList<person> ls) {
        for (int i = 0; i < ls.size(); i++) {
            String name = ls.get(i).getName().trim();
            name = name.toLowerCase().replaceAll("\\s+", ",");
            String[] arr = name.split(",");
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < arr.length; j++) {
                sb.append(Character.toUpperCase(arr[j].charAt(0)))
                        .append(arr[j].substring(1)).append(" ");
            }
            ls.get(i).setName(sb.toString().trim());
        }
        System.err.println("Format: Done");
    }

    public void formatAddress(ArrayList<person> ls) {
        for (int i = 0; i < ls.size(); i++) {
            String address = ls.get(i).getAddress().trim();
            address = address.toLowerCase().replaceAll("\\s+", ",");
            String[] arr = address.split(",");
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < arr.length; j++) {
                sb.append(Character.toUpperCase(arr[j].charAt(0)))
                        .append(arr[j].substring(1)).append(" ");
            }
            ls.get(i).setAddress(sb.toString().trim());
        }
        System.err.println("Format: Done");
    }

    public  void importFile(ArrayList<person> ls) {
        String line = "";
        BufferedReader fileReader = null;
        System.out.print("Enter Path: ");
        String fileName = in.nextLine().trim();
        try {
            fileReader = new BufferedReader(new FileReader(fileName));
            while ((line = fileReader.readLine()) != null) {
                // System.out.println(line);
                String[] splitCSV = line.split(COMMA_DELIMITER);
                ls.add(new person(Integer.parseInt(splitCSV[0]), splitCSV[1],
                        splitCSV[2], splitCSV[3], splitCSV[4]));

            }
            System.err.println("Import: Done");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public  void exportFile(ArrayList<person> ls) {
        FileWriter fileWriter = null;
        System.out.print("Enter Path: ");
        String fileName = in.nextLine();
        try {
            fileWriter = new FileWriter(fileName);
            for (person listCSV : ls) {
                fileWriter.append(String.valueOf(listCSV.getId()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(listCSV.getName()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(listCSV.getEmail()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(listCSV.getPhone()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(listCSV.getAddress()));
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            System.err.println("Export Done!!!");
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public  void print(ArrayList<person> ls) {
        for (int i = 0; i < ls.size(); i++) {
            System.out.printf("%d,%s,%s,%s,%s\n", ls.get(i).getId(),
                    ls.get(i).getName(), ls.get(i).getEmail(), ls.get(i).getPhone(),
                    ls.get(i).getAddress());
        }
    }
}

