package com.tw.hotelmenu.controller;

import com.tw.hotelmenu.model.Items;
import com.tw.hotelmenu.service.dto.MenuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = MenuController.class)
class MenuControllerTest {
    @Autowired
    private MockMvc mockmvc;

    @MockBean
    private MenuService menuService;

    @Test
    void shouldReturnMenuItems() throws Exception {
        List<Items> listofItems = Arrays.asList(
                new Items("idli","breakfast",80.0),
                new Items("vada","breakfast",100.0)
        );
        when(menuService.getAllItems()).thenReturn(listofItems);

        mockmvc.perform(get("/api/v1/menu")).andExpect(status().isOk());

        verify(menuService,times(1)).getAllItems();
    }

    @Test
    void shouldReturnCategoryMenuItems() throws Exception {
        List<Items> listofItems = Arrays.asList(
                new Items("idli","breakfast",80.0),
                new Items("vada","breakfast",100.0),
                new Items("icecream","dessert",100.0)
        );
        when(menuService.getCategoryItems("icecream")).thenReturn(listofItems);

        mockmvc.perform(get("/api/v1/menu")).andExpect(status().isOk());

        verify(menuService,times(1)).getCategoryItems("icecream");
    }
}
