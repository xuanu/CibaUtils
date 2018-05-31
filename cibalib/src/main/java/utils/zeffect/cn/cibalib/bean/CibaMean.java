package utils.zeffect.cn.cibalib.bean;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * * means : ["走","离开","去做","进行"],//英文是这种，中文还不是这种的。
 * 下面是中文的样子
 * {
 * "mean_id": "2465987",
 * "part_id": "2148468",
 * "word_mean": "good",
 * "has_mean": "1",
 * "split": 1
 * }
 * <p>
 * Created by Administrator on 2018/5/29.
 */

public class CibaMean implements Serializable {
    private boolean isEng;
    private String allStr;//中英都要显示全部的字节，即使是JSON数据
    private String hasMean;
    private String wordMean;
    private int split;
    private String mean_id;
    private String part_id;

    public static ArrayList<CibaMean> toMeans(JSONArray responseArray) {
        if (responseArray == null) return new ArrayList<>();
        ArrayList<CibaMean> cibas = new ArrayList<>(responseArray.length());
        for (int i = 0; i < responseArray.length(); i++) {
            Object dataObject = responseArray.opt(i);
            CibaMean cibaMean = toMean(dataObject);
            if (cibaMean != null) cibas.add(cibaMean);
        }
        return cibas;
    }

    public static CibaMean toMean(Object dataObject) {
        CibaMean cibaMean = new CibaMean();
        if (dataObject instanceof JSONObject) {
            JSONObject dataJson = (JSONObject) dataObject;
            cibaMean.setEng(false);
            cibaMean.setAllStr(dataJson.toString());
            cibaMean.setHasMean(dataJson.optString("has_mean"));
            cibaMean.setMean_id(dataJson.optString("mean_id"));
            cibaMean.setPart_id(dataJson.optString("part_id"));
            cibaMean.setSplit(dataJson.optInt("split"));
            cibaMean.setWordMean(dataJson.optString("word_mean"));
            return cibaMean;
        } else if (dataObject instanceof String) {
            String wordMean = (String) dataObject;
            cibaMean.setAllStr(wordMean);
            cibaMean.setWordMean(wordMean);
            cibaMean.setEng(true);
            return cibaMean;
        } else return null;
    }

    public boolean isEng() {
        return isEng;
    }

    public CibaMean setEng(boolean eng) {
        isEng = eng;
        return this;
    }

    public String getMean_id() {
        return mean_id;
    }

    public CibaMean setMean_id(String mean_id) {
        this.mean_id = mean_id;
        return this;
    }

    public String getPart_id() {
        return part_id;
    }

    public CibaMean setPart_id(String part_id) {
        this.part_id = part_id;
        return this;
    }

    public String getAllStr() {
        return allStr;
    }

    public CibaMean setAllStr(String allStr) {
        this.allStr = allStr;
        return this;
    }

    public String getHasMean() {
        return hasMean;
    }

    public CibaMean setHasMean(String hasMean) {
        this.hasMean = hasMean;
        return this;
    }

    public String getWordMean() {
        return wordMean;
    }

    public CibaMean setWordMean(String wordMean) {
        this.wordMean = wordMean;
        return this;
    }

    public int getSplit() {
        return split;
    }

    public CibaMean setSplit(int split) {
        this.split = split;
        return this;
    }
}
