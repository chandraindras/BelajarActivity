package pens.lab.app.todolistmvp.utils;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;
import pens.lab.app.todolistmvp.R;
import pens.lab.app.todolistmvp.data.model.Task;

public class RecyclerViewAdapterTodolist extends RecyclerView.Adapter<RecyclerViewAdapterTodolist.MyViewHolder> {
    private static ArrayList<Task> mDataset;
    private static MyClickListener myClickListener;

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tvTitle;
        TextView tvDescription;
        public MyViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.task_title);
            tvDescription = (TextView) itemView.findViewById(R.id.task_des);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position =getAdapterPosition();
            myClickListener.onItemClick(position, view);
        }
    }

    public RecyclerViewAdapterTodolist(ArrayList<Task> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public RecyclerViewAdapterTodolist.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tvTitle.setText(mDataset.get(position).getTitle());
        holder.tvDescription.setText(mDataset.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }
}