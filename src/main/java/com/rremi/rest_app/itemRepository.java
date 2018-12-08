package com.rremi.rest_app;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface itemRepository extends JpaRepository<Item,Long> {

    //find all the items of a user
    List<Item> findAllByItemOwner(User user);
}
