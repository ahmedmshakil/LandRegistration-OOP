/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewsHamim;
import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author ASUS
 */
public class BalamBook implements Serializable
        {
    
    private String pageNo;
    private String areaType;
    private String details;
    private LocalDate balamBookDate;

    public BalamBook(String pageNo, String areaType, String details, LocalDate balamBookDate) {
        this.pageNo = pageNo;
        this.areaType = areaType;
        this.details = details;
        this.balamBookDate = balamBookDate;
    }

    public String getPageNo() {
        return pageNo;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    public String getAreaType() {
        return areaType;
    }

    public void setAreaType(String areaType) {
        this.areaType = areaType;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDate getBalamBookDate() {
        return balamBookDate;
    }

    public void setBalamBookDate(LocalDate balamBookDate) {
        this.balamBookDate = balamBookDate;
    }
}
    
