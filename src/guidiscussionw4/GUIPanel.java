/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guidiscussionw4;

/*  File: GUIPanel.java
*   Date: 4/3/2018
*   Author: Dillan Cobb
*   Purpose: This class is the bulk of the program. This will stylize the 
*   program by creating the GUI, buttons, labels, etc.. It will also respond to
*   the user clicking the button and handle the calulations accordingly to
*   return an appropriate amount of money back to the user.
*/

// Imports
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GUIPanel extends JPanel {
    // Creates all the GUI Labels
    private JLabel numPeopleLbl = new JLabel("Number of People:", 
        JLabel.CENTER);
    private JLabel numDaysLbl = new JLabel("Length of Trip(in days):", 
            JLabel.CENTER);
    private JLabel flightCostLbl = new JLabel("Cost of Flight:", JLabel.CENTER);
    private JLabel hotelCostLbl = new JLabel("Cost of Hotel:", JLabel.CENTER);
    private JLabel transCostLbl = new JLabel("Cost of Daily Transportation:",
        JLabel.CENTER);
    private JLabel foodCostLbl = new JLabel("Cost of Daily Food:", 
            JLabel.CENTER);
    private JLabel otherCostLbl = new JLabel("All Other Costs:", JLabel.CENTER);
    private JLabel startCashLbl = new JLabel("Starting Money:", JLabel.CENTER);
    // Creates all the GUI TextFields
    private JTextField numPeopleTxt = new JTextField("");
    private JTextField numDaysTxt = new JTextField("");
    private JTextField flightCostTxt = new JTextField("");
    private JTextField hotelCostTxt = new JTextField("");
    private JTextField transCostTxt = new JTextField("");
    private JTextField foodCostTxt = new JTextField("");
    private JTextField otherCostTxt = new JTextField("");
    private JTextField startCashTxt = new JTextField("");
    private JTextField allCostTxt = new JTextField("");
    // Creates all the GUI Buttons
    private JButton calcBtn = new JButton("Calculate Costs");
    
    public GUIPanel() {
        setLayout(new BorderLayout());
        setBackground(Color.lightGray);
        
        // Creates and adds the panel into the layout, adds all the labels,
        // textfields and buttons into the panel.
        JPanel tripPanel = new JPanel();
        tripPanel.setLayout(new GridLayout(9, 2, 2, 5));
        tripPanel.add(startCashLbl);
        tripPanel.add(startCashTxt);
        tripPanel.add(numPeopleLbl);
        tripPanel.add(numPeopleTxt);
        tripPanel.add(numDaysLbl);
        tripPanel.add(numDaysTxt);
        tripPanel.add(flightCostLbl);
        tripPanel.add(flightCostTxt);
        tripPanel.add(hotelCostLbl);
        tripPanel.add(hotelCostTxt);
        tripPanel.add(transCostLbl);
        tripPanel.add(transCostTxt);
        tripPanel.add(foodCostLbl);
        tripPanel.add(foodCostTxt);
        tripPanel.add(otherCostLbl);
        tripPanel.add(otherCostTxt);
        tripPanel.add(calcBtn);
        tripPanel.add(allCostTxt);
        add(tripPanel, BorderLayout.CENTER);
        
        // Setting any colors
        allCostTxt.setBackground(Color.gray);
        allCostTxt.setEditable(false);
        
        // Adding the tooltips
        numPeopleTxt.setToolTipText("Number of people traveling.");
        numDaysTxt.setToolTipText("How many days will you be traveling in "
                + "total.");
        flightCostTxt.setToolTipText("Cost in flight ticket per person.");
        hotelCostTxt.setToolTipText("Cost of each night in hotel per person.");
        transCostTxt.setToolTipText("Daily transportation cost per person.");
        foodCostTxt.setToolTipText("Daily food cost per person.");
        otherCostTxt.setToolTipText("Any other expensises.");
        startCashTxt.setToolTipText("Total amount of money to start your trip "
                + "with.");
        allCostTxt.setToolTipText("This is the final cost of your trip.");
        
        // Actions Listeners
        calcBtn.addActionListener(new ActionListener() {
            // ActionListener method that takes the returned calculated values
            // from all the text boxes, and compairs it to the startCashTxt
            // contents.
            public void actionPerformed(ActionEvent e) {
                double totalCost = calculateTotal();
                double startCash = getStartCash();
                
                // Compares the totalCost to the startCash, if the totalCost
                // is over your startCash, the box will be come red. This
                // indicates you are over your budget for the travel.
                if (totalCost < startCash) {
                    allCostTxt.setBackground(Color.green);
                }
                else {
                    allCostTxt.setBackground(Color.red);
                }
                setAllCost(totalCost);
            }});
    }
    
    // setAllCost sets the allCostTxt's text
    void setAllCost(double all) {
        allCostTxt.setText("$" + String.valueOf(all));
    }
    
    // Getters 
    // get Method getNumPeople collects numPeopleTxt value and converts to int
    int getNumPeople() {
        return (Integer.parseInt(numPeopleTxt.getText()));
    }
    // get Method getNumDays collects numDaysTxt value and converts to int
    int getNumDays() {
        return (Integer.parseInt(numDaysTxt.getText()));
    }
    // get Method getFlightCost collects flightCostTxt value and converts to 
    // double
    double getFlightCost() {
        return (Double.parseDouble(flightCostTxt.getText()));
    }
    // get Method getHotelCost collects hotelCostTxt value and converts to 
    // double
    double getHotelCost() {
        return (Double.parseDouble(hotelCostTxt.getText()));
    }
    // get Method getTransCost collects transCostTxt value and converts to 
    // double
    double getTransCost() {
        return (Double.parseDouble(transCostTxt.getText()));
    }
    // get Method getFoodCost collects foodCostTxt value and converts to 
    // double
    double getFoodCost() {
        return (Double.parseDouble(foodCostTxt.getText()));
    }
    // get Method getOtherCost collects otherCostTxt value and converts to 
    // double
    double getOtherCost() {
        return (Double.parseDouble(otherCostTxt.getText()));
    }
    // get Method getStartCash collects startCashTxt value and converts to 
    // double
    double getStartCash() {
        return (Double.parseDouble(startCashTxt.getText()));
    }
    
    // calculateTotal method grabs all the text field's contents, and calculates
    // what they are. Returns the calculated value.
    double calculateTotal() {
        int people = getNumPeople();
        int days = getNumDays();
        double flightCost = getFlightCost();
        double hotelCost = getHotelCost();
        double transCost = getTransCost();
        double foodCost = getFoodCost();
        double otherCost = getOtherCost();
        double totalCost = (((hotelCost + transCost + foodCost +
                otherCost) * (double) (days)) * (double) (people)) + (flightCost
                * people);
        System.out.println("People:" + people + "Days:" + days + "Flight:" + flightCost + 
                "Hotel:" + hotelCost + "Trans:" + transCost + "Food:" + foodCost + 
                "Other:" + otherCost + "Total:" + totalCost);
        return totalCost;
        
    }
}
