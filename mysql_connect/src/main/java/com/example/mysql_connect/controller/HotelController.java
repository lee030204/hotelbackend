package com.example.mysql_connect.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.mysql_connect.model.Hotel;
import com.example.mysql_connect.service.HotelService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class HotelController 
{

    private HotelService hotelService;



    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @SuppressWarnings("rawtypes")
    @PostMapping("/api/hotel")
    public ResponseEntity postMethodName(@RequestBody Hotel hotel) {

        if(hotelService.saveHotel(hotel) == true){
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
    }

    @GetMapping("/api/hotels")
    public List<Hotel> getAllDetail() {
        return hotelService.getAllHotel();
    }


    @GetMapping("/api/hotels/{hotelId}")
    public Optional<Hotel> getDetailById(@PathVariable int hotelId) {
        return hotelService.getHotelById(hotelId);
    }
    
    /**
    // 
     */
//     @DeleteMapping("/delete/{hotelId}")
//     public ResponseEntity<Hotel> deleteById(@PathVariable ("hotelId") int Id)
//     {
//         if(hotelService.getByIdToDelete(Id)==true)
//         {
//             return new ResponseEntity<>(HttpStatus.OK)
//         }
// //         else
// //         {
// //             return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
// //         }
//     }
@DeleteMapping("/delete/{hotelNo}")
    public ResponseEntity<Hotel> deleteById(@PathVariable int hotelNo)
    {
        if(hotelService.deleteByName(hotelNo)==true)
        {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

@PutMapping("/edit")
    public int update (@RequestParam int HotelId,@RequestBody Hotel hotel)
    {
        if(hotelService.update(HotelId,hotel))
        {
            return 1;
        }
        else
        {
            return 2;
        }
    }
}