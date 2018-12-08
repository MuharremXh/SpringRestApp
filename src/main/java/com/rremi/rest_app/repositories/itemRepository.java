package com.rremi.rest_app.repositories;

import com.rremi.rest_app.entities.Item;
import com.rremi.rest_app.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface itemRepository extends JpaRepository<Item,Long> {

    //find all the items of a user
    List<Item> findAllByItemOwner(User user);
}
