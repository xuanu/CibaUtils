package utils.zeffect.cn.cibalib.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import utils.zeffect.cn.cibalib.utils.JsonUtils;

/**
 * 英语各个时态的单词
 * Created by Administrator on 2018/5/29.
 */
public class CibaExchange implements Serializable {

    /**
     * word_pl : ["goes"]
     * word_past : ["went"]
     * word_done : ["gone"]
     * word_ing : ["going"]
     * word_third : ["goes"]
     * word_er :
     * word_est :
     */
    private ArrayList<String> word_er;
    private ArrayList<String> word_est;
    private ArrayList<String> word_pl;
    private ArrayList<String> word_past;
    private ArrayList<String> word_done;
    private ArrayList<String> word_ing;
    private ArrayList<String> word_third;

    public List<String> getWord_er() {
        return word_er;
    }

    public CibaExchange setWord_er(ArrayList<String> word_er) {
        this.word_er = word_er;
        return this;
    }

    public List<String> getWord_est() {
        return word_est;
    }

    public CibaExchange setWord_est(ArrayList<String> word_est) {
        this.word_est = word_est;
        return this;
    }

    public List<String> getWord_pl() {
        return word_pl;
    }

    public CibaExchange setWord_pl(ArrayList<String> word_pl) {
        this.word_pl = word_pl;
        return this;
    }

    public List<String> getWord_past() {
        return word_past;
    }

    public CibaExchange setWord_past(ArrayList<String> word_past) {
        this.word_past = word_past;
        return this;
    }

    public List<String> getWord_done() {
        return word_done;
    }

    public CibaExchange setWord_done(ArrayList<String> word_done) {
        this.word_done = word_done;
        return this;
    }

    public List<String> getWord_ing() {
        return word_ing;
    }

    public CibaExchange setWord_ing(ArrayList<String> word_ing) {
        this.word_ing = word_ing;
        return this;
    }

    public List<String> getWord_third() {
        return word_third;
    }

    public CibaExchange setWord_third(ArrayList<String> word_third) {
        this.word_third = word_third;
        return this;
    }


    /***
     *      * word_pl : ["goes"]
     * word_past : ["went"]
     * word_done : ["gone"]
     * word_ing : ["going"]
     * word_third : ["goes"]
     * word_er :
     * word_est :
     * @param data
     * @return
     */
    public static CibaExchange toExchange(String data) throws JSONException {
        if (TextUtils.isEmpty(data)) return null;
        JSONObject dataJson = new JSONObject(data);
        CibaExchange cibaExchange = new CibaExchange();
        cibaExchange.setWord_pl(JsonUtils.toList(dataJson.optJSONArray("word_pl")));
        cibaExchange.setWord_past(JsonUtils.toList(dataJson.optJSONArray("word_past")));
        cibaExchange.setWord_done(JsonUtils.toList(dataJson.optJSONArray("word_done")));
        cibaExchange.setWord_ing(JsonUtils.toList(dataJson.optJSONArray("word_ing")));
        cibaExchange.setWord_third(JsonUtils.toList(dataJson.optJSONArray("word_third")));
        cibaExchange.setWord_er(JsonUtils.toList(dataJson.optJSONArray("word_er")));
        cibaExchange.setWord_est(JsonUtils.toList(dataJson.optJSONArray("word_est")));
        return cibaExchange;
    }

}
