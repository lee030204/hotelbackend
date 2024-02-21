package com.example.mysql_connect.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.mysql_connect.model.Hotel;
import com.example.mysql_connect.repositary.HotelRepo;

@Service
public class HotelService {
    
    private HotelRepo hotelRepo;

    public HotelService(HotelRepo hotelRepo) {
        this.hotelRepo = hotelRepo;
    }

    @SuppressWarnings("null")
    public boolean saveHotel(Hotel hotel){

        try{
            hotelRepo.save(hotel);
            
        }
        catch(Exception e){

            System.out.println(" \n exception \n");
            System.out.println(e.getMessage());
            System.out.println(" \n exception \n");

            return false;
        }

        return true;
    }

    public List<Hotel> getAllHotel(){
        //try{

            return hotelRepo.findAll();
            //retrun true; 
        //}
        //catch{ 
    
        //}
    }


    public Optional<Hotel> getHotelById(int id){
        return hotelRepo.findById(id);
    }




//     public boolean getByIdToDelete(int id)
//     {
//         Hotel hotel = hotelRepo.findById(id).orElse(null);
//         if(hotel==null)
//         {
//             return true;
//         }
//         return false;
//     }


//     @SuppressWarnings("null")
//     public boolean deleteByName(int id)
//     {
//         if(getByIdToDelete(id)==true)
//         {
//             return false;
//         }
//         HotelRepo.deleteById(id);
//         return true;
//         
//     }
public boolean getByIdToDelete(int hotelNo)
    {
        Hotel hotel= hotelRepo.findById(hotelNo).orElse(null);
        if(hotel==null)
        {
            return true;
        }
        return false;
    }

    public boolean deleteByName(int hotelNo)
    {
        if(getByIdToDelete(hotelNo)==true)
        {
            return false;
        }
        hotelRepo.deleteById(hotelNo);
        return true;
        
    }
//put
    public boolean update(int HotelId,Hotel hotel)
    {
        if(getByIdToDelete(HotelId))
        {
            return false;
        }
        else
        {

            hotelRepo.save(hotel);
            return true;
        }
    }/**
 * @param HotelId
 * @return
 */

public boolean getByIdToDelete(int HotelId)
    {
        Hotel hotel = hotelRepo.findById(HotelId).orElse(null);
        if(hotel==null)
        {
            return true;
        }
        else
        {

            return false;
        }
    }
}