package main.java.com.apps.quantitymeasurement.repository;

import main.java.com.apps.quantitymeasurement.model.QuantityMeasurementEntity;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class QuantityMeasurementCacheRepository implements IQuantityMeasurementRepository{

    public static final String FILE_NAME = "quantity_measurement_repo.ser";

    List<QuantityMeasurementEntity> quantityMeasurementEntityCache;

    private static QuantityMeasurementCacheRepository instance;

    private QuantityMeasurementCacheRepository(){
        quantityMeasurementEntityCache = new ArrayList<>();

        loadFromDisk();
    }

    public static QuantityMeasurementCacheRepository getInstance(){
        if(instance == null) {
            instance = new QuantityMeasurementCacheRepository();
        }
        return instance;
    }
    @Override
    public void save(QuantityMeasurementEntity entry) {
        saveToDisk(entry);
    }

    @Override
    public List<QuantityMeasurementEntity> getAllMeasurements() {

        return List.of();
    }

    private void saveToDisk(QuantityMeasurementEntity entry){
        try{
            FileOutputStream fos = new FileOutputStream(FILE_NAME, true);
    //logic add here
             AppendableObjectOutputStream oos = new AppendableObjectOutputStream(fos);

             oos.writeObject(entry);
        }catch(IOException e){
            System.out.println("Error Saving entry "+e.getMessage());
        }
    }

    private void loadFromDisk(){
        File file = new File(FILE_NAME);
        if(!file.exists()){
            //logic add here
        }
        try {
            FileInputStream fis = new FileInputStream(FILE_NAME);
            ObjectInputStream ois = new ObjectInputStream(fis);
       // }{
//            while(true){
//                try{
                    QuantityMeasurementEntity entry = (QuantityMeasurementEntity) ois.readObject();
                    quantityMeasurementEntityCache.add(entry);
//                }catch (EOFException e){
//                    break;
//                }
//            }
            System.out.println("Loaded "+ quantityMeasurementEntityCache.size() + " quantity measurement entities from storage");
        }catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading quantity measurement entities: "+e.getMessage());
        }
    }
}
