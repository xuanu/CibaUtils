package utils.zeffect.cn.cibalib.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

import com.litesuits.orm.db.annotation.MapCollection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import utils.zeffect.cn.cibalib.utils.JsonUtils;

/**
 * Created by Administrator on 2018/5/29.
 */

public class CibaSymbol implements Serializable {

    /**
     * symbol_id : 2145896
     * word_id : 2144683
     * word_symbol : chóng qìng
     * symbol_mp3 : http://res.iciba.com/hanyu/ci/c5/90/c5903baa981dcd4394f50153b2b1b4da.mp3
     * ph_am_mp3 :
     * ph_en_mp3 :
     * ph_tts_mp3 :
     * ph_other :
     */

    private String symbol_id;
    private String word_id;
    private String word_symbol;
    private String symbol_mp3;
    private String ph_am_mp3;
    private String ph_en_mp3;
    private String ph_tts_mp3;
    private String ph_other;
    private ArrayList<CibaPart> cibaParts;


    /***
     *    * symbol_id : 2145896
     * word_id : 2144683
     * word_symbol : chóng qìng
     * symbol_mp3 : http://res.iciba.com/hanyu/ci/c5/90/c5903baa981dcd4394f50153b2b1b4da.mp3
     * ph_am_mp3 :
     * ph_en_mp3 :
     * ph_tts_mp3 :
     * ph_other :
     * @param data
     * @return
     */
    public static CibaSymbol toSymbol(String data) throws JSONException {
        if (TextUtils.isEmpty(data)) return null;
        CibaSymbol symbol = new CibaSymbol();
        JSONObject dataJson = new JSONObject(data);
        symbol.setPh_am_mp3(dataJson.optString("ph_am_mp3"));
        symbol.setPh_en_mp3(dataJson.optString("ph_en_mp3"));
        symbol.setPh_other(dataJson.optString("ph_other"));
        symbol.setPh_tts_mp3(dataJson.optString("ph_tts_mp3"));
        symbol.setSymbol_id(dataJson.optString("symbol_id"));
        symbol.setSymbol_mp3(dataJson.optString("symbol_mp3"));
        symbol.setWord_id(dataJson.optString("word_id"));
        symbol.setWord_symbol(dataJson.optString("word_symbol"));
        JSONArray partsArray = dataJson.optJSONArray("parts");
        if (partsArray == null) partsArray = new JSONArray();
        ArrayList<CibaPart> cibaParts = new ArrayList<>(partsArray.length());
        for (int i = 0; i < partsArray.length(); i++) {
            cibaParts.add(CibaPart.toPart(partsArray.getString(i)));
        }
        symbol.setCibaParts(cibaParts);
        return symbol;
    }


    public List<CibaPart> getCibaParts() {
        return cibaParts;
    }

    public CibaSymbol setCibaParts(ArrayList<CibaPart> cibaParts) {
        this.cibaParts = cibaParts;
        return this;
    }

    public String getSymbol_id() {
        return symbol_id;
    }

    public void setSymbol_id(String symbol_id) {
        this.symbol_id = symbol_id;
    }

    public String getWord_id() {
        return word_id;
    }

    public void setWord_id(String word_id) {
        this.word_id = word_id;
    }

    public String getWord_symbol() {
        return word_symbol;
    }

    public void setWord_symbol(String word_symbol) {
        this.word_symbol = word_symbol;
    }

    public String getSymbol_mp3() {
        return symbol_mp3;
    }

    public void setSymbol_mp3(String symbol_mp3) {
        this.symbol_mp3 = symbol_mp3;
    }

    public String getPh_am_mp3() {
        return ph_am_mp3;
    }

    public void setPh_am_mp3(String ph_am_mp3) {
        this.ph_am_mp3 = ph_am_mp3;
    }

    public String getPh_en_mp3() {
        return ph_en_mp3;
    }

    public void setPh_en_mp3(String ph_en_mp3) {
        this.ph_en_mp3 = ph_en_mp3;
    }

    public String getPh_tts_mp3() {
        return ph_tts_mp3;
    }

    public void setPh_tts_mp3(String ph_tts_mp3) {
        this.ph_tts_mp3 = ph_tts_mp3;
    }

    public String getPh_other() {
        return ph_other;
    }

    public void setPh_other(String ph_other) {
        this.ph_other = ph_other;
    }

}
