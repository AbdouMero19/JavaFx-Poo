package transport.core;

import java.util.*;

public class Data {
    private static Map<Integer,Usager> passengerData = new TreeMap<>();
    private static Map<String,Employe> employeeData = new TreeMap<>();

    public static void addPassenger(Usager passenger){
        passengerData.put(passenger.getId(), passenger);
    }

    public static void addEmployee(Employe employee){
        employeeData.put(employee.getId(), employee);
    }

    public static boolean paasengerExists(int id){
        return passengerData.containsKey(id);
    }

    public static boolean employeeExists(String id){
        return employeeData.containsKey(id);
    }
}
