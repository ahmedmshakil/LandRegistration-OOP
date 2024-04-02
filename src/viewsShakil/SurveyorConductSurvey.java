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
public class SurveyorConductSurvey implements Serializable{
    private String plotNo;
    private String khatianNo;
    private LocalDate submissionDate;

    public SurveyorConductSurvey(String plotNo, String khatianNo, LocalDate submissionDate) {
        this.plotNo = plotNo;
        this.khatianNo = khatianNo;
        this.submissionDate = submissionDate;
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

    public LocalDate getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(LocalDate submissionDate) {
        this.submissionDate = submissionDate;
    }

    @Override
    public String toString() {
        return "SurveyorConductSurvey{" + "plotNo=" + plotNo + ", khatianNo=" + khatianNo + ", submissionDate=" + submissionDate + '}';
    }
    
    
    
    
}
