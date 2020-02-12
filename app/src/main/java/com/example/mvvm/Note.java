package com.example.mvvm;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Created by Noé Adrian Acuna Prado on 24/01/2020.
 * Sistema BEA
 * acuscorp@gmail.com
 */
@Entity(tableName = "note_table")
public class Note {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    private String title;
    @NonNull
    private String description;
    @NonNull
    private int priority;

    public Note(@NonNull String title, @NonNull String description, int priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    @NonNull
    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    public void setId(int id) {
        this.id = id;
    }
}
