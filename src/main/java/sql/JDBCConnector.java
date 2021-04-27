package sql;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class JDBCConnector {

    private static BasicDataSource ds = new BasicDataSource();

    static {
        ds.setUrl("jdbc:mysql://localhost:3306/pharm_list");
        ds.setUsername("root");
        ds.setPassword("123456");
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setMinIdle(5);
        ds.setMaxIdle(10);
        ds.setMaxOpenPreparedStatements(100);
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    private JDBCConnector(){

    }
    /*
    * подключения к созданной выше локальной базе данных
    * Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/store", "root", "password");

     * Либо мы можем использовать конструкцию try:
     * try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/store", "root", "password")){
        // работа с базой данных
     * }

     * Для взаимодействия с базой данных приложение отправляет серверу MySQL команды на языке SQL.
     * Чтобы выполнить команду, вначале необходимо создаеть объект Statement.

       Для его создания у объекта Connection вызывается метод createStatement():
       Statement statement = conn.createStatement()
     Для выполнения команд SQL в классе Statement определено три метода:

    executeUpdate: выполняет такие команды, как INSERT, UPDATE, DELETE, CREATE TABLE, DROP TABLE.
    * В качестве результата возвращает количество строк, затронутых операцией (например, количество добавленных, измененных или удаленных строк),
    * или 0, если ни одна строка не затронута операцией или если команда не изменяет содержимое таблицы (например, команда создания новой таблицы)

    executeQuery: выполняет команду SELECT. Возвращает объект ResultSet, который содержит результаты запроса.

    execute(): выполняет любые команды и возвращает значение boolean: true - если команда возвращает набор строк (SELECT), иначе возвращается false.

    *
    * Для выборки данных с помощью команды SELECT применяется метод executeQuery:
    * ResultSet resultSet = statement.executeQuery("SELECT * FROM Products");
    * while(resultSet.next()){
        // получение содержимого строк
    }
    * Кроме класса Statement в java.sql мы можем использовать для выполнения запросов еще один класс - PreparedStatement.
    * Кроме собственно выполнения запроса этот класс позволяет подготовить запрос, отформатировать его должным образом.
    * В данном случае данные вводятся с консоли и затем добавляются в базу данных.
    * Для создания объекта PreparedStatement применяется метод prepareStatement() класса Connection.
    * В этот метод передается выражение sql INSERT INTO Products (ProductName, Price) Values (?, ?).
    * Это выражение может содержать знаки вопроса ? - знаки подстановки, вместо которых будут вставляться реальные значения.
    *
    */
}

