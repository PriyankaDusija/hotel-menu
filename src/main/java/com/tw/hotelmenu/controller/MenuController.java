package com.tw.hotelmenu.controller;

import com.tw.hotelmenu.model.Items;
import com.tw.hotelmenu.service.dto.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("menu")
    public List<Items> getMenu()
    {
        return menuService.getAllItems();
    }

    @PostMapping("/additem")
    public Items addItem(@RequestBody Items menuItem)
    {
        return menuService.addItem(menuItem);
    }

    @GetMapping("/menu/{category}")
    public List<Items> getCategoryMenu(@PathVariable("category") String category)
    {
        List<Items> categoryItems = menuService.getCategoryItems(category);
        return categoryItems;
    }
}
