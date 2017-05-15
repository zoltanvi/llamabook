/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package llamabook.model.bean;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Attila
 */
public class DeletableProfs {
    
   private HashMap<String, String> profilok;
   
   public DeletableProfs(){
       this.profilok = new HashMap<>();
   }
   
   public void add(String email, String nev){
       this.profilok.put(email, nev);
   }
   
   public HashMap<String, String> getDeleteableProfs(){
       return this.profilok;
   }
   
   public String getEmailByName(String name){
       for(Map.Entry<String, String> entry : this.profilok.entrySet()){
           if(entry.getValue().equals(name)){
               return entry.getKey();
           }
       }
       return null;
   }
    
}
