package utils.zeffect.cn.cibautils;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import utils.zeffect.cn.cibalib.CibaUtils;
import utils.zeffect.cn.cibalib.bean.CibaModel;

public class MainActivity extends Activity {

    private EditText mInputEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CibaUtils.getInstance().init(this);
        mInputEdit = (EditText) findViewById(R.id.inputWord);
        findViewById(R.id.openTest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String word = mInputEdit.getText().toString().trim();
                if (TextUtils.isEmpty(word)) return;
                new AsyncTask<String, Void, CibaModel>() {
                    @Override
                    protected CibaModel doInBackground(String... params) {
                        //
                        return CibaUtils.getInstance().query(params[0]);
                    }

                    @Override
                    protected void onPostExecute(CibaModel cibaModel) {
                        super.onPostExecute(cibaModel);
                        if (cibaModel != null) Log.e("zeffect", "" + cibaModel.getWordName());
                        else Log.e("zeffect", "search null");
                    }
                }.execute(word);

            }
        });
    }
}
