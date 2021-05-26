package com.hades.labs.calculator.service.implement;

import com.hades.labs.calculator.dataprovider.jpa.entities.InventoryDao;
import com.hades.labs.calculator.dataprovider.jpa.repositories.InventoryRepository;
import com.hades.labs.calculator.domain.entities.InventoryDo;
import com.hades.labs.calculator.domain.mapper.MapperInventoryDaoToInventoryDo;
import com.hades.labs.calculator.domain.mapper.MapperInventoryDoToInventoryDao;
import com.hades.labs.calculator.service.InventoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {
    private final InventoryRepository inventoryRepository;
    private final MapperInventoryDoToInventoryDao mapperInventoryDoToInventoryDao;
    private final MapperInventoryDaoToInventoryDo mapperInventoryDaoToInventoryDo;

    @Override
    public InventoryDo save(InventoryDo inventoryDo) {
        try {
            InventoryDao inventoryDao = new InventoryDao();
            mapperInventoryDoToInventoryDao.map(inventoryDao, inventoryDo);
            return mapperInventoryDaoToInventoryDo.map(inventoryRepository.save(inventoryDao));
        } catch (Exception e) {
            log.error("Error in InventoryServiceImpl - save {0}", e);
            return null;
        }
    }

    @Override
    public InventoryDo update(InventoryDo inventoryDo) {
        try {
            InventoryDao inventoryDao = new InventoryDao();
            mapperInventoryDoToInventoryDao.map(inventoryDao, inventoryDo);
            return mapperInventoryDaoToInventoryDo.map(inventoryRepository.save(inventoryDao));
        } catch (Exception e) {
            log.error("Error in InventoryServiceImpl - update {0}", e);
            return null;
        }
    }

    @Override
    public Boolean delete(Integer inventoryId) {
        try {
            inventoryRepository.delete(inventoryRepository.findById(inventoryId).orElseThrow(Exception::new));
            return Boolean.TRUE;
        } catch (Exception e) {
            log.error("Error in InventoryServiceImpl - delete {0}", e);
            return Boolean.FALSE;
        }
    }

    @Override
    public List<InventoryDo> list() {
        List<InventoryDo> inventoryDos = new ArrayList<>();
        try {
            List<InventoryDao> inventoryDaos = inventoryRepository.findAll();
            inventoryDaos.forEach(inventoryDao -> {
                inventoryDos.add(mapperInventoryDaoToInventoryDo.map(inventoryDao));
            });
        } catch (Exception e) {
            log.error("Error in InventoryServiceImpl - list {0}", e);
        }
        return inventoryDos;
    }

    @Override
    public InventoryDo get(Integer inventoryId) {
        try {
            return mapperInventoryDaoToInventoryDo.map(inventoryRepository.findById(inventoryId).orElseThrow(Exception::new));
        } catch (Exception e) {
            log.error("Error in InventoryServiceImpl - get {0}", e);
            return null;
        }
    }
}
