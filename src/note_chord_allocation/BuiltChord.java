package note_chord_allocation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * In dieser Klasse befindet sich die Main Methode. Dem Nutzer werden alle Töne 
 * angezeigt und er wird aufgefordert sich einen Grundton auszusuchen. 
 * Daraufhin werden 5 Akkorde ausgegeben, die auf diesem basieren. 
 * 
 * @author Andre Zahn
 */
public class BuiltChord {
    
    public static void main(String[] args) {
        
        /**
         * Vorinformationen für den Nutzer werden ausgegeben.
         */
        System.out.println("Bitte geben Sie einen Note als Grundton ein.\n"
                + "Zur Auswahl stehen folgende 12 Noten.");
        
        Note note = new Note();
        String[] allNotes = note.getAllNotes();
        System.out.println(Arrays.toString(allNotes));
        
        System.out.println("Bitte nutzen Sie zur Eingabe kleine Buchstaben.");
        
        Scanner scanner = new Scanner(System.in);
        
        /**
         * Hier wird sichergestellt, dass auch nach einer falschen Eingabe 
         * die Eingabeoption erneut gefolgt von der Programm-Logik aufgerufen
         * wird.
         */
        while (true) {    
        
            String root = scanner.nextLine();
        
            /**
             * Im Falle einer richtigen Eingabe wird der Index des Tones im
             * Array ermittelt. Dieser ist für weitere Berechnungen 
             * entscheidend.
             */
            int rootIndex = -1;
            for (int i = 0; i < allNotes.length; i++) {
            
                if (allNotes[i].equals(root)) {
                    rootIndex = i;
                    break;
                    
                }
            }
            
            /**
             * Falls die Eingabe korrekt war, wird die Programmlogik auf-
             * gerufen und das Ergebnis ausgegeben.
             */
            if (rootIndex != -1) {
            
                System.out.println("Sie haben sich für den Grundton " + root
                        + " entschieden.\nAuf ihm basieren folgende Akkorde:"); 

                /**
                 * Eine ArrayList wird erstellt um die Instanzen der
                 * verschiedenen Akkordtypen zusammenzufassen. 
                 */
                List<Triad> triads = new ArrayList<>();
                
                /**
                 * Instanzen der verschiedenen Akkordtypen werden der ArrayList
                 * hinzugefügt.
                 */
                triads.add(new Major());
                triads.add(new Minor());
                triads.add(new SusFour());
                triads.add(new Augmented());
                triads.add(new Diminished());
                
                /**
                 * Die Methode, welche die gesammelten Ausgaben übergibt wird
                 * aufgerufen.
                 */
                TriadBuilder triadBuilder = new TriadBuilder();
                TriadBuilder.triadsOut(triads, allNotes, rootIndex);
                
                /**
                 * Eine ArrayList wird erstellt, nimmt die Ausgaben an und 
                 * gibt sie auf der Konsole aus. 
                 */
                List<String> completeOutput = triadBuilder.getCollectedOutput();
                for (String output : completeOutput) {
                    System.out.println(output);
                }
                
                break;
            
                /**
                 * Falls die Eingabe nicht korrekt war, wird der Nutzer 
                 * aufgefordert, eine valide Eingabe zu tätigen.
                 */    
            } else {
                
                System.out.println("Die Eingabe stellt keine Note dar. Bitte"
                        + "geben Sie eine der oben genannten Noten ein."); 
                
            }
            
        }
        
        scanner.close();
        
    }
    
}