/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sasurgical.dto;

/**
 *
 * @author em000001
 */
public class Category {
 
    private String name;
    private int id;

    public Category() {
    }

    public Category(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
    
    
}
