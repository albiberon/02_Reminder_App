package com.example.a02_reminder_app;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ReminderAdapter extends RecyclerView.Adapter<ReminderAdapter.ViewHolder> {

    private List<Reminder> mReminders;

    public ReminderAdapter(List<Reminder> mReminders) {
        this.mReminders = mReminders;
    }

    @NonNull
    @Override
    public ReminderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(android.R.layout.simple_list_item_1, null);
        // Return a new holder instance
        ReminderAdapter.ViewHolder viewHolder = new ReminderAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ReminderAdapter.ViewHolder viewHolder, int i) {
        Reminder reminder = mReminders.get(i);
        viewHolder.textView.setText(reminder.getReminderText());
    }

    @Override
    public int getItemCount() {
        return mReminders.size();
    }



    // add the following method to be able to insert a change the list.
    public void swapList (List<Reminder> newList) {

        mReminders = newList;

        if (newList != null) {

            // Force the RecyclerView to refresh

            this.notifyDataSetChanged();

        }

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public ViewHolder(View itemView) {

            super(itemView);

            textView = itemView.findViewById(android.R.id.text1);

        }

    }


}
