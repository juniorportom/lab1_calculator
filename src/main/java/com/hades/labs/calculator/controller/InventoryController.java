package com.hades.labs.calculator.controller;

import com.hades.labs.calculator.crosscutting.constants.Constants;
import com.hades.labs.calculator.domain.entities.InventoryDo;
import com.hades.labs.calculator.service.InventoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*")
@RequestMapping(value = Constants.INVENTORY)
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping(value = Constants.INVENTORY_ALL, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<InventoryDo>> list(){
        return new ResponseEntity<>(inventoryService.list(), HttpStatus.OK);
    }

    @GetMapping(value = Constants.INVENTORY_ID_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InventoryDo> get(@PathVariable(Constants.INVENTORY_ID) Integer inventoryId){
        return new ResponseEntity<>(inventoryService.get(inventoryId), HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InventoryDo> save(@RequestBody InventoryDo inventoryDo){
        return new ResponseEntity<>(inventoryService.save(inventoryDo), HttpStatus.OK);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InventoryDo> update(@RequestBody InventoryDo inventoryDo){
        return new ResponseEntity<>(inventoryService.update(inventoryDo), HttpStatus.OK);
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> delete(@PathVariable(Constants.INVENTORY_ID) Integer inventoryId){
        return new ResponseEntity<>(inventoryService.delete(inventoryId), HttpStatus.OK);
    }
}
