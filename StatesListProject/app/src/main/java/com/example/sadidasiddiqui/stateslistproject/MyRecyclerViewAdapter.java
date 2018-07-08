package com.example.sadidasiddiqui.stateslistproject;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class MyRecyclerViewAdapter extends
    RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {

        private ArrayList<String> StateList;



        public class MyViewHolder extends RecyclerView.ViewHolder {

            public TextView itemState;
            public MyViewHolder(View view) {
                super(view);
                 itemState = (TextView) view.findViewById(R.id.RecyclerTextView);

            }
        }


    public MyRecyclerViewAdapter(ArrayList<String> StateList) {
            this.StateList = StateList;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.recyclerrowitem, parent, false);



            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            String State = StateList.get(position);
            holder.itemState.setText(State);

        }

        @Override
        public int getItemCount() {
            return StateList.size();
        }

    // allows clicks events to be caught

    }


