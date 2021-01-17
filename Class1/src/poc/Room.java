/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poc;

import java.util.Objects;

/**
 *
 * @author int105
 */
public class Room {
    private String roomId;

    public Room(String roomId) {
        this.roomId = roomId;
    }

    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Room other = (Room) obj;
        if (!Objects.equals(this.roomId, other.roomId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Room{" + "roomId=" + roomId + '}';
    }
    
    
}
