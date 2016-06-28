/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sasurgical.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.WebApplicationObjectSupport;
import sasurgical.dto.Category;
import sasurgical.jdbc.SASurgicalCatalogDataAccess;

/**
 *
 * @author em000001
 */
@Controller
//@RequestMapping("/browse_item")
public class BrowserController extends WebApplicationObjectSupport {
    
    private SASurgicalCatalogDataAccess itemDataAccess;
    
    @Autowired
    public void setItemDataAccess(SASurgicalCatalogDataAccess itemDataAccess) {
        this.itemDataAccess = itemDataAccess;
    }
    
    @RequestMapping(value = "/get_categories", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public @ResponseBody 
    List<Category> getSubCategories(ModelMap model, @RequestParam(value = "category", required = true) int category_id,
            @RequestParam(value = "parent_category", required = true) int parent_category){
        List<Category> sub_categories = null;
        if (parent_category == 1)
            sub_categories = itemDataAccess.getSubCategories(0);
        else
            sub_categories = itemDataAccess.getSubCategories(category_id);            
        return sub_categories;
    }                
}
