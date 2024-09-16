package com.example.ems.Model;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EMSRepository {
    private final EmployeeDAO emsDao;
    ExecutorService executor;
    Handler handler;
    public EMSRepository( Application application) {
        EMSDatabase emsDatabase = EMSDatabase.getDatabase(application);
//        this.noteDao = noteDao;
        this.emsDao = emsDatabase.getEmployeeDAO();

        executor = Executors.newSingleThreadExecutor();
        handler = new Handler(Looper.getMainLooper());
    }

    public void insert(EmployeeEntity employeeEntity){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                emsDao.insert(employeeEntity);
        }
    });
    }

    public void update(String name, String email, String phone, int id){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                emsDao.update(name, email, phone, id);
            }
        });
    }

    public void delete(int id){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                emsDao.delete(id);
            }
        });
    }

    public LiveData<EmployeeEntity> getEmpById(int id) {

        return emsDao.getEmployee(id);
    }

    public LiveData<List<EmployeeEntity>> getAllEmployee() {
        return emsDao.getAllEmployees();
    }
}
