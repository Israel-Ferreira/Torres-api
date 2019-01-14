package br.com.codekaffe.Towers.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.Period;

@Document
public class Tower {
    @Id
    private String id;

    private String name;

    private double height;

    private LocalDate inagurationDate;


    private int floorNumber;

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public LocalDate getInagurationDate() {
        return inagurationDate;
    }

    public void setInagurationDate(LocalDate inagurationDate) {
        this.inagurationDate = inagurationDate;
    }

    public int getTowerAge(){
        LocalDate hoje = LocalDate.now();
        Period tempo = Period.between(inagurationDate,hoje);
        return tempo.getYears();
    }




}
