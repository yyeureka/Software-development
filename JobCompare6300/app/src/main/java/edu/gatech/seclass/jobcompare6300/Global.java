package edu.gatech.seclass.jobcompare6300;

public class Global {
    private static PersistenceDataModel presistenceDataModel = new PersistenceDataModel();
    private static DataModel dataModel = new DataModel(presistenceDataModel);
    
    public static DataModel getDataModel() {
        return dataModel;
    }
}
