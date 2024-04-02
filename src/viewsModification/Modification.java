/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewsModification;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Asus
 */
public class Modification implements Serializable {
    
    private String idNo;
    private String sizeNo;
    private LocalDate submissionDate;

    public Modification(String idNo, String sizeNo, LocalDate submissionDate) {
        this.idNo = idNo;
        this.sizeNo = sizeNo;
        this.submissionDate = submissionDate;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getSizeNo() {
        return sizeNo;
    }

    public void setSizeNo(String sizeNo) {
        this.sizeNo = sizeNo;
    }

    public LocalDate getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(LocalDate submissionDate) {
        this.submissionDate = submissionDate;
    }

    @Override
    public String toString() {
        return "Modification{" + "idNo=" + idNo + ", sizeNo=" + sizeNo + ", submissionDate=" + submissionDate + '}';
    }
    
    
    
    
}
