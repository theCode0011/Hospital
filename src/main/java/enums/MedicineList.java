package enums;

public enum MedicineList {

    PARACETAMOL("one drug to treat em all!"),
    AUGMENTIN("strong antibiotic"),
    LYSOPAINE("treats throat pain"),
    IBUPROFENE("treats inflammations"),
    XANAX("treats anxiety"),
    DACTARIN("treats smelly feet"),
    CAFFEINE("makes you less sleepy"),
    PENICILIN("treats stuff"),
    INSULIN("treats diabetes");

    private  final String medicineList;

    MedicineList(String medicineList){
        this.medicineList=medicineList;
    }

    public String getValue(){
        return medicineList;
    }
}
