package application.models;

import application.controllers.CellController;

/**
 * @Auther: Luca Grasso
 * @Date: 2022/05/25
 * @LastModified: 2022/05/26
 */
public class CellModel {


    public CellController cellController;



    public CellModel(CellController cellController){
        this.cellController = cellController;

    }



}

