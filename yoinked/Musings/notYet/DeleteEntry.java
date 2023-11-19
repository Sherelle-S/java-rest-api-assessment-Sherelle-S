package com.cbfacademy.apiassessment.deserialize;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.reflect.TypeToken;

public class DeleteEntry {
    // find a way to do this codewars style, if you can search the deserializd object by Id number would be best, then slice the entry out of the array before serializing it again
    // will probably have to use recursion 
//     public void deleteEntry(){
//         return;
//     }
// }
public DeserializeToObject back;


 public DeleteEntry(DeserializeToObject back) {
    this.back = back;
}
// public void delete(){

//             // back.deserializeToObject();
//             deleteEntry(item).removeItem().
//             // serializeToFile();
//         }


//         public static void deleteEntry(){
//              removeItem(item)
//         }
//         public static List<Car> deserializeToObject(){
//         String jsonString = gson.toJson(createList);

//         List<Car> carList = gson.fromJson(jsonString, new TypeToken<List<Car>>() {}.getType());
//             if(carList == null) {
//                 carList = new ArrayList<>();
//             }
//         carList.add(createList);
//         return carList;
//     }

//     public static void removeItem(List<Car> carList, String item){
//         Iterator<Car> iterator = carList.iterator();
//         while (iterator.hasNext()){
//             Car car = iterator.next();
//             if(item.equals(car.getName())){
//                 iterator.remove();
                
//                 break;
//             }
//         }
//     }
    
}
