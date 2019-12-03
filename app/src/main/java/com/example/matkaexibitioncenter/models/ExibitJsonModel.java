package com.example.matkaexibitioncenter.models;

import java.util.ArrayList;

public class ExibitJsonModel {

    int numberOfItems;
    ArrayList<ExibitJsonModeltwo> eksponati;

    public ExibitJsonModel() {
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public ArrayList<ExibitJsonModeltwo> getEksponati() {
        return eksponati;
    }

    public void setEksponati(ArrayList<ExibitJsonModeltwo> eksponati) {
        this.eksponati = eksponati;
    }
}
