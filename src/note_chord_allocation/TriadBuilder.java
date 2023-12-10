package note_chord_allocation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * In dieser Klasse werden Dreiklänge (Englisch: Triad) anhand des Grundtons
 * ermittelt, aufgebaut und gesammelt.
 * 
 * @author Andre Zahn 
 */
public class TriadBuilder {
    
    /**
     * Eine ArrayList in der die fertigen Ausgaben gesammelt werden.
     */
    private static List<String> collectedOutput = new ArrayList<>();
    
    /**
     * Die Ausgabe-Statements für die einzelnen Akkorde werden zusammen gesetzt
     * und gesammelt. 
     */
    public static void triadsOut(List<Triad> triads, String[] allNotes, 
            int rootIndex) {
        
        for (Triad triad : triads) {
            String[] notesOfTriad = buildTriad(allNotes, rootIndex, 
                    triad.getParameters());
            String output = triad.gender + ": " + Arrays.toString(notesOfTriad);
            
            collectedOutput.add(output);
        }
        
    }
    
    /**
     * Die Töne der verschiedenen Dreiklänge werden berechnet. 
     */
    public static String[] buildTriad(String[] allNotes, int rootIndex, 
            Object[]getParameters) {
        
        /**
         * Ein Dreiklang besteht aus 3 Tönen.
         */
        String[] notesOfTriad = new String[3];
        
        /**
         * Der Grundton ist der erste der drei Töne.
         */
        notesOfTriad[0] = allNotes[rootIndex];
        
        int intervalOne = (int)getParameters[1];
        int intervalTwo = (int)getParameters[2];
        
        /**
         * Hier werden die Indizes der Terz (Englisch third) und der Quinte 
         * (Englisch fifth) gesucht, welche neben dem Grundton die anderen 
         * beiden Töne in einem Dreiklang darstellen. Über eine zirkuläre Suche
         * wird sichergestellt, dass es beim Suchen nach dem letzten Ton wieder
         * beim ersten losgeht. Dieser wäre nach dem letzten Ton der Nächste.
         */
        for (int i = 0; i < 24; i++) {
            
            int thirdIndex = (rootIndex + intervalOne) % 12;
            int fifthIndex = (rootIndex + intervalTwo) % 12;
            notesOfTriad[1] = allNotes[thirdIndex];
            notesOfTriad[2] = allNotes[fifthIndex];
        
        }
        
        return notesOfTriad;
        
    }
    
    public List<String> getCollectedOutput() {
        return new ArrayList<>(collectedOutput);
    }

}
