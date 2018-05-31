package utils.zeffect.cn.cibalib;

import android.content.Context;
import android.text.InputFilter;
import android.text.TextUtils;

import com.litesuits.orm.LiteOrm;
import com.litesuits.orm.db.model.ConflictAlgorithm;
import com.zhy.http.okhttp.OkHttpUtils;

import org.json.JSONException;

import java.io.IOException;

import okhttp3.Response;
import utils.zeffect.cn.cibalib.bean.CibaModel;

/**
 * Created by Administrator on 2018/5/29.
 */

public class CibaUtils {
    public static final String DB_NAME = "ciba.db";
    private static CibaUtils instance;
    private LiteOrm mCibaOrm;

    public static CibaUtils getInstance() {
        if (instance == null) {
            synchronized (CibaUtils.class) {
                if (instance == null) instance = new CibaUtils();
            }
        }
        return instance;
    }


    public void init(Context pTarget) {
        if (pTarget == null) throw new NullPointerException("context is null");
        if (mCibaOrm == null) {
            mCibaOrm = LiteOrm.newSingleInstance(pTarget.getApplicationContext(), DB_NAME);
        }
    }


    public CibaModel query(String word) {
        if (TextUtils.isEmpty(word)) return null;
        word = word.trim();
        CibaModel tempModel = null;
        if (mCibaOrm == null) {
            //在线查词
            tempModel = queryNet(word);
        } else {
            tempModel = mCibaOrm.queryById(word, CibaModel.class);
            if (tempModel == null) {
                tempModel = queryNet(word);
                save(word, tempModel);
            }
        }
        return tempModel;
    }


    private void save(String word, CibaModel needModel) {
        if (TextUtils.isEmpty(word)) return;
        if (needModel == null) return;
        if (mCibaOrm == null) return;
        CibaModel cibaModel = mCibaOrm.queryById(word, CibaModel.class);
        if (cibaModel == null) {
            mCibaOrm.save(needModel);
        } else {
            mCibaOrm.update(needModel, ConflictAlgorithm.Replace);
        }
    }


    private CibaModel queryNet(String word) {
        if (TextUtils.isEmpty(word)) return null;
        try {
            Response response = OkHttpUtils.get()
                    .url("http://dict-co.iciba.com/api/dictionary.php")
                    .addParams("w", word)
                    .addParams("type", "json")
                    .addParams("key", "1B5C337C39B550473262A832CF94817C")
                    .build().execute();
            if (response.isSuccessful()) {
                String responseStr = response.body().string();
                response.body().close();
                return CibaModel.toCibaModel(responseStr);
            } else return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }


}
