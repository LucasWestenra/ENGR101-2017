// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP102 - 2017T1
 * Name:
 * Username:
 * ID:
 */


import ecs100.*;
import java.awt.Color;
import javax.swing.JColorChooser;

/** TricolourFlagDrawer: draws a series of tricolour flags */
public class TricolourFlagDrawer{

    public static final double width = 200;
    public static final double height = 133;

    /** Constructor: set up user interface */
    public TricolourFlagDrawer(){
        UI.initialise();
        UI.addButton("Clear", UI::clearPanes );
        UI.addButton("Core", this::doCore );
        UI.addButton("Completion", this::doCompletion );
        UI.addButton("Challenge", this::doChallenge );
        UI.addButton("Quit", UI::quit );
    }

    /**
     * asks user for a position and three colours, then calls the 
     * drawThreeColourFlagCore method, passing the appropriate arguments
     *
     * CORE
     */
    public void doCore(){
        double left = UI.askDouble("left of flag");
        double top = UI.askDouble("top of flag");
        UI.println("Now choose the colours");
        Color stripe1 = JColorChooser.showDialog(null, "First Stripe", Color.white);
        Color stripe2 = JColorChooser.showDialog(null, "Second Stripe", Color.white);
        Color stripe3 = JColorChooser.showDialog(null, "Third Stripe", Color.white);
        this.drawThreeColourFlagCore(left, top, stripe1, stripe2, stripe3 );
    }

    /**
     * draws a three colour flag consisting of three vertical equal-width stripes
     * at the given position
     *
     * CORE
     */
    public void drawThreeColourFlagCore(double left, double top,  Color stripe1, Color stripe2, Color stripe3){
        UI.setColor(stripe1);
        UI.fillRect(left, top, width/3, height);
        UI.setColor(stripe2);
        UI.fillRect(left+(width/3), top, width/3, height);
        UI.setColor(stripe3);
        UI.fillRect(left+(2*width/3), top, width/3, height);
        UI.setColor(Color.black);
        UI.drawRect(left, top, width, height);
    }

    /**
     * draws multiple flag made up of three equal size stripes by calling the
     * drawThreeColourFlagCompletion method, passing the appropriate arguments
     *
     * COMPLETION
     */
    public void doCompletion(){
        double left=100;
        double top=20;
        this.drawThreeColourFlagCompletion(true, 20, 50, Color.black, Color.yellow, Color.red);               // Belgium
        this.drawThreeColourFlagCompletion(false, 250, 100, Color.black, Color.red, Color.yellow);            // Germany
        this.drawThreeColourFlagCompletion(true, 140, 430, Color.blue, Color.white, Color.red);               // France
        this.drawThreeColourFlagCompletion(true, 290, 270, Color.red, Color.yellow, Color.green.darker());    // Guinea
        this.drawThreeColourFlagCompletion(false, 470, 30, Color.red, Color.white, Color.blue);               // The Netherlands
        this.drawThreeColourFlagCompletion(false, 50, 250, Color.white, Color.blue, Color.red);               // Russia
    }

    /**
     * draws a three colour flag consisting of three equal-size stripes
     * at the given position
     * The stripes can be either vertical or horizontal
     *
     * COMPLETION
     */
    public void drawThreeColourFlagCompletion( boolean vertical, double left, double top, Color stripe1, Color stripe2, Color stripe3 ){
        if( vertical == true ){
            UI.setColor(stripe1);
            UI.fillRect(left, top, width/3, height);
            UI.setColor(stripe2);
            UI.fillRect(left+(width/3), top, width/3, height);
            UI.setColor(stripe3);
            UI.fillRect(left+(2*width/3), top, width/3, height);
            UI.setColor(Color.black);
            UI.drawRect(left, top, width, height);
        }
        else{
            UI.setColor(stripe1);
            UI.fillRect(left, top, width, height/3);
            UI.setColor(stripe2);
            UI.fillRect(left, top+(height/3), width, height/3);
            UI.setColor(stripe3);
            UI.fillRect(left, top+(2*height/3), width, height/3);
            UI.setColor(Color.black);
            UI.drawRect(left, top, width, height);
        }
    }

    public void doChallenge(){
        this.drawThreeColourFlagCompletion(true, 20, 20, Color.black, Color.yellow, Color.red);               
        UI.drawString("Belgium", 20+(width/3), 25+height);
        this.drawThreeColourFlagCompletion(false, 20, 30+height, Color.black, Color.red, Color.yellow);            
        // Germany
        this.drawThreeColourFlagCompletion(true, 20, 40+height*2, Color.blue, Color.white, Color.red);               
        // France
        this.drawThreeColourFlagCompletion(true, 30+width, 20, Color.red, Color.yellow, Color.green.darker());    
        // Guinea
        this.drawThreeColourFlagCompletion(false, 30+width, 30+height, Color.red, Color.white, Color.blue);               
        // The Netherlands
        this.drawThreeColourFlagCompletion(false, 30+width, 40+height*2, Color.white, Color.blue, Color.red);
        // Russia
    }
}
