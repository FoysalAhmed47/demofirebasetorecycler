package com.example.demofirebasetorecycler;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import de.hdodenhof.circleimageview.CircleImageView;

public class myadapter extends FirebaseRecyclerAdapter<model,myadapter.myviewholder>
{
    Context context;
    public myadapter(@NonNull FirebaseRecyclerOptions<model> options) {
        super(options);

    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull model model)
    {
        holder.name.setText(model.getName());
        holder.course.setText(model.getCourse());
        holder.email.setText(model.getName());
        Glide.with(holder.img.getContext()).load(model.getPurl()).into(holder.img);

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        LayoutInflater inflater = LayoutInflater.from(context);
       View view= inflater.inflate(R.layout.singlerow, viewGroup, false);
       return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder
    {

        CircleImageView img;
        TextView name,course,email;
        public myviewholder(@NonNull View itemView)
        {
            super(itemView);
            img=(CircleImageView)itemView.findViewById(R.id.imageView);
            name=(TextView)itemView.findViewById(R.id.name);
            course=(TextView)itemView.findViewById(R.id.course);
            email=(TextView)itemView.findViewById(R.id.email);


        }
    }


}
