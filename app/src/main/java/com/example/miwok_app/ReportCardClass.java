package com.example.miwok_app;

public class ReportCardClass {
    private String mathsGrade,englishGrade,physicsGrade,chemistryGrade,
            attendenceGrade,ipGrade,mName,std;
    public ReportCardClass(String mName,String std,String mathsGrade,
                           String physicsGrade,String chemistryGrade,
             String englishGrade,String ipGrade,String attendenceGrade){
        this.mName=mName;
        this.std=std;
        this.mathsGrade=mathsGrade;
        this.physicsGrade=physicsGrade;
        this.chemistryGrade=chemistryGrade;
        this.englishGrade=englishGrade;
        this.ipGrade=ipGrade;
        this.attendenceGrade=attendenceGrade;
    }
    public String getResult() {
        return "Name: "+mName+"\nStandard"+std+"\nMaths:"+mathsGrade+"\nPhysics:"
                +physicsGrade+"\nChemistry:"+ chemistryGrade+
                "\nEnglish: "+englishGrade+"\nInformatic Practices: "
                +ipGrade+"\nAttendence: "+attendenceGrade;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getStd() {
        return std;
    }

    public void setStd(String std) {
        this.std = std;
    }

    public String getMathsGrade() {
        return mathsGrade;
    }

    public void setMathsGrade(String mathsGrade) {
        this.mathsGrade = mathsGrade;
    }

    public String getEnglishGrade() {
        return englishGrade;
    }

    public void setEnglishGrade(String englishGrade) {
        this.englishGrade = englishGrade;
    }

    public String getPhysicsGrade() {
        return physicsGrade;
    }

    public void setPhysicsGrade(String physicsGrade) {
        this.physicsGrade = physicsGrade;
    }

    public String getChemistryGrade() {
        return chemistryGrade;
    }

    public void setChemistryGrade(String chemistryGrade) {
        this.chemistryGrade = chemistryGrade;
    }

    public String getAttendenceGrade() {
        return attendenceGrade;
    }

    public void setAttendenceGrade(String attendenceGrade) {
        this.attendenceGrade = attendenceGrade;
    }

    public String getIpGrade() {
        return ipGrade;
    }

    public void setIpGrade(String ipGrade) {
        this.ipGrade = ipGrade;
    }
}
