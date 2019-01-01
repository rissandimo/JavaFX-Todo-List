package com.rissandimo.util;

import javafx.scene.control.Alert;

public class AlertUtil
{
    public static void showError(String title, String description)
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(description);
        alert.showAndWait();
    }
}
