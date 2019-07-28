package com.halif.avi.crud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.halif.avi.model.ItemInStock;

@Repository
public interface ItemRepository extends CrudRepository<ItemInStock, Integer>
{
	
}
