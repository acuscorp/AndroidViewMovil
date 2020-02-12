package com.example.mvvm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;


/**
 * Created by Noé Adrian Acuna Prado on 12/02/2020.
 * Sistema BEA
 * acuscorp@gmail.com
 */
public class NoteViewModel extends AndroidViewModel {

    private NoteRepository repository;
    private LiveData<List<Note>> allNotes;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        repository = new NoteRepository(application);
        allNotes = repository.getAllNotes();
    }
    public void insert(Note note){

    }
    public void update(Note note){

    }
    public void delete(Note note){

    }
    public void deletAllNotes(){

    }

    public LiveData<List<Note>> getAllNotes() {
        return allNotes;
    }
}
