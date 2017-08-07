package com.gwen.androidwidgets.widgets;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import com.gwen.androidwidgets.MainActivity;
import com.gwen.androidwidgets.R;

/**
 * Created by gwendal.charles on 07/08/2017.
 */

public class WidgetProvider  extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {

        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }

    }

    /**
     * Update the widget
     *
     * @param ctx context
     * @param appWidgetManager manager
     * @param appWidgetId ids
     */
    static void updateAppWidget(Context ctx, AppWidgetManager appWidgetManager, int appWidgetId) {

        // Prepare widget views
        RemoteViews views = new RemoteViews(ctx.getPackageName(), R.layout.widget_layout);

        views.setTextViewText(R.id.tv_widget_title, ctx.getResources().getString(R.string.app_name));
        views.setTextViewText(R.id.tv_widget_subtitle, ctx.getResources().getString(R.string.app_name));

        getPendingCallIntent(ctx, views);

        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    /**
     * Call the phone number
     *
     * @param ctx context
     * @param views remote views
     */
    private static void getPendingCallIntent(Context ctx, RemoteViews views){
        Intent callIntent = new Intent(ctx, MainActivity.class);
        PendingIntent pendingCallIntent = PendingIntent.getActivity(ctx, 0, callIntent, 0);
        views.setOnClickPendingIntent(R.id.iv_widget_icon_principal, pendingCallIntent);
    }

}
