package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class MainDashController {

    public TextField txtOneDrive;
    public Button btnGenerate;
    public TextField txtDirect;
    public Button btnCopy;
    public AnchorPane R;

    public void btnGenerate_OnAction(ActionEvent actionEvent) {
        System.out.println("click");

        if (txtOneDrive.getText().contains("sharepoint.com") && txtOneDrive.getText().contains("?")){

            String[] split = txtOneDrive.getText().split("\\?(.*)"); //Split URL to cut off the unwanted part
            String directLink = split[0]+"?download=1"; //Download to true
            txtDirect.setText(directLink); //Generated Link

            txtOneDrive.clear();
            txtDirect.requestFocus();
            btnCopy.setText("Copy Link!");
        }else {
            new Alert(Alert.AlertType.ERROR, "Invalid URL! Try again " +

                    "\nHint! Check the Example OneDrive URL below:\n" +
                    "\nhttps://anon-my.sharepoint.com/:u:/g/personal/anon_gmail_com/Ead8aEc1Wsd?e=vdmnBl", ButtonType.OK).show();
            txtOneDrive.clear();
        }
    }

    public void btnCopy_OnAction(ActionEvent actionEvent) {

        String directLink = txtDirect.getText();
        StringSelection stringSelection = new StringSelection(directLink);
        Clipboard systemClipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        systemClipboard.setContents(stringSelection, stringSelection);

        if (!txtDirect.getText().isEmpty()){
            btnCopy.setText("Copied!");
            txtDirect.selectAll();
        }else {
            btnCopy.setText("Copy Link!");
        }
    }

    public void txtDirect_OnMouseClicked(MouseEvent mouseEvent) {
        txtDirect.selectAll();
    }
}
