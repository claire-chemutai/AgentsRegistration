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
     * @author Claire Chemutai Langat
     */
    public class ChairsClass {
            private final StringProperty customerNameChairsCol;


        public String getCustomerNameChairsCol() {
            return customerNameChairsCol.get();
        }

        public void setCustomerNameChairsCol(String value) {
            customerNameChairsCol.set(value);
        }

        public StringProperty customerNameChairsColProperty() {
            return customerNameChairsCol;
        }
        private final IntegerProperty phoneNoChairsCol;

        public int getPhoneNoChairsCol() {
            return phoneNoChairsCol.get();
        }

        public void setPhoneNoTablesCol(int value) {
            phoneNoChairsCol.set(value);
        }

        public IntegerProperty phoneNoChairsColProperty() {
            return phoneNoChairsCol;
        }

        private final StringProperty addressChairsCol;
        public String getAddressChairsCol() {
            return addressChairsCol.get();
        }

        public void setAddressTableCol(String value) {
            addressChairsCol.set(value);
        }

        public StringProperty addressChairsColProperty() {
            return addressChairsCol;
        }
        private final IntegerProperty quantityChairsCol ;

        public int getQuantityTableCol() {
            return quantityChairsCol.get();
        }

        public void setQuantityTableCol(int value) {
            quantityChairsCol.set(value);
        }

        public IntegerProperty quantityChairsColProperty() {
            return quantityChairsCol;
        }

        private final StringProperty dateChairsCol;
        public String getDateChairsCol() {
            return dateChairsCol.get();
        }

        public void setDateChairsCol(String value) {
            dateChairsCol.set(value);
        }

        public StringProperty dateChairsColProperty() {
            return dateChairsCol;
        }

        private final FloatProperty costChairsCol;
        public float getCostChairsCol() {
            return costChairsCol.get();
        }

        public void setCostChairsCol(float value) {
            costChairsCol.set(value);
        }

        public FloatProperty costChairsColProperty() {
            return costChairsCol;
        }


        public ChairsClass() {
            this("", 0, "" , 0, " ",0 );
        }


        public ChairsClass(String customerName, int phone_number, String address, 
                int quantity,String date, float cost) {
        this.customerNameChairsCol = new SimpleStringProperty(customerName);
        this.phoneNoChairsCol= new SimpleIntegerProperty(phone_number);
        this.addressChairsCol= new SimpleStringProperty(address);
        this.quantityChairsCol = new SimpleIntegerProperty(quantity);
        this.dateChairsCol= new SimpleStringProperty(date);
        this.costChairsCol= new SimpleFloatProperty(cost);
        }


    }
