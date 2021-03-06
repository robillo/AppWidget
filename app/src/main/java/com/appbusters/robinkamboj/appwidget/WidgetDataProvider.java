package com.appbusters.robinkamboj.appwidget;

import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import java.util.ArrayList;
import java.util.List;

public class WidgetDataProvider implements RemoteViewsService.RemoteViewsFactory {

    List<String> mCollections = new ArrayList<>();
    List<String> mCollections2 = new ArrayList<>();
    private Context context;

    public WidgetDataProvider(Context context, Intent intent) {
        this.context = context;
    }

    @Override
    public void onCreate() {
        initData();
    }

    @Override
    public void onDataSetChanged() {
        initData();
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public int getCount() {
        return mCollections.size();
    }

    @Override
    public RemoteViews getViewAt(int position) {
        RemoteViews mView = new RemoteViews(context.getPackageName(), R.layout.row_layout);
        mView.setTextViewText(R.id.word, mCollections.get(position));
        mView.setTextViewText(R.id.meaning, mCollections2.get(position));
        return mView;
    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    private void initData() {
        mCollections.clear();
        mCollections2.clear();

        mCollections.add("Abate");
        mCollections2.add("To Decrease/Reduce");
        mCollections.add("Abdicate");
        mCollections2.add("To Give Up a Position, Right or Power");
        mCollections.add("Aberrant");
        mCollections2.add("Deviating From What Is Normal");
        mCollections.add("Abeyance");
        mCollections2.add("Temporary Suppression or Suspension");
        mCollections.add("Abject");
        mCollections2.add("Miserable, Pitiful");
    }
}
