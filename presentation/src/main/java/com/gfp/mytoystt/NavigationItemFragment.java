package com.gfp.mytoystt;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.gfp.mytoystt.loadNavigation.entities.NavigationEntryModel;
import com.gfp.mytoystt.loadNavigation.adapter.NavigationItemRecyclerViewAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p />
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class NavigationItemFragment extends android.app.Fragment {

  // TODO: Customize parameter argument names
  private static final String ARG_COLUMN_COUNT = "column-count";
  private static final String ARG_ENTRIES_LIST = "entries-list";
  // TODO: Customize parameters
  private int mColumnCount = 1;
  private com.gfp.mytoystt.OnListFragmentInteractionListener mListener;
  private List<NavigationEntryModel> mListOfEntries;

  /**
   * Mandatory empty constructor for the fragment manager to instantiate the
   * fragment (e.g. upon screen orientation changes).
   */
  public NavigationItemFragment() {
  }

  // TODO: Customize parameter initialization
  @SuppressWarnings("unused") public static NavigationItemFragment newInstance(int columnCount,
      List<NavigationEntryModel> entryModelList) {
    NavigationItemFragment fragment = new NavigationItemFragment();
    Bundle args = new Bundle();
    args.putInt(ARG_COLUMN_COUNT, columnCount);
    args.putParcelableArrayList(ARG_ENTRIES_LIST, (ArrayList<NavigationEntryModel>) entryModelList);
    fragment.setArguments(args);
    return fragment;
  }

  public void setOnRowListener(com.gfp.mytoystt.OnListFragmentInteractionListener onRowListener) {
    this.mListener = onRowListener;
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    if (getArguments() != null) {
      mListOfEntries = getArguments().getParcelableArrayList(ARG_ENTRIES_LIST);
      mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
    }
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_navigationitem_list, container, false);

    // Set the adapter
    if (view instanceof RecyclerView) {
      Context context = view.getContext();
      RecyclerView recyclerView = (RecyclerView) view;
      if (mColumnCount <= 1) {
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
      } else {
        recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
      }
      recyclerView.setAdapter(new NavigationItemRecyclerViewAdapter(mListOfEntries,
          (com.gfp.mytoystt.OnListFragmentInteractionListener) mListener));
    }
    return view;
  }

  @Override public void onAttach(Context context) {
    super.onAttach(context);
    //if (context instanceof OnListFragmentInteractionListener) {
    //  mListener = (OnListFragmentInteractionListener) context;
    //} else {
    //  throw new RuntimeException(
    //      context.toString() + " must implement OnListFragmentInteractionListener");
    //}
  }

  @Override public void onDetach() {
    super.onDetach();
    mListener = null;
  }
}
