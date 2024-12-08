/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.rogercard;

import GUI.RogerCardGUI;
import data.FileController;

/**
 *
 * @author Daza_
 */
public class Rogercard {

    public static void main(String[] args) {
        RogerCardGUI r = new RogerCardGUI();
        r.setVisible(true);
        FileController fileController = new FileController();
        fileController.initializeDatabase();
    }
}
