package com.nadxlib.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.nadxlib.activity.R;

import ayalma.ir.expandablerecyclerview.ExpandableRecyclerView;

public class PurchaseItemRecyclerViewAdapter extends ExpandableRecyclerView.Adapter<PurchaseItemRecyclerViewAdapter.ChildViewHolder,ExpandableRecyclerView.SimpleGroupViewHolder,String,String>
{

    String[] dis ;
    String[] dName ;

    public PurchaseItemRecyclerViewAdapter(String[] dis) {
        this.dis = dis;
    }

    public PurchaseItemRecyclerViewAdapter(String[] dis, String[] dName) {
        this.dis = dis;
        this.dName = dName;
    }

    @Override
    public int getGroupItemCount() {
        return dis.length-1;
    }

    @Override
    public int getChildItemCount(int i) {
        return 1;
    }

    @Override
    public String getGroupItem(int i) {
        return "group :" + i;
    }

    @Override
    public String getChildItem(int group, int child) {
        return "group: " + group +"item: "+ child;
    }

    @Override
    protected ExpandableRecyclerView.SimpleGroupViewHolder onCreateGroupViewHolder(ViewGroup parent)
    {
        return new ExpandableRecyclerView.SimpleGroupViewHolder(parent.getContext());
    }

    @Override
    protected ChildViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType)
    {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.subitem_row,parent,false);
        return new ChildViewHolder(rootView);
    }

    @Override
    public void onBindGroupViewHolder(ExpandableRecyclerView.SimpleGroupViewHolder holder, int group) {
        super.onBindGroupViewHolder(holder, group);
        holder.setText(dName[group]);

    }

    @Override
    public void onBindChildViewHolder(ChildViewHolder holder, int group, int position)
    {
        super.onBindChildViewHolder(holder, group, position);
        holder.name.setText(dis[group]);
    }

    @Override
    public int getChildItemViewType(int i, int i1) {
        return 1;
    }

    public class ChildViewHolder extends RecyclerView.ViewHolder
    {
        private TextView name;
        public ChildViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.item_name);
        }
    }
}
