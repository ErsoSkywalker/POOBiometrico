
package ets.poo.Utilities;

import ets.poo.Objects.Keys;
import java.util.ArrayList;

public class KeysHolder {

    public static ArrayList<Keys> getKeysArray() {
        return keysArray;
    }

    public static void setKeysArray(ArrayList<Keys> aKeysArray) {
        keysArray = aKeysArray;
    }
    
    public static void addKey(Keys key){
        keysArray.add(key);
    }
    
    public static Keys getKey(int position){
        return keysArray.get(position);
    }
    
    //Aquí añadiremos la logica de la lectura de llaves y clasificación.
    
    public static ArrayList<Keys> getKeysBioUnit(int BioUnit){
        ArrayList<Keys> response = new ArrayList<>();
        for(int i = 0; i < keysArray.size(); i++){
            if(keysArray.get(i).getBioUnit() == BioUnit){
                response.add(keysArray.get(i));
            }
        }
        return response;
    }
    
    public static ArrayList<Keys> getKeysEmployeeNumber(int employeeNumber){
        ArrayList<Keys> response = new ArrayList<>();
        for(int i = 0; i < keysArray.size(); i++){
            if(keysArray.get(i).getEmployeeKey() == employeeNumber){
                response.add(keysArray.get(i));
            }
        }
        return response;
    }
    
    public static ArrayList<Keys> getKeysEmployeeNumberDateStudy(int employeeNumber, int dateStudy){
        ArrayList<Keys> response = new ArrayList<>();
        for(int i = 0; i < keysArray.size(); i++){
            if(keysArray.get(i).getEmployeeKey() == employeeNumber && keysArray.get(i).getRegisterDate() == dateStudy){
                response.add(keysArray.get(i));
            }
        }
        return response;
    }
    
    private static ArrayList<Keys> keysArray = new ArrayList<>();
    
}
