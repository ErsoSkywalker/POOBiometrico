
package ets.poo.Objects;

public class Keys {

    
    private int employeeKey, registerDate, registerHour, bioUnit;
    
    public Keys(int employeeKey, int registerDate, int registerHour, int bioUnit){
        this.employeeKey = employeeKey;
        this.bioUnit = bioUnit;
        this.registerDate = registerDate;
        this.registerHour = registerHour;
    }
    
    public int getEmployeeKey() {
        return employeeKey;
    }

    public void setEmployeeKey(int employeeKey) {
        this.employeeKey = employeeKey;
    }

    public int getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(int registerDate) {
        this.registerDate = registerDate;
    }

    public int getRegisterHour() {
        return registerHour;
    }

    public void setRegisterHour(int registerHour) {
        this.registerHour = registerHour;
    }

    public int getBioUnit() {
        return bioUnit;
    }

    public void setBioUnit(int bioUnit) {
        this.bioUnit = bioUnit;
    }
}
