package com.university;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class StudentController {
    @FXML
    private TextField regField;
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TableView<Student> studentTable;
    @FXML
    private TableColumn<Student, String> colReg;
    @FXML
    private TableColumn<Student, String> colFirst;
    @FXML
    private TableColumn<Student, String> colLast;
    @FXML
    private Label statusLabel;
    @FXML
    private Button saveButton;

    private final ObservableList<Student> studentList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // 1. Connect TableColumns to Student properties
        colReg.setCellValueFactory(cellData -> cellData.getValue().regNumberProperty());
        colFirst.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        colLast.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());

        // 2. Bind TableView items to observable studentList
        studentTable.setItems(studentList);

        // 3. Disable Save button if any input field is empty
        saveButton.disableProperty().bind(
                regField.textProperty().isEmpty()
                        .or(firstNameField.textProperty().isEmpty())
                        .or(lastNameField.textProperty().isEmpty())
        );

        // 4. Load initial data from database
        loadStudents();
    }

    @FXML
    private void handleSaveStudent() {
        String reg = regField.getText().trim();
        String fName = firstNameField.getText().trim();
        String lName = lastNameField.getText().trim();

        statusLabel.setText("Saving student...");

        Task<Void> saveTask = new Task<>() {
            @Override
            protected Void call() throws Exception {
                String sql = "INSERT INTO students (registration_number, first_name, last_name, email) "
                        + "VALUES (?, ?, ?, ?)";
                try (Connection conn = DatabaseUtil.getConnection();
                     PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, reg);
                    stmt.setString(2, fName);
                    stmt.setString(3, lName);
                    stmt.setString(4, reg.toLowerCase() + "@university.edu");
                    stmt.executeUpdate();
                }
                return null;
            }
        };

        saveTask.setOnSucceeded(e -> {
            statusLabel.setText("Student saved successfully!");
            regField.clear();
            firstNameField.clear();
            lastNameField.clear();
            loadStudents();
        });

        saveTask.setOnFailed(e -> {
            Throwable ex = saveTask.getException();
            statusLabel.setText("Save failed: " + (ex != null ? ex.getMessage() : "Unknown error"));
        });

        Thread thread = new Thread(saveTask);
        thread.setDaemon(true);
        thread.start();
    }

    private void loadStudents() {
        LoadStudentsTask task = new LoadStudentsTask();

        task.setOnSucceeded(e -> {
            studentList.setAll(task.getValue());
            statusLabel.setText("Loaded " + studentList.size() + " students from database.");
        });

        task.setOnFailed(e -> {
            Throwable ex = task.getException();
            statusLabel.setText("DB connection error: " + (ex != null ? ex.getMessage() : "Unknown error"));
        });

        Thread thread = new Thread(task);
        thread.setDaemon(true);
        thread.start();
    }
}
