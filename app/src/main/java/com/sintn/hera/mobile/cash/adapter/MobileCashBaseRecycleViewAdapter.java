package com.sintn.hera.mobile.cash.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.sintn.hera.mobile.cash.activity.main.fragment.RecyclerViewAdapter;
import com.sintn.hera.mobile.cash.adapter.fragment.OrderQueryRecycleListAdapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Sintn on 15/10/28.
 */
public class MobileCashBaseRecycleViewAdapter<E extends Object> extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    protected List<E> objects;

    public List<E> getlistObject()
    {
        return objects;
    }

    public MobileCashBaseRecycleViewAdapter()
    {
        objects = new ArrayList<E>();
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, int position) {

    }

    public Object getItem(int position)
    {
        return objects.get(position);
    }
    @Override
    public int getItemCount() {
        return objects==null?0:objects.size();
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    public void replaceAll(Collection<E> collection)
    {
        objects.clear();
        if (collection != null)
        {
            objects.addAll(collection);
        }
        notifyDataSetChanged();
    }

    public void addItem(E e)
    {
        objects.add(e);
        notifyDataSetChanged();
    }

    public void addItem(E e, int position)
    {
        objects.add(position, e);
        notifyDataSetChanged();
    }

    public void addAllItem(List<E> list)
    {
        if (list != null)
        {
            objects.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void removeItem(E e)
    {
        objects.remove(e);
        notifyDataSetChanged();
    }

    public void removeItem(int i)
    {
        objects.remove(i);
        notifyDataSetChanged();
    }

    public void removeAllItem(List<E> list)
    {
        objects.removeAll(list);
        notifyDataSetChanged();
    }

    public void clear()
    {
        objects.clear();
        notifyDataSetChanged();
    }

}
