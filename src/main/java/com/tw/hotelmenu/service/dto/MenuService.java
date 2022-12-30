package com.tw.hotelmenu.service.dto;

import com.tw.hotelmenu.model.Items;
import com.tw.hotelmenu.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    public List<Items> getAllItems()
    {
        return menuRepository.findAll();
    }

    public Items addItem(Items newItem)
    {
        return menuRepository.save(newItem);
    }

    public List<Items> getCategoryItems(String category) { return menuRepository.findByCategory(category);
    }
}
