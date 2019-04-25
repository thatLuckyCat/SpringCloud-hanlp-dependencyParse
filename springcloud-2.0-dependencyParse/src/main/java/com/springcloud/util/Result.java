package com.springcloud.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestParam;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.corpus.dependency.CoNll.CoNLLSentence;
import com.hankcs.hanlp.corpus.dependency.CoNll.CoNLLWord;

import io.swagger.annotations.ApiModel;
import net.sf.json.JSONObject;

@ApiModel("返回结果集")
public class Result extends HashMap<String,Object>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;//	Add default serialVersionUID

	public static Result error() {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
    }
	
    public static Result error(String msg) {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
    }
    
    public Result() {
        put("code",0);
    }
    

    public static Result error(int code, String msg) {
    	Result r = new Result();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }
    
 
//    public static Result ok(String msg) {
//    	Result r = new Result();
//        r.put("msg", msg);
//        return r;
//    }

    public static Result ok(Map<String, Object> map) {
    	Result r = new Result();
        r.putAll(map);
        return r;
    }

//    public static Result ok() {
//        return new Result();
//    }
//
//    public Result put(String key, Object value) {
//        super.put(key, value);
//        return this;
//    }
//
//    public Object get(String key){
//        Object o = super.get(key);
//        if (o == null)return null;
//        return  o;
//    }
    
}
