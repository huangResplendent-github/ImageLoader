package imageloader.my.imageloader;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import imageloader.my.imageloader.adapter.ImageAdapter;
import imageloader.my.imageloader.bean.ImageEntity;
import imageloader.my.imageloader.presenter.MainActivityPresenter;
import imageloader.my.imageloader.view.IMainView;

public class MainActivity extends Activity implements IMainView {
    private Context context;
    private ListView lvImage;
    private ProgressDialog progressDialog;
    private ImageAdapter adapter;
    private MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context=this;
        init();
    }

    private void init(){
        lvImage=(ListView)findViewById(R.id.lv_image);
        presenter=new MainActivityPresenter(this);
        presenter.gainData();

    }

    @Override
    public void showLoading(boolean isShow) {
        if(isShow)
            progressDialog=ProgressDialog.show(context,null,"加载中");
        else
            if(progressDialog!=null)
                progressDialog.dismiss();

    }

    @Override
    public void showData(List<ImageEntity> datasource) {
        adapter=new ImageAdapter(datasource,context);
        lvImage.setAdapter(adapter);

    }
}
