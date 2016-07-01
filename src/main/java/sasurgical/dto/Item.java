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
public class Item {
    
    private int id;
    private String name;
    private String description;
    private String img_path;
    private String model;

    public Item() {
    }

    public Item(int id, String name, String description, String img_path, String model) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.img_path = img_path;
        this.model = model;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImg_path(String img_path) {
        this.img_path = img_path;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImg_path() {
        return img_path;
    }

    public String getModel() {
        return model;
    }
    
    
}
