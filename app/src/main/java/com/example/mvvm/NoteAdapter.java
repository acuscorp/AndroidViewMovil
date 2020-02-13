package com.example.mvvm;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Noé Adrian Acuna Prado on 12/02/2020.
 * Sistema BEA
 * acuscorp@gmail.com
 */
public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder> {

    private List<Note> notes = new ArrayList<>();
    private  OnItemClickListener listener;
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_item,parent,false);

        return new NoteHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        Note currenNote = notes.get(position);
        holder.textViewTitle.setText(currenNote.getTitle());
        holder.textViewDescription.setText(currenNote.getDescription());
        holder.textViewPriority.setText(String.valueOf(currenNote.getPriority()));
    }
    @Override
    public int getItemCount() {
        return notes.size();
    }

    class NoteHolder extends RecyclerView.ViewHolder{
        private TextView textViewTitle, textViewDescription, textViewPriority;

        public NoteHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.tv_title);
            textViewDescription = itemView.findViewById(R.id.tv_description);
            textViewPriority = itemView.findViewById(R.id.tv_priority);

           itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   int position  = getAdapterPosition();
                   if(listener!=null && position != RecyclerView.NO_POSITION)
                   {
                       listener.onItemClick(notes.get(position));
                   }
               }
           });

        }
    }
    public void setNotes(List<Note> notes){
        this.notes = notes;
        notifyDataSetChanged();
    }
    public Note getNoteAt(int position){
        return notes.get(position);
    }
    public interface OnItemClickListener{
        void onItemClick(Note note);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }





}
