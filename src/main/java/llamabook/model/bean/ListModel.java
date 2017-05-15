/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package llamabook.model.bean;

// TODO: kell egy ListModel osztály, aminek a konstruktora kapja a dp-t és a neveket
// ezt eltárolja saját privát adattagként

public class ListModel {
    private DeletableProfs dp;
    
    public ListModel(DeletableProfs dp){
        this.dp = dp;
    }

    public DeletableProfs getDp() {
        return dp;
    }

    public void setDp(DeletableProfs dp) {
        this.dp = dp;
    }
    
    
}
