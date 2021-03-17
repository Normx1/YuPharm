package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DrugDB_Example {
    // Получаем все данные таблицы
    public List<DrugExample> list() {
        List<DrugExample> drugs = new ArrayList<DrugExample>();
        Connection_test newConnection = new Connection_test();
        try {
            Connection conn = newConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs2 = st.executeQuery("select * from medicine " +
                    "join repository r " +
                    "on id_medicine= id;");
            while (rs2.next()) {
                int id_medicine = rs2.getInt("id_medicine");
                String name_ru = rs2.getString("name_ru");
                String name_en = rs2.getString("name_en");
                Boolean recipe = rs2.getBoolean("recipe");
                int id_repository = rs2.getInt("id");
                int count = rs2.getInt("count");
                DrugExample drug1 = new DrugExample(id_medicine, name_ru, name_en, count, recipe);
                drugs.add(drug1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return drugs;
    }

//    public static int insert_drugs( DrugExample drug) {
//        Connection_test newConnection = new Connection_test();
//        try {
//            Connection conn = newConnection.getConnection();
//            Statement st = conn.createStatement();
//            ResultSet rs2 = st.executeQuery("select * from medicine " +
//                    "join repository r " +
//                    "on id_medicine= id;");
//            while (rs2.next()) {
//
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//     }
//
//    }
}
