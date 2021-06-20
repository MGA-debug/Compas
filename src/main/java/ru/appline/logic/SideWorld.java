package ru.appline.logic;

import ru.appline.utils.Constant;

import java.util.ArrayList;
import java.util.List;

public class SideWorld {

    private static List<SideWorld> sideWorlds;
    private List<Integer> coordinates;
    private String name;

    public SideWorld() {
        super();
    }

    public SideWorld(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Integer> coordinates) {
        this.coordinates = coordinates;
    }

    public SideWorld addSide(String name, List<Integer> degree) {
        sideWorlds.add(new SideWorld(name));
        return this;
    }

    public static List<SideWorld> getAllSideWorld() {
        if (sideWorlds == null) {
            sideWorlds = new ArrayList<>();
            sideWorlds.add(new SideWorld(Constant.EAST));
            sideWorlds.add(new SideWorld(Constant.WEST));
            sideWorlds.add(new SideWorld(Constant.SOUTH));
            sideWorlds.add(new SideWorld(Constant.NORTH));
            sideWorlds.add(new SideWorld(Constant.NORTHWEST));
            sideWorlds.add(new SideWorld(Constant.NORTHEAST));
            sideWorlds.add(new SideWorld(Constant.SOUTHWEST));
            sideWorlds.add(new SideWorld(Constant.SOUTHEAST));
        }
        return sideWorlds;
    }

    public static SideWorld getSideByName(String name) {
        SideWorld sideWorld = null;
        for (SideWorld side : sideWorlds) {
            if (side.getName().equalsIgnoreCase(name)) {
                sideWorld = side;
            }
        }
        return sideWorld;
    }

    public static boolean checkSide(String name) {
        boolean real = false;
        for (SideWorld side : sideWorlds) {
            if (side.getName().equalsIgnoreCase(name)) {
                real = true;
                break;
            }
        }
        return real;
    }
}
