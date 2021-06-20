package ru.appline.logic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Model implements Serializable {

    private static final Model instance = new Model();
    private final static List<SideWorld> sideWorlds = SideWorld.getAllSideWorld();

    private Model() {

    }

    public static Model getInstance() {
        return instance;
    }

    public boolean fillIn(Map<String, String> map) {
        boolean isCorrect = false;
        for (Map.Entry<String, String> side : map.entrySet()) {
            String[] coordinates = side.getValue().split("-");
            List<Integer> range = new ArrayList<>();
            String name = side.getKey();
            if (SideWorld.checkSide(name)) {
                isCorrect = true;
                int firstCoordinate = Integer.parseInt(coordinates[0]);
                int secondCoordinates = Integer.parseInt(coordinates[1]);
                int rangeDegree;

                if (firstCoordinate > secondCoordinates) {
                    rangeDegree = 360 - firstCoordinate + secondCoordinates;
                } else {
                    rangeDegree = secondCoordinates - firstCoordinate;
                }

                for (int i = firstCoordinate; rangeDegree >= 0; rangeDegree--, i++) {
                    if (i == 360) {
                        i = 1;
                    }
                    range.add(i);
                }
                SideWorld.getSideByName(name).setCoordinates(range);
            } else {
                isCorrect = false;
                break;
            }
        }
        return isCorrect;
    }

    public static String searchSide(int degree) {
        String result = "";
        if (degree > 360) {
            degree = degree % 360;
        }
        for (SideWorld side : sideWorlds) {
            if (side.getCoordinates().contains(degree)) {
                result = side.getName();
                break;
            }
        }
        return result;
    }
}


