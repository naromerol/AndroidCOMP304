package com.example.nestorromero_comp304sec004_lab2_ex1.data;

import java.util.ArrayList;

/**
 * COMP304 - Assignment 2
 * Nestor Romero - 301133331
 *
 * Class to encapsulate data related logic and functionality
 */
public class DataService {

    //Internal variables for keeping singleton reference and the app dummy data
    final private ArrayList<RealEstateUnit> unitList = new ArrayList<RealEstateUnit>();
    private static DataService service = null;

    /**
     * Singleton getInstance method
     * @return
     */
    public static DataService getInstance() {
        if (service == null) {
            service = new DataService();
            service.createDummyData();
        }
        return service;
    }

    /**
     * Privatve constrauctor for singleton
     */
    private DataService(){}

    /**
     * Method to obtain a list of real estate unit by type
     * @param type
     * @return
     */
    public ArrayList<RealEstateUnit> getUnitsByType(RealEstateUnitType type) {
        ArrayList<RealEstateUnit> result = new ArrayList<RealEstateUnit>();
        for (RealEstateUnit unit : unitList) {
            if (unit.getType() == type)
                result.add(unit);
        }
        return result;
    }

    /**
     * Method to obtain a real estate unit given its id
     * @param id
     * @return
     */
    public RealEstateUnit getUnitById(String id){
        for (RealEstateUnit unit : unitList) {
            if (unit.getId().equals(id))
                return unit;
        }
        return null;
    }

    /**
     * Method for creating dummy data for the app
     */
    private void createDummyData() {
        //Apartments
        this.unitList.add(new RealEstateUnit(RealEstateUnitType.APARTMENT, "ap01",
                "Roadview Avenue 123", 1500));
        this.unitList.add(new RealEstateUnit(RealEstateUnitType.APARTMENT, "ap02",
                "Woodvine Road 123", 2500));
        this.unitList.add(new RealEstateUnit(RealEstateUnitType.APARTMENT, "ap03",
                "Pelican Road 123", 3500));
        this.unitList.add(new RealEstateUnit(RealEstateUnitType.APARTMENT, "ap04",
                "Richmond Street 123", 4500));

        //Condos
        this.unitList.add(new RealEstateUnit(RealEstateUnitType.CONDO, "co01",
                "Primrose Boulevard 123 Unit 1", 1500));
        this.unitList.add(new RealEstateUnit(RealEstateUnitType.CONDO, "co02",
                "Melrose Promenade Unit 1560", 2500));

        //Detached
        this.unitList.add(new RealEstateUnit(RealEstateUnitType.DETACHED, "de01",
                "Roadview Avenue 123", 1500));
        this.unitList.add(new RealEstateUnit(RealEstateUnitType.DETACHED, "de02",
                "Woodwind Road 123", 2500));
        this.unitList.add(new RealEstateUnit(RealEstateUnitType.DETACHED, "de03",
                "Pelican Road 123", 3500));
        this.unitList.add(new RealEstateUnit(RealEstateUnitType.DETACHED, "de04",
                "Richmond Street 123", 4500));

        //Semidetached
        this.unitList.add(new RealEstateUnit(RealEstateUnitType.SEMIDETACHED, "se01",
                "Alvarose Avenue 123", 1500));
        this.unitList.add(new RealEstateUnit(RealEstateUnitType.SEMIDETACHED, "se02",
                "Medina Street 123", 2500));

        //Townhouse
        this.unitList.add(new RealEstateUnit(RealEstateUnitType.TOWNHOUSE, "th01",
                "Spadina Boulevard 123", 1500));
        this.unitList.add(new RealEstateUnit(RealEstateUnitType.TOWNHOUSE, "th02",
                "Roma Avenue 123", 2500));
        this.unitList.add(new RealEstateUnit(RealEstateUnitType.TOWNHOUSE, "th03",
                "Yonge Street 123", 3500));
        this.unitList.add(new RealEstateUnit(RealEstateUnitType.TOWNHOUSE, "th04",
                "Queen Road 123", 4500));
    }

}
