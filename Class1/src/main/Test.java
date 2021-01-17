/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import poc.Building;
import poc.Room;

/**
 *
 * @author int105
 */
public class Test {
    public static void main(String[] args) {
        Room mainRooms[] =new Room[5];
        Room r1=new Room("cb2301");
        Room r2=new Room("Training1");
        mainRooms[0]=r1;
        mainRooms[1]=r2;
    
        Building b1=new Building(mainRooms);
        b1.listRooms();
    }
}
