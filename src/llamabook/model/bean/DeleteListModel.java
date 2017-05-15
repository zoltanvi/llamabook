/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package llamabook.model.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.event.EventListenerList;

// DeleteListModel extends AbstractListModel
  // public DeleteListModel(List<String> nevek, HashMap<String, String> delete)

public class DeleteListModel extends AbstractListModel {
    
    public DeleteListModel(List<String> nevek, HashMap<String, String> delete){
        nevek = new ArrayList<String>();
        delete = new HashMap<String, String>();
        

    }

    public EventListenerList getListenerList() {
        return listenerList;
    }

    public void setListenerList(EventListenerList listenerList) {
        this.listenerList = listenerList;
    }
   
    
    @Override
    public int getSize() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getElementAt(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
