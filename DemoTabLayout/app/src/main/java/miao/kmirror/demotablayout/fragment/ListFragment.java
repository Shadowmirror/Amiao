package miao.kmirror.demotablayout.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import miao.kmirror.demotablayout.R;
import miao.kmirror.demotablayout.adapter.RecyclerViewAdapter;

public class ListFragment extends Fragment {
    private RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRecyclerView = (RecyclerView) inflater.inflate(R.layout.list_fragment, container, false);
        return mRecyclerView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        /**
         * public LinearLayoutManager(Context context) {
         *     this(context, RecyclerView.DEFAULT_ORIENTATION, false);
         * }
         *
         *
         * static final int DEFAULT_ORIENTATION = VERTICAL;
         *
         * 所以默认是垂直布局
         * */
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mRecyclerView.getContext()));

        mRecyclerView.setAdapter(new RecyclerViewAdapter(getActivity()));
    }
}
