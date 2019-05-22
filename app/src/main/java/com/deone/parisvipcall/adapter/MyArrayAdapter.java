package com.deone.parisvipcall.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.deone.parisvipcall.R;
import com.deone.parisvipcall.models.LogInformation;

import java.util.List;

public class MyArrayAdapter extends ArrayAdapter<LogInformation> {

    List<LogInformation> modelList;
    Context context;
    private LayoutInflater mInflater;

    // Constructors
    public MyArrayAdapter(Context context, List<LogInformation> objects) {
        super(context, 0, objects);
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        modelList = objects;
    }

    @Override
    public LogInformation getItem(int position) {
        return modelList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder vh;
        if (convertView == null) {
            View view = mInflater.inflate(R.layout.activity_info_row_view, parent, false);
            vh = ViewHolder.create((RelativeLayout) view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        LogInformation item = getItem(position);

        vh.tvLogin.setText(item.getLogin());
        vh.tvPassword.setText(item.getPassword());
        vh.tvTypeChoose.setText(item.getTypeChoose());
        vh.tvPrivateMode.setText(item.getPrivateMode());
        vh.tvCommentaire.setText(item.getCommentaire());

        return vh.rootView;
    }

    /**
     * ViewHolder class for layout.<br />
     * <br />
     * Auto-created on 2016-01-05 00:50:26 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private static class ViewHolder {
        public final RelativeLayout rootView;

        public final TextView tvLogin;
        public final TextView tvPassword;
        public final TextView tvTypeChoose;
        public final TextView tvPrivateMode;
        public final TextView tvCommentaire;

        private ViewHolder(RelativeLayout rootView, TextView tvLogin, TextView tvPassword, TextView tvTypeChoose, TextView tvPrivateMode, TextView tvCommentaire) {
            this.rootView = rootView;
            this.tvLogin = tvLogin;
            this.tvPassword = tvPassword;
            this.tvTypeChoose = tvTypeChoose;
            this.tvPrivateMode = tvPrivateMode;
            this.tvCommentaire = tvCommentaire;
        }

        public static ViewHolder create(RelativeLayout rootView) {
            TextView tvLogin = (TextView) rootView.findViewById(R.id.tvLogin);
            TextView tvPassword = (TextView) rootView.findViewById(R.id.tvPassword);
            TextView tvTypeChoose = (TextView) rootView.findViewById(R.id.tvTypeChoose);
            TextView tvPrivateMode = (TextView) rootView.findViewById(R.id.tvPrivateMode);
            TextView tvCommentaire = (TextView) rootView.findViewById(R.id.tvCommentaire);
            return new ViewHolder(rootView, tvLogin, tvPassword, tvTypeChoose, tvPrivateMode, tvCommentaire);
        }
    }
}
