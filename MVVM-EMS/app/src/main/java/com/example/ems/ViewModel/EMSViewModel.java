package com.example.ems.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.ems.Model.EMSDatabase;
import com.example.ems.Model.EMSRepository;
import com.example.ems.Model.EmployeeEntity;

import java.util.List;

public class EMSViewModel extends AndroidViewModel {
    private EMSRepository emsRepository;
    private LiveData<List<EmployeeEntity>> allEmployee;

//    public NoteViewModel(Application application) {
//        this.noteRepository = new NoteRepository(application);
//    }

    public EMSViewModel(@NonNull Application application) {
        super(application);
        this.emsRepository = new EMSRepository(application);
    }

    public LiveData<List<EmployeeEntity>> getAllNotes() {
        allEmployee = emsRepository.getAllEmployee();
        return allEmployee;
    }

    public void insert(EmployeeEntity emp) {
        emsRepository.insert(emp);
    }



    public void delete(int id) {
        emsRepository.delete(id);
    }

    public void updateNoteById( String name, String email,String phone,int id) {
        emsRepository.update( name,  email, phone, id);
    }

    public LiveData<EmployeeEntity> getNoteById(int id) {
        return emsRepository.getEmpById(id);
    }
}
