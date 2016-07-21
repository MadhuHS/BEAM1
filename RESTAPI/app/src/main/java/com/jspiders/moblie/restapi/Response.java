package com.jspiders.moblie.restapi;

import java.util.List;

/**
 * Created by user on 21/07/2016.
 */
public class Response {
    /**
     * result : 0
     * productlist : [{"ID":101,"name":"Keyboard","brand":"Dell","price":123.22,"type":"E"}]
     */

    private int result;
    /**
     * ID : 101
     * name : Keyboard
     * brand : Dell
     * price : 123.22
     * type : E
     */

    private List<Productlist> productlist;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public List<Productlist> getProductlist() {
        return productlist;
    }

    public void setProductlist(List<Productlist> productlist) {
        this.productlist = productlist;
    }

    public static class Productlist {
        private int ID;
        private String name;
        private String brand;
        private double price;
        private String type;

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
