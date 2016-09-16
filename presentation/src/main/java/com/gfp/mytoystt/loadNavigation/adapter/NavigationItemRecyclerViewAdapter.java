package com.gfp.mytoystt.loadNavigation.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.gfp.mytoystt.OnListFragmentInteractionListener;
import com.gfp.mytoystt.R;
import com.gfp.mytoystt.dummy.DummyContent.DummyItem;
import com.gfp.mytoystt.loadNavigation.entities.NavigationEntryModel;
import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class NavigationItemRecyclerViewAdapter
    extends RecyclerView.Adapter<NavigationItemRecyclerViewAdapter.ViewHolder> {

  private final List<NavigationEntryModel> mValues;
  private final OnListFragmentInteractionListener mListener;

  public NavigationItemRecyclerViewAdapter(List<NavigationEntryModel> items,
      OnListFragmentInteractionListener listener) {
    mValues = items;
    mListener = listener;
  }

  @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.fragment_navigationitem, parent, false);
    return new ViewHolder(view);
  }

  @Override public void onBindViewHolder(final ViewHolder holder, int position) {
    holder.mItem = mValues.get(position);
    holder.mIdView.setText(mValues.get(position).getLabel());
    if (!mValues.get(position).getType().equals("node")) holder.mNextLevel.setVisibility(View.GONE);
    if (mValues.get(position).getType().equals("section")) {
      holder.mView.setBackgroundColor(Color.parseColor("#d3d3d3"));
      holder.mIdView.setAllCaps(true);
    }
    holder.mView.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        if (null != mListener) {
          // Notify the active callbacks interface (the activity, if the
          // fragment is attached to one) that an item has been selected.
          mListener.onListFragmentInteraction(holder.mItem);
        }
      }
    });
  }

  @Override public int getItemCount() {
    return mValues.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {
    public final View mView;
    public final TextView mIdView;
    public final ImageView mNextLevel;
    public NavigationEntryModel mItem;

    public ViewHolder(View view) {
      super(view);
      mView = view;
      mIdView = (TextView) view.findViewById(R.id.id);
      mNextLevel = (ImageView) view.findViewById(R.id.ivArrowNextLevel);
    }

    @Override public String toString() {
      return super.toString() + " '" + mIdView.getText() + "'";
    }
  }
}
