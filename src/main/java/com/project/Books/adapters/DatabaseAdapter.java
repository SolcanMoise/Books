package com.project.Books.adapters;

import com.project.Books.models.Book;

import java.sql.*;

/**
 * Adapter class for connecting to MySQL database
 * @author solcanm
 * @date 22 June 2019
 */
public class DatabaseAdapter {

    private static Connection connection;

    /**
     * Method to add a new Book to database
     * @param book - the book to be added to database
     * @return - 1 in case of success, 0 otherwise
     */
    private static int addNewBookToDB(Book book) {

        String insertQueryStatement = "INSERT INTO db_books.book VALUES(?,?,?,?,?,?)";
        try {
            makeJDBCConnection();

            PreparedStatement statement = connection.prepareStatement(insertQueryStatement);
            statement.setInt(1, Book.getId());
            statement.setString(2, book.getTitle());
            statement.setString(3, book.getAuthor());
            statement.setDate(4, (Date) book.getPublished());
            statement.setInt(5, book.getPages());
            statement.setString(6, book.getISBN());

            // execute insert SQL statement
            statement.execute();

            // close connections
            statement.close();
            connection.close();

            return 1; // executed successfully
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return 0;
    }

    /**
     * Create a connection to database
     * @throws ClassNotFoundException - in case that JDBC Driver not found
     * @throws SQLException - in case that connection with database cannot be established
     */
    private static void makeJDBCConnection() throws ClassNotFoundException, SQLException {

        // register MySQL JDBC Driver
        Class.forName("com.mysql.jdbc.Driver");

        // DriverManager - The basic service for managing a set of JDBC drivers
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_books",
                "root", "rootpassword");

    }

}
