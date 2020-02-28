package com.example.mvvm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;



/**
 * Created by Noé Adrian Acuna Prado on 12/02/2020.
 * Sistema BEA
 * acuscorp@gmail.com
 */
//public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder> {
public class NoteAdapter extends ListAdapter<Note,NoteAdapter.NoteHolder> {

    public NoteAdapter() {
        super(DIFF_CALLBACK);

    }
    private static final DiffUtil.ItemCallback<Note> DIFF_CALLBACK = new DiffUtil.ItemCallback<Note>() {
        @Override
        public boolean areItemsTheSame(@NonNull Note oldItem, @NonNull Note newItem) {

            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Note oldItem, @NonNull Note newItem) {
            return oldItem.getTitle().equals(newItem.getTitle()) &&
                    oldItem.getDescription().equals(newItem.getDescription()) &&
                    oldItem.getPriority() == newItem.getPriority();
        }
    };

//    private List<Note> notes = new ArrayList<>();
    private  OnItemClickListener listener;
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_item,parent,false);

        return new NoteHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        Note currentNote = getItem(position);
        holder.textViewTitle.setText(currentNote.getTitle());
        holder.textViewDescription.setText(currentNote.getDescription());
        holder.textViewPriority.setText(String.valueOf(currentNote.getPriority()));
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
                       listener.onItemClick(getItem(position));
                   }
               }
           });

        }
    }

    public Note getNoteAt(int position){
        return getItem(position);
    }
    public interface OnItemClickListener{
        void onItemClick(Note note);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }





}
