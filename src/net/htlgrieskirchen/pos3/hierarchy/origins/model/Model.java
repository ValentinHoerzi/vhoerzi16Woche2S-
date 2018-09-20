/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.htlgrieskirchen.pos3.hierarchy.origins.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;

/**
 *
 * @author Valentin
 */
public class Model {

    private final String SEPERATOR = ";";
    private String firstRow = "";


    public void readCsv(File file) {
        String line = null;
        List<String> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            firstRow = br.readLine();
            while ((line = br.readLine()) != null) {
                list.add(line);
            }

        } catch (IOException e) {
           // Main.getController().throwAlert(Alert.AlertType.ERROR, Main.getController().errorModel, Main.getController().headertext3, Main.getController().context4);
        }
    }

    public void writeCsv(File file) throws IOException {


        if (file != null) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {

                bw.write(firstRow);
                bw.newLine();
                
            }
        }else{
            //Main.getController().throwAlert(Alert.AlertType.ERROR, Main.getController().errorModel, Main.getController().headertext3, Main.getController().context4);
        }
    }
}
