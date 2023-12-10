package note_chord_allocation;

/**
 * Diese abstrakte Klasse implementiert die Attribute, die alle Dreiklänge 
 * gemeinsam haben.
 * 
 * @author Andre Zahn
 */
public abstract class Triad {
    
    /**
     * Das Tongeschlecht bzw. der Name, der auf der Konsole zu sehen ist.
     */
    protected String gender;
    
    /**
     * Das erste Intervall stellt den Abstand vom Grundton zur Terz dar.
     */
    protected int intervalOne;
    
    /**
     * Das zweite Intervall stellt den Abstand vom Grundton zur Quinte dar.
     */
    protected int intervalTwo;
    
    public Triad(String gender, int intervalOne, int intervalTwo) {
        
        this.gender = gender;
        this.intervalOne = intervalOne;
        this.intervalTwo= intervalTwo;
        
    }
    
    /**
     * Über ein ObjektArray werden ihre Parameter übergeben.
     */
    public Object[] getParameters() {
        
        return new Object[] {gender, intervalOne, intervalTwo};
        
    }

}
