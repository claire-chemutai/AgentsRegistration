/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package furniturevillas;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * table class
 * @author Claire Chemutai langat
 */
public class TableClass {

    private final StringProperty customerNameTablesCol;
    
    
    public String getCustomerNameTablesCol() {
        return customerNameTablesCol.get();
    }
    
    

    public void setCustomerNameTablesCol(String value) {
        customerNameTablesCol.set(value);
    }
   

    public StringProperty customerNameTablesColProperty() {
        return customerNameTablesCol;
    }
    private final IntegerProperty phoneNoTablesCol;
    
    
    public int getPhoneNoTablesCol() {
        return phoneNoTablesCol.get();
    }
    
    

    public void setPhoneNoTablesCol(int value) {
        phoneNoTablesCol.set(value);
    }
    
    

    public IntegerProperty phoneNoTablesColProperty() {
        return phoneNoTablesCol;
    }
    
   

    private final StringProperty addressTableCol;
   

    public String getAddressTableCol() {
        return addressTableCol.get();
    }
    
   

    public void setAddressTableCol(String value) {
        addressTableCol.set(value);
    }
    
    

    public StringProperty addressTableColProperty() {
        return addressTableCol;
    }
    
    
    private final IntegerProperty quantityTableCol ;
           

    public int getQuantityTableCol() {
        return quantityTableCol.get();
    }
    
   

    public void setQuantityTableCol(int value) {
        quantityTableCol.set(value);
    }
    
   

    public IntegerProperty quantityTableColProperty() {
        return quantityTableCol;
    }
    
    
    private final StringProperty dateTableCol;
   

    public String getDateTableCol() {
        return dateTableCol.get();
    }

    public void setDateTableCol(String value) {
        dateTableCol.set(value);
    }

    public StringProperty dateTableColProperty() {
        return dateTableCol;
    }
    
    private final FloatProperty costTableCol;
    //= new SimpleFloatProperty();

    public float getCostTableCol() {
        return costTableCol.get();
    }

    public void setCostTableCol(float value) {
        costTableCol.set(value);
    }

    public FloatProperty costTableColProperty() {
        return costTableCol;
    }
    
    
    
    public TableClass() {
        this(" ", 0, "" , 0," ",0);
    }
    
    
    public TableClass(String customerName, int phone_number, String address,
        int quantity, String date, float cost) {
        this.customerNameTablesCol = new SimpleStringProperty(customerName);
        this.phoneNoTablesCol= new SimpleIntegerProperty(phone_number);
        this.addressTableCol= new SimpleStringProperty(address);
        this.quantityTableCol = new SimpleIntegerProperty(quantity);
        this.dateTableCol= new SimpleStringProperty(date);
        this.costTableCol = new SimpleFloatProperty(cost);
    }

    
    
}
