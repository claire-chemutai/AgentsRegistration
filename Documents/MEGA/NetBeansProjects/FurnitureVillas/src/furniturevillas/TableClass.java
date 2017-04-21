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
 *
 * @author Claire Chemutai langat
 */
public class TableClass {

    private final StringProperty customerNameTablesCol;
    
    /**
    * gets the customer name from the table
    */
    
    public String getCustomerNameTablesCol() {
        return customerNameTablesCol.get();
    }
    
    /**
    * gets the customer name from the table
    */

    public void setCustomerNameTablesCol(String value) {
        customerNameTablesCol.set(value);
    }
    
    /**
    * gets the customer name from the table
    */

    public StringProperty customerNameTablesColProperty() {
        return customerNameTablesCol;
    }
    private final IntegerProperty phoneNoTablesCol;
    
    /**
    * gets the customer name from the table
    */
    public int getPhoneNoTablesCol() {
        return phoneNoTablesCol.get();
    }
    
    /**
    * gets the customer name from the table
    */

    public void setPhoneNoTablesCol(int value) {
        phoneNoTablesCol.set(value);
    }
    
    /**
    * gets the customer name from the table
    */

    public IntegerProperty phoneNoTablesColProperty() {
        return phoneNoTablesCol;
    }
    
    /**
    * gets the customer name from the table
    */

    private final StringProperty addressTableCol;
   

    public String getAddressTableCol() {
        return addressTableCol.get();
    }
    
    /**
    * gets the customer name from the table
    */

    public void setAddressTableCol(String value) {
        addressTableCol.set(value);
    }
    
    /**
    * gets the customer name from the table
    */

    public StringProperty addressTableColProperty() {
        return addressTableCol;
    }
    
    /**
    * gets the customer name from the table
    */
    private final IntegerProperty quantityTableCol ;
           

    public int getQuantityTableCol() {
        return quantityTableCol.get();
    }
    
    /**
    * gets the customer name from the table
    */

    public void setQuantityTableCol(int value) {
        quantityTableCol.set(value);
    }
    
    /**
    * gets the customer name from the table
    */

    public IntegerProperty quantityTableColProperty() {
        return quantityTableCol;
    }
    
    /**
    * gets the customer name from the table
    */
    
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
