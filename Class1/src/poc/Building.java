/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poc;

/**
 *
 * @author int105
 */
public class Building {
    private Room room[];
    
    public Building(int maxRooms){
        
    }
    
    public Building(Room[] rooms){
        this.room= rooms;
        for (int i = 0; i < room.length; i++) {
            
        }
    }
    
    public void listRooms() {
        for (int i = 0; i < room.length; i++) {
            if (room[i]!=null) {
                System.out.println(room[i]);
            }
        }
    }
}
