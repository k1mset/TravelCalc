/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guidiscussionw4;

/*  File: GUIClass.java
*   Date: 4/3/2018
*   Author: Dillan Cobb
*   Purpose: This class will assit the MainClass in creating the initual GUI for
*   the program. It will controls the size of the frame, and its visibility.
*/

// Includes
import javax.swing.*;

public class GUIClass extends JFrame { 
    // Static variables used for default width and height
   static final int WIDTH = 400, HEIGHT = 800;
   
   // Default object
   public GUIClass() {
       super("Default Frame");
       setFrame(WIDTH, HEIGHT);
   }
   
   // Object allows the customization of the Title of the frame
   public GUIClass(String title) {
       super(title);
       setFrame(WIDTH, HEIGHT);
   }
   
   // Object that allows customization of the Title of the frame, width, and
   // height.
   public GUIClass(String title, int width, int height) {
       super(title);
       setFrame(width, height);
   }
   
   // display method that sets the visibility of the frame to the user
   public void display() {
       setVisible(true);
   }
   
   // setFrame method that sets the width and height of the frame and what
   // the close operation does.
   public void setFrame(int width, int height){
       setSize(width, height);
       setLocationRelativeTo(null);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
   }
} 
