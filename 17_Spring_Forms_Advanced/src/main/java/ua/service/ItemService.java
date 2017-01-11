package ua.service;

import java.util.List;

import ua.entity.Item;

public interface ItemService {

	List<Item> findAll();

	void delete(int id);

	void save(Item item);

}
