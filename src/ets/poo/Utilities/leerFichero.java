
package ets.poo.Utilities;

import ets.poo.Objects.Keys;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import ets.poo.Utilities.KeysHolder;

public class leerFichero {
    private int errorCount;
    public leerFichero (String archivo) throws FileNotFoundException, IOException {
        int acum = 1;
        String cadena;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while ((cadena = b.readLine()) != null) {
            if(cadena.length() == 19 && cadena.matches("[0-9]+")){
                KeysHolder.addKey(new Keys(Integer.parseInt(cadena.substring(0,6)), Integer.parseInt(cadena.substring(6,12)), Integer.parseInt(cadena.substring(12,18)), Integer.parseInt(cadena.substring(18,19))));
            }else{
                System.out.println("La cadena " + acum + " no tiene los 19 numeros necesarios.");
                errorCount++;
            }
            acum++;
        }
        b.close();
        imprimirClaves();
    }
    
    public void imprimirClaves(){
        for(int i = 0; i < KeysHolder.getKeysArray().size(); i++){
            System.out.println("Empleado " + i + ": " + KeysHolder.getKey(i).getEmployeeKey() + " Fecha de Registro " + i + ": " + KeysHolder.getKey(i).getRegisterDate() + " Hora de Registro " + i + ": " + KeysHolder.getKey(i).getRegisterHour() + " Unidad Biometrica: " + KeysHolder.getKey(i).getBioUnit());
        }
        System.out.println("INCISO A) Tenemos un total de " + KeysHolder.getKeysArray().size() + " claves validas en el fichero de texto.");
        if(errorCount>0)
            System.out.println("Tenemos un total de " + errorCount + " claves no validas en el fichero de texto, han sido señaladas anteriormente, por favor reviselas.");
    }
    
}
