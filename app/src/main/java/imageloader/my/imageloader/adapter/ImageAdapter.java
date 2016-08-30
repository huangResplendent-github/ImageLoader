package imageloader.my.imageloader.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

import imageloader.my.imageloader.R;
import imageloader.my.imageloader.bean.ImageEntity;
import imageloader.my.imageloader.tool.ImageLoader;

/**
 * Created by huangResplendent on 16/8/30.
 */
public class ImageAdapter extends BaseAdapter {
    private List<ImageEntity> datasource;
    private Context context;
    private LayoutInflater inflater;
    private ImageLoader imageLoader;

    public ImageAdapter(List<ImageEntity> datasource, Context context) {
        this.datasource = datasource;
        this.context = context;
        inflater = LayoutInflater.from(context);
        imageLoader = new ImageLoader();
    }


    @Override
    public int getCount() {
        return datasource.size();
    }

    @Override
    public ImageEntity getItem(int i) {
        return datasource.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = inflater.inflate(R.layout.item_image, null);
            holder = new ViewHolder();
            holder.imageView = (ImageView) view.findViewById(R.id.iv_item);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }


//        holder.imageView.setImageBitmap(bitmap);
        imageLoader.displayImage(getItem(i).getiUrl(), holder.imageView);
        return view;
    }

    public final class ViewHolder {
        private ImageView imageView;
    }

}
