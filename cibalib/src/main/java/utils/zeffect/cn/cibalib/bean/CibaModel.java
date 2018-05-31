package utils.zeffect.cn.cibalib.bean;

import com.litesuits.orm.db.annotation.Column;
import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.enums.AssignType;

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

public class CibaModel implements Serializable {
    public static final String COL_WORD_ID = "wordname";


    private String wordId;
    @Column(COL_WORD_ID)
    @PrimaryKey(AssignType.BY_MYSELF)
    private String wordName;
    private int is_CRI;
    private ArrayList<String> items;
    private CibaExchange exchange;
    private ArrayList<CibaSymbol> symbols;

    public String getWordId() {
        return wordId;
    }

    public CibaModel setWordId(String wordId) {
        this.wordId = wordId;
        return this;
    }

    public String getWordName() {
        return wordName;
    }

    public CibaModel setWordName(String wordName) {
        this.wordName = wordName;
        return this;
    }

    public int getIs_CRI() {
        return is_CRI;
    }

    public CibaModel setIs_CRI(int is_CRI) {
        this.is_CRI = is_CRI;
        return this;
    }

    public List<String> getItems() {
        return items;
    }

    public CibaModel setItems(ArrayList<String> items) {
        this.items = items;
        return this;
    }

    public CibaExchange getExchange() {
        return exchange;
    }

    public CibaModel setExchange(CibaExchange exchange) {
        this.exchange = exchange;
        return this;
    }

    public List<CibaSymbol> getSymbols() {
        return symbols;
    }

    public CibaModel setSymbols(ArrayList<CibaSymbol> symbols) {
        this.symbols = symbols;
        return this;
    }


    public static CibaModel toCibaModel(String data) throws JSONException {
        JSONObject dataJson = new JSONObject(data);
        CibaModel tempModel = new CibaModel();
        tempModel.setIs_CRI(dataJson.optInt("is_CRI"));
        tempModel.setWordId(dataJson.optString("word_id"));
        tempModel.setWordName(dataJson.optString("word_name"));
        tempModel.setItems(JsonUtils.toList(dataJson.optJSONArray("items")));
        tempModel.setExchange(CibaExchange.toExchange(dataJson.optString("exchange")));
        JSONArray symbolsArray = dataJson.optJSONArray("symbols");
        if (symbolsArray == null) symbolsArray = new JSONArray();
        ArrayList<CibaSymbol> cibaSymbols = new ArrayList<>(symbolsArray.length());
        for (int i = 0; i < symbolsArray.length(); i++) {
            cibaSymbols.add(CibaSymbol.toSymbol(symbolsArray.getString(i)));
        }
        tempModel.setSymbols(cibaSymbols);
        return tempModel;

    }
}
