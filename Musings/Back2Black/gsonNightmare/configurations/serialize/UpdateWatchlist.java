package com.cbfacademy.apiassessment.serialize;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import com.cbfacademy.apiassessment.deserialize.DeserializeToObject;
import com.cbfacademy.apiassessment.model.CreateWatchlist;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class UpdateWatchlist {

    private DeserializeToObject deserializeToJSON;
    
    public UpdateWatchlist(DeserializeToObject deserializeToJSON) {
        this.deserializeToJSON = deserializeToJSON;
    }

    public void add() throws IOException{
// check if you can add an item to an arraylist but the list is actually a method 

    //     deserializeToJSON.deserializeToObject();


    //     // may have to implement a find method that finds the array items you wish to update, possible just see if you can replace the whole entry


    // }
    // public static void removeItem(List<Car> carList, String item){
    //     Iterator<Car> iterator = carList.iterator();
    //     while (iterator.hasNext()){
    //         Car car = iterator.next();
    //         if(item.equals(car.getName())){
    //             iterator.updateItem();
                
    //             break;
    //         }
    //     }
    // }

    // public static void updateItem(){
    //     // update each item in the watchlist and replace
    }
  
}
    //       Gson gson = new Gson();
    
    // List<CreateWatchlist> addItem = gson.fromJson("JSON STRING", new TypeToken<List<CreateWatchlist>>() {}.getType());

    // CreateWatchlist addNewItem = new CreateWatchlist();

    // addItem.add(addNewItem);

    // String json = gson.toJson(addItem);
    // made obsolete wih the new deserializeToObject 
