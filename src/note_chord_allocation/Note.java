package note_chord_allocation;

/**
 * Diese Klasse implementiert ein Array, in dem alle Stammtöne (Noten) der Reihe
 * nach aufgelistet sind. Das ist für viele Teilaufgaben bei der Komposition 
 * äußerst wichtig. 
 * 
 * @author Andre Zahn
 */
public class Note {
    
    private String[] allNotes = {"c", "db", "d", "eb", "e", "f", "gb", "g", 
            "ab", "a", "bb", "b"};
    
    public String[] getAllNotes() {
        
        return allNotes;
        
    }
    
}