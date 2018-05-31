package utils.zeffect.cn.cibalib.bean;

import android.text.TextUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/29.
 */

public class CibaPart implements Serializable {

    /**
     * part : vi.
     * means : ["走","离开","去做","进行"],//英文是这种，中文还不是这种的。
     */


    public static CibaPart toPart(String response) throws JSONException {
        if (TextUtils.isEmpty(response)) return null;
        JSONObject dataJson = new JSONObject(response);
        CibaPart cibaPart = new CibaPart();
        cibaPart.setPartName(dataJson.optString("part_name"));
        cibaPart.setMeans(CibaMean.toMeans(dataJson.optJSONArray("means")));
        cibaPart.setPart(dataJson.optString("part"));
        return cibaPart;
    }


    private String part;
    private String partName;
    private ArrayList<CibaMean> means;

    public List<CibaMean> getMeans() {
        return means;
    }

    public CibaPart setMeans(ArrayList<CibaMean> means) {
        this.means = means;
        return this;
    }

    public String getPartName() {
        return partName;
    }

    public CibaPart setPartName(String partName) {
        this.partName = partName;
        return this;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

}
