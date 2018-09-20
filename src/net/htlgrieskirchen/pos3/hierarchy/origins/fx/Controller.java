/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.htlgrieskirchen.pos3.hierarchy.origins.fx;

import java.net.URL;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;

/**
 *
 * @author vhoerzi16
 */
public class Controller implements Initializable{

    //<editor-fold desc="Internationalizing Items">
    @FXML
    private Menu menuFile;
    @FXML
    private MenuItem menuItemSave;
    @FXML
    private MenuItem menuItemSaveAs;
    @FXML
    private MenuItem menuItemOpen;
    @FXML
    private MenuItem menuItemExit;
    @FXML
    private Menu menuLanguage;
    @FXML
    private MenuItem menuItemGerman;
    @FXML
    private MenuItem menuItemEnglish;
    @FXML
    private Label labelShowText;
    private String save,noSave,warning,error,cancel,headertext1,headertext2,headertext3,context1,context2,context3,context4;
    //</editor-fold>
    

    @FXML
    private TextField textField1;
    @FXML
    private TextField textField2;
    @FXML
    private TextField textField4;
    @FXML
    private Button button;
    @FXML
    private TableColumn<?, ?> tableColmnWirtschaftssektor;
    @FXML
    private TableColumn<?, ?> tableColmnBranche;
    @FXML
    private TableColumn<?, ?> tableColmnGruppe;
    @FXML
    private TableColumn<?, ?> tableColmnSparte;
    private boolean unsave,openedOnce;
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    @FXML
    private void handleMenuSave(ActionEvent event) {
    }

    @FXML
    private void handleMenuSaveAs(ActionEvent event) {
    }

    @FXML
    private void handleMenuOpen(ActionEvent event) {
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
    }
    
        @FXML
    private void handleMenuExit(ActionEvent event)
    {
        if (unsave && openedOnce)
        {
            String answer = throwAlert(Alert.AlertType.CONFIRMATION, warning, headertext1, context2);
            if (answer.equals(save))
            {
                handleMenuSave(event);
            } else if (answer.equals(cancel))
            {
                Platform.exit();
                System.exit(0);
            }
        }

        Platform.exit();
        System.exit(0);
    }

    public String throwAlert(Alert.AlertType alertType, String title, String headerText, String context)
    {
        String ret = null;
        boolean isConf = false;
        Alert a = new Alert(alertType, context);
        a.setTitle(title);
        a.setHeaderText(headerText);

        
        
        if (alertType.equals(Alert.AlertType.CONFIRMATION))
        {
            isConf = true;
        }
        if (alertType.equals(Alert.AlertType.CONFIRMATION) && context.equals(context1))
        {
            a.getButtonTypes().setAll(new ButtonType(save, ButtonBar.ButtonData.OTHER), new ButtonType(noSave, ButtonBar.ButtonData.OTHER), new ButtonType(cancel, ButtonBar.ButtonData.CANCEL_CLOSE));
        }
        if (alertType.equals(Alert.AlertType.CONFIRMATION) && context.equals(context2))
        {
            a.getButtonTypes().setAll(new ButtonType(save, ButtonBar.ButtonData.YES), new ButtonType(cancel, ButtonBar.ButtonData.CANCEL_CLOSE));
        }
        Optional<ButtonType> showAndWait = a.showAndWait();
        if (isConf)
        {
            ret = showAndWait.get().getText();
        }
        return ret;
    }

    private void changeLanguage(Locale locale)
    {
        
   }

    @FXML
    private void onMenuItemGerman(ActionEvent event)
    {
        changeLanguage(Locale.GERMAN);
    }

    @FXML
    private void onMenuItemEnglish(ActionEvent event)
    {
        changeLanguage(Locale.ENGLISH);
    }
}
