package com.parse.starter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by lucky on 5/28/19.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private List<Contact> contacs;

    public  RecyclerAdapter(List<Contact> contacs){

        this.contacs = contacs;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.Name.setText(contacs.get(position).getName());
        holder.Email.setText(contacs.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return contacs.size();
    }

    public  class MyViewHolder extends  RecyclerView.ViewHolder{

        TextView Name, Email;
        public  MyViewHolder(View viewItem){
            super(viewItem);
            Name = (TextView)itemView.findViewById(R.id.name);
            Email = (TextView)itemView.findViewById(R.id.email);
        }
    }
}
