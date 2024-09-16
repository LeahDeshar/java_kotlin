package com.example.ems.Model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface EmployeeDAO {
    @Insert
    void insert(EmployeeEntity employeeEntity);

    @Query("SELECT * FROM employee")
    LiveData<List<EmployeeEntity>> getAllEmployees();

    @Query("SELECT * FROM employee WHERE id = :id")
   LiveData<EmployeeEntity> getEmployee(int id);

    @Query("UPDATE employee SET name = :name, email = :email, phone = :phone WHERE id = :id")
    void update( String name, String email, String phone, int id);

    @Query("DELETE FROM employee WHERE id = :id")
    void delete( int id);
}
