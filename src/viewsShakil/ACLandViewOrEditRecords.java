/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewsShakil;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Asus
 */
public class ACLandViewOrEditRecords implements Serializable {
    private String plotNo;
    private String khatianNo;
    private String presentPossessor;
    private String district;
    private String upazilla;
    private String mouza;
    private String size;
    private String value;
    private LocalDate recordingDate;

    public ACLandViewOrEditRecords(String plotNo, String khatianNo, String presentPossessor, String district, String upazilla, String mouza, String size, String value, LocalDate recordingDate) {
        this.plotNo = plotNo;
        this.khatianNo = khatianNo;
        this.presentPossessor = presentPossessor;
        this.district = district;
        this.upazilla = upazilla;
        this.mouza = mouza;
        this.size = size;
        this.value = value;
        this.recordingDate = recordingDate;    
    }

    public String getPlotNo() {
        return plotNo;
    }

    public void setPlotNo(String plotNo) {
        this.plotNo = plotNo;
    }

    public String getKhatianNo() {
        return khatianNo;
    }

    public void setKhatianNo(String khatianNo) {
        this.khatianNo = khatianNo;
    }

    public String getPresentPossessor() {
        return presentPossessor;
    }

    public void setPresentPossessor(String presentPossessor) {
        this.presentPossessor = presentPossessor;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getUpazilla() {
        return upazilla;
    }

    public void setUpazilla(String upazilla) {
        this.upazilla = upazilla;
    }

    public String getMouza() {
        return mouza;
    }

    public void setMouza(String mouza) {
        this.mouza = mouza;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public LocalDate getRecordingDate() {
        return recordingDate;
    }

    public void setRecordingDate(LocalDate recordingDate) {
        this.recordingDate = recordingDate;
    }

    @Override
    public String toString() {
        return "ACLandViewOrEditRecords{" + "plotNo=" + plotNo + ", khatianNo=" + khatianNo + ", presentPossessor=" + presentPossessor + ", district=" + district + ", upazilla=" + upazilla + ", mouza=" + mouza + ", size=" + size + ", value=" + value + ", recordingDate=" + recordingDate + '}';
    }

    
    
     
    
}
