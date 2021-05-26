package com.hades.labs.calculator.domain.mapper;

import com.hades.labs.calculator.crosscutting.mapper.Mapper;
import com.hades.labs.calculator.dataprovider.jpa.entities.InventoryDao;
import com.hades.labs.calculator.domain.entities.InventoryDo;
import org.springframework.stereotype.Component;

@Component
public class MapperInventoryDaoToInventoryDo implements Mapper<InventoryDao, InventoryDo> {
    @Override
    public InventoryDo map(InventoryDao inventoryDao) {
        return InventoryDo.builder()
                .id(inventoryDao.getId())
                .name(inventoryDao.getName())
                .type(inventoryDao.getType())
                .price(inventoryDao.getPrice())
                .build();
    }
}
