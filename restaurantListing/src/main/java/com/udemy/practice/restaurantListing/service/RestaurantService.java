package com.udemy.practice.restaurantListing.service;

import com.udemy.practice.restaurantListing.dto.RestaurantDTO;
import com.udemy.practice.restaurantListing.entity.Restaurant;
import com.udemy.practice.restaurantListing.mapper.RestaurantMapper;
import com.udemy.practice.restaurantListing.repository.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepo restaurantRepo;

    public List<RestaurantDTO> findAllRestaurants() {
        List<Restaurant> restaurants = restaurantRepo.findAll();
        //map it to list of DTO
        List<RestaurantDTO> restaurantDTOS = restaurants.stream().map(restaurant -> RestaurantMapper.MAPPER.mapRestaurantToRestaurantDTO(restaurant)).collect(Collectors.toList());
        return restaurantDTOS;
    }
}
