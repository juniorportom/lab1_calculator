package com.hades.labs.calculator.service;

import com.hades.labs.calculator.domain.entities.InventoryDo;

import java.util.List;

public interface InventoryService {

    InventoryDo save(InventoryDo inventoryDo);

    InventoryDo update(InventoryDo inventoryDo);

    Boolean delete(Integer inventoryId);

    List<InventoryDo> list();

    InventoryDo get(Integer inventoryId);

}
