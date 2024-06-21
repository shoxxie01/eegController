package com.shoxxie.eegcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.sql.*;

@Controller
public class ImageController {

    @GetMapping("/image/{electrodeNumber}")
    public String image(@PathVariable("electrodeNumber") Integer electrodeNumber, Model model) throws SQLException {

        String base64 = getImageFromDatabase(electrodeNumber);
        model.addAttribute("image", base64);
        return "eegimage";
    }

    private String getImageFromDatabase(Integer electrodeNumber) throws SQLException {
        String base64;
        String URL = "jdbc:sqlite:C:\\Users\\User\\Desktop\\programowanie\\Java_projects\\EEGcontroller\\usereeg.db";
        String statementSql = "SELECT image FROM user_eeg WHERE electrode_number = ?";

        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement statement = conn.prepareStatement(statementSql);
        statement.setInt(1, electrodeNumber);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        base64 = resultSet.getString("image");
        return base64;
    }
}
