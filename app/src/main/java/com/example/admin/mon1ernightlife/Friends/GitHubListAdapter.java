package com.example.admin.mon1ernightlife.Friends;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.admin.mon1ernightlife.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Admin on 2017-03-25.
 */

public class GitHubListAdapter extends BaseAdapter {


    static final String JSON_MEMBER_LOGIN = "login";
    static final String JSON_MEMBER_AVATAR = "avatar_url";
    static final String JSON_MEMBER_URL = "html_url";
    private final Context mContext;
    private final ImageLoader mVolleyImageLoader;
    private JSONArray mMembers;
    TextView login;

    public GitHubListAdapter(Context context, ImageLoader imageLoader) {
        mContext = context;
        mVolleyImageLoader = imageLoader;
    }

    public void updateMembers(JSONArray members) {
        mMembers = members;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return (mMembers == null) ? 0 : mMembers.length();
    }

    @Override
    public JSONObject getItem(int position) {
        JSONObject item = null;

        if (mMembers != null) {
            try {
                item = mMembers.getJSONObject(position);
            } catch (JSONException e) {
                // log error
            }
        }
        return item;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        NetworkImageView avatar;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.activity_friends_list, parent, false);
            login = (TextView) convertView.findViewById(R.id.login_friend);
            avatar = (NetworkImageView) convertView.findViewById(R.id.avatar);
            convertView.setTag(new ViewHolder(login, avatar));
        } else {
            ViewHolder viewHolder = (ViewHolder) convertView.getTag();
            login = viewHolder.mLogin;
            avatar = viewHolder.mAvatar;
        }

        // On r??cup??re les informations depuis le JSONObject et on les relie aux vues
        JSONObject json = getItem(position);
        login.setText(json.optString("login"));
        avatar.setImageUrl(json.optString("avatar_url"), mVolleyImageLoader);
        return convertView;
    }

    static final class ViewHolder {
        final TextView mLogin;
        final NetworkImageView mAvatar;

        public ViewHolder(TextView login, NetworkImageView avatar) {
            mLogin = login;
            mAvatar = avatar;
        }
    }
}
