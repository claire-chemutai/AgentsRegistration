/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package furniturevillas;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * person controller
 * @author Claire Chemutai
 */


public class Person {

    private final StringProperty address;

    public String getAddress() {
        return address.get();
    }

    public void setAddress(String value) {
        address.set(value);
    }

    public StringProperty addressProperty() {
        return address;
    }

    private final IntegerProperty phone_number;

    public Integer getPhone_number() {
        return phone_number.get();
    }

    public void setPhone_number(Integer value) {
        phone_number.set(value);
    }

    public IntegerProperty phone_numberProperty() {
        return phone_number;
    }
    private final IntegerProperty quantity;

    public Integer getQuantity() {
        return quantity.get();
    }

    public void setQuantity(Integer value) {
        quantity.set(value);
    }

    public IntegerProperty quantityProperty() {
        return quantity;
    }
    private final StringProperty item ;

    public String getItem() {
        return item.get();
    }

    public void setItem(String value) {
        item.set(value);
    }
    
    public StringProperty itemProperty() {
        return item;
    }

    private final StringProperty customer;
    public String getCustomer() {
        return customer.get();
    }

    public void setCustomer(String value) {
        customer.set(value);
    }

    public StringProperty customerProperty() {
        return customer;
    }
    
    private final FloatProperty cost;

    public float getCost() {
        return cost.get();
    }

    public void setCost(float value) {
        cost.set(value);
    }

    public FloatProperty costProperty() {
        return cost;
    }
    private final StringProperty date;
    //= new SimpleStringProperty();

    public String getDate() {
        return date.get();
    }

    public void setDate(String value) {
        date.set(value);
    }

    public StringProperty dateProperty() {
        return date;
    }
    private  IntegerProperty customerID ;

    public int getCustomerID() {
        return customerID.get();
    }

    public void setCustomerID(int value) {
        customerID.set(value);
    }

    public IntegerProperty customerIDProperty() {
        return customerID;
    }

    @Override
    public String toString() {
        return "Person{" + "address=" + address + ", phone_number=" 
                + phone_number + ",  quantity=" + 
                quantity + ", item=" + item + ", customer=" + 
                customer + ", cost=" + cost + '}';
    }

    

    public Person() {
        this(null,0,null,null,0,0,null);
    }
    
    

    public Person(String customer,int phone_number, String address,
            String item,int quantity,float cost,String date, int customerID) {
        this.customer = new SimpleStringProperty(customer);
        this.phone_number= new SimpleIntegerProperty(phone_number);
        this.address = new SimpleStringProperty (address);
        this.item = new SimpleStringProperty(item);
        this.quantity= new SimpleIntegerProperty(quantity);
        this.cost= new SimpleFloatProperty(cost);
        this.date = new SimpleStringProperty(date);
        this.customerID = new SimpleIntegerProperty(customerID);
    
    
    }
    
    

   
    
    
    
    public Person(String customer,int phone_number, String address,
            String item,int quantity,float cost,String date) {
        this.customer = new SimpleStringProperty(customer);
        this.phone_number= new SimpleIntegerProperty(phone_number);
        this.address = new SimpleStringProperty (address);
        this.item = new SimpleStringProperty(item);
        this.quantity= new SimpleIntegerProperty(quantity);
        this.cost= new SimpleFloatProperty(cost);
        this.date = new SimpleStringProperty(date);
    
    
    }
    
}
    
    

