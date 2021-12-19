package miao.kmirror.demotablayout.adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import miao.kmirror.demotablayout.R;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private Context mContext;

    /**
     * 这里可以接收传来的数据关键词
     */
    public RecyclerViewAdapter(Context mContext) {
        this.mContext = mContext;
    }

    /**
     * 创建单个条目的视图
     * 返回自定义的 ViewHolder
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_card_main, parent, false);
        return new ViewHolder(view);
    }


    /**
     * 用于绑定条目组件以及条目即条目内点击事件
     * 也可以通过自定义一个接口 ItemClickListener 定义点击响应事件和长按事件方法，
     * 在调用 RecyclerView 的 Activity 中实现 ItemClickListener 内的方法实现在该 Activity 中自定义条目的长按，短按响应事件
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final View viewItem = holder.mItemView;
        viewItem.setOnClickListener(v -> {
            Toast.makeText(mContext, "You click me", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return 8;
    }

    /**
     * 接上这里可以通过 itemView.setOnClickListener() 方法绑定 ItemClickListener.OnItemClick(View v, int position)
     * 以及 ItemClickListener.onItemLongClick(View v, int position) 来让调用的 Activity / Fragment 实现 ItemClickListener 接口
     * 从而实现在 Activity / Fragment 中实现 item 事件监听
     * 在此之前要定义 private ItemClickListener itemClickListener
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mItemView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.mItemView = itemView;
        }
    }
}
