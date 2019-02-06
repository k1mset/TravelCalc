/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guidiscussionw4;

/*  File: GUIDiscussionW4.java
*   Date: 4/3/2018
*   Author: Dillan Cobb
*   Purpose: This main class will create and display the GUI for use by the end
*   user.
*/

public class GUIDiscussionW4 extends GUIClass {
    // Default object that will name the frame, size the frame and call the 
    // frame created
    GUIDiscussionW4() {
        super("Travel Calculator", 350, 300);
        add(new GUIPanel());
    }
    
    // Creates the object and displays the gui frame to the user.
    static public void main(String[] args)  {
        GUIDiscussionW4 week4Disc = new GUIDiscussionW4();
        week4Disc.display();
    }
}
