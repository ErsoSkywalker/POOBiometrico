package ets.poo.Utilities;

import ets.poo.Objects.Keys;
import java.io.IOException;
import java.util.Scanner;

//C:\\Users\\conti\\Desktop\\Biometrico\\ETS POO\\BancoDeDatos.txt
public class Logic {

    Scanner sc = new Scanner(System.in);

    public Logic() throws IOException {
        System.out.println("Bienvenido. \nClaves registradas en el sistema:");
        leerFichero lf = new leerFichero("C:\\Users\\conti\\Desktop\\Biometrico\\ETS POO\\BancoDeDatos.txt");
        desplegarMenu();
    }

    public void desplegarMenu() {

        int numero = 0;
        do {
            System.out.println("Opciones de Menú.");
            System.out.println("1. Numero de registros por cada dispositivo Biometrico");
            System.out.println("2. Numero de registros por cada empleado");
            System.out.println("3. Numero de registros por cada empleado por día");
            System.out.println("4. Salir");
            numero = validarOpcion();
            switch (numero) {
                case 1: {
                    opcionUno();
                    break;
                }
                case 2: {
                    opcionDos();
                    break;
                }
                case 3: {
                    opcionTres();
                    break;
                }
                case 4: {
                    System.out.println("¡Hasta pronto!");
                    break;
                }
            }
        } while (numero != 4);

    }

    public int validarOpcion() {
        boolean flag = false;
        String numeroPosible;
        do {

            System.out.println("Introduce una opción");
            numeroPosible = sc.nextLine();
            if (!numeroPosible.matches("[0-9]+")) {
                flag = false;
                System.out.println("Esto no es un numero, corrigelo.");
            } else if (Integer.parseInt(numeroPosible) < 1 || Integer.parseInt(numeroPosible) > 4) {
                flag = false;
                System.out.println("Tu numero no está dentro de las opciones, corrige.");
            } else {
                flag = true;
            }
        } while (!flag);

        return Integer.parseInt(numeroPosible);
    }

    public void opcionUno() {
        System.out.println("Bienvenido a la opción uno, introduce el dispositivo Biometrico que deseas verificar.");
        int bioUnit = 0;
        boolean validate = false;
        do {
            bioUnit = validarNumero();
            if (bioUnit != 1 && bioUnit != 2) {
                System.out.println("Debes escoger entre la unidad uno y la unidad dos.");
            }
        } while (bioUnit != 1 && bioUnit != 2);
        for (Keys item : KeysHolder.getKeysBioUnit(bioUnit)) {
            validate = true;
            System.out.println("Empleado: " + item.getEmployeeKey() + " Fecha de Registro: " + item.getRegisterDate() + " Hora de Registro: " + item.getRegisterHour() + " Unidad Biometrica: " + item.getBioUnit());
        }
        if (!validate) {
            System.out.println("No se han encontrado resultados con ese id de Biometrico");
        }
    }

    public void opcionDos() {
        System.out.println("Bienvenido a la opción dos, introduce el numero de empleado que deseas verificar.");
        int employeeNumber = 0;
        boolean validate = false;
        do {
            employeeNumber = validarNumero();
            if (Integer.toString(employeeNumber).length() != 6) {
                System.out.println("Debe ser una clave de 6 digitos, corrige.");
            }
        } while (Integer.toString(employeeNumber).length() != 6);
        for (Keys item : KeysHolder.getKeysEmployeeNumber(employeeNumber)) {
            validate = true;
            System.out.println("Empleado: " + item.getEmployeeKey() + " Fecha de Registro: " + item.getRegisterDate() + " Hora de Registro: " + item.getRegisterHour() + " Unidad Biometrica: " + item.getBioUnit());
        }
        if (!validate) {
            System.out.println("No se han encontrado resultados con ese numero de empleado");
        }
    }

    public void opcionTres() {
        System.out.println("Bienvenido a la opción tres, introduce el numero de empleado y la fecha que deseas verificar.");
        int employeeNumber = 0, dateStudy = 0;
        boolean validate = false;
        do {
            System.out.println("Primero el empleado");
            employeeNumber = validarNumero();
            System.out.println("Luego la fecha");
            dateStudy = validarNumero();
            if (Integer.toString(employeeNumber).length() != 6 || Integer.toString(dateStudy).length() != 6) {
                System.out.println("Alguno de los datos no tiene un formato correcto, corrige.");
            }
        } while (Integer.toString(employeeNumber).length() != 6 || Integer.toString(dateStudy).length() != 6);
        for (Keys item : KeysHolder.getKeysEmployeeNumberDateStudy(employeeNumber, dateStudy)) {
            validate = true;
            System.out.println("Empleado: " + item.getEmployeeKey() + " Fecha de Registro: " + item.getRegisterDate() + " Hora de Registro: " + item.getRegisterHour() + " Unidad Biometrica: " + item.getBioUnit());
        }
        if (!validate) {
            System.out.println("No se han encontrado resultados con esa combinación");
        }
    }

    public int validarNumero() {

        String numeroPosible;
        do {
            System.out.println("Escribe un número.");
            numeroPosible = sc.nextLine();
            if (!numeroPosible.matches("[0-9]+")) {
                System.out.println("El dato que introduces no es un numero, repite.");
            }
        } while (!numeroPosible.matches("[0-9]+"));

        return Integer.parseInt(numeroPosible);
    }

}
