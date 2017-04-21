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
     * Canopies class
     * @author Claire Chemutai Langat
     */
    public class CanopiesClass {


        private final IntegerProperty phoneNoCanopiesCol ;
        public int getPhoneNoCanopiesCol() {
            return phoneNoCanopiesCol.get();
        }

        public void setPhoneNoCanopiesCol(int value) {
            phoneNoCanopiesCol.set(value);
        }

        public IntegerProperty phoneNoCanopiesColProperty() {
            return phoneNoCanopiesCol;
        }
        private final StringProperty addressCanopiesCol ;
        public String getAddressCanopiesCol() {
            return addressCanopiesCol.get();
        }

        public void setAddressCanopiesCol(String value) {
            addressCanopiesCol.set(value);
        }

        public StringProperty addressCanopiesColProperty() {
            return addressCanopiesCol;
        }
        private final StringProperty customerNameCanopiesCol;

        public String getCustomerNameCanopiesCol() {
            return customerNameCanopiesCol.get();
        }

        public void setCustomerNameCanopiesCol(String value) {
            customerNameCanopiesCol.set(value);
        }

        public StringProperty customerNameCanopiesColProperty() {
            return customerNameCanopiesCol;
        }
        private final IntegerProperty quantityCanopiesCol;

        public int getQuantityCanopiesCol() {
            return quantityCanopiesCol.get();
        }

        public void setQuantityCanopiesCol(int value) {
            quantityCanopiesCol.set(value);
        }

        public IntegerProperty quantityCanopiesColProperty() {
            return quantityCanopiesCol;
        }

        private final StringProperty dateCanopiesCol ;
        public String getDateCanopiesCol() {
            return dateCanopiesCol.get();
        }

        public void setDateCanopiesCol(String value) {
            dateCanopiesCol.set(value);
        }

        public StringProperty dateCanopiesColProperty() {
            return dateCanopiesCol;
        }
        private final FloatProperty costCanopiesCol;
        public float getCostCanopiesCol() {
            return costCanopiesCol.get();
        }

        public void setCostCanopiesCol(float value) {
            costCanopiesCol.set(value);
        }

        public FloatProperty costCanopiesColProperty() {
            return costCanopiesCol;
        }


        public CanopiesClass(String customerName, int phone_number, String address,
                int quantity, String date, float cost ) {
        this.customerNameCanopiesCol = new SimpleStringProperty(customerName);
        this.phoneNoCanopiesCol= new SimpleIntegerProperty(phone_number);
        this.addressCanopiesCol= new SimpleStringProperty(address);
        this.quantityCanopiesCol = new SimpleIntegerProperty(quantity);
        this.dateCanopiesCol= new SimpleStringProperty(date);
        this.costCanopiesCol= new SimpleFloatProperty(cost);
        }
    }
