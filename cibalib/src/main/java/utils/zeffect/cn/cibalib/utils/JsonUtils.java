package utils.zeffect.cn.cibalib.utils;

import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <pre>
 *      author  ：zzx
 *      e-mail  ：zhengzhixuan18@gmail.com
 *      time    ：2017/12/02
 *      desc    ：
 *      version:：1.0
 * </pre>
 *
 * @author zzx
 */

public class JsonUtils {

    public static ArrayList<String> toList(JSONArray jsonArray) throws JSONException {
        if (jsonArray == null) return new ArrayList<>();
        ArrayList<String> list = new ArrayList<>(jsonArray.length());
        for (int i = 0; i < jsonArray.length(); i++) {
            String tempStr = jsonArray.getString(i);
            if (!TextUtils.isEmpty(tempStr)) list.add(tempStr);
        }
        return list;
    }

}
