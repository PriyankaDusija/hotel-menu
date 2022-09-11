package com.tw.hotelmenu.repository;

import com.tw.hotelmenu.model.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Items,Long> {
}
