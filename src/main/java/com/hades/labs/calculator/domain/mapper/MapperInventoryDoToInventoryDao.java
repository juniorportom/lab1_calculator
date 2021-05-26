package com.hades.labs.calculator.domain.mapper;
import com.hades.labs.calculator.dataprovider.jpa.entities.InventoryDao;
import com.hades.labs.calculator.domain.entities.InventoryDo;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MapperInventoryDoToInventoryDao {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    InventoryDao map(@MappingTarget InventoryDao inventoryDao, InventoryDo inventoryDo);
}
