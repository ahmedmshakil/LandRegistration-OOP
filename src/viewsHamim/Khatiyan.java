/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewsHamim;

/**
 *
 * @author ASUS
 */
import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author ASUS
 */
public class Khatiyan implements Serializable
        {
    
    private String khatiyan;
    private String areaType;
    private String areaAmount;
    private LocalDate khatiyanDate;

    public Khatiyan(String khatiyan, String areaType, String areaAmount, LocalDate khatiyanDate) {
        this.khatiyan = khatiyan;
        this.areaType = areaType;
        this.areaAmount = areaAmount;
        this.khatiyanDate = khatiyanDate;
    }

    public String getKhatiyan() {
        return khatiyan;
    }

    public void setKhatiyan(String khatiyan) {
        this.khatiyan = khatiyan;
    }

    public String getAreaType() {
        return areaType;
    }

    public void setAreaType(String areaType) {
        this.areaType = areaType;
    }

    public String getAreaAmount() {
        return areaAmount;
    }

    public void setAreaAmount(String areaAmount) {
        this.areaAmount = areaAmount;
    }

    public LocalDate getKhatiyanDate() {
        return khatiyanDate;
    }

    public void setKhatiyanDate(LocalDate khatiyanDate) {
        this.khatiyanDate = khatiyanDate;
    }
    
}

