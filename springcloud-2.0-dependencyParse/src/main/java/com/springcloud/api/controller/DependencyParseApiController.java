package com.springcloud.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.corpus.dependency.CoNll.CoNLLSentence;
import com.hankcs.hanlp.corpus.dependency.CoNll.CoNLLWord;
import com.springcloud.util.Result;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.sf.json.JSONObject;

@Api(tags="依存句法分析器")
@RestController
public class DependencyParseApiController {
	
	@ApiOperation("依存句法分析")
	@PostMapping("/getDependencyParse")
//	@RequestMapping("/getDependencyParse")
	public Result getDependencyParse(@ApiParam("待处理数据") @RequestParam String sentence){	//	@RequestParam String sentence定义待分析文本（默认分析中文），从网页获取（用户输入）
		if (StringUtils.isEmpty(sentence)) return Result.error("请求数据不能为空");
		
		else {
			JSONObject jsonObject = new JSONObject();
		    List<String> testlist = new ArrayList<String>();	//	用列表是为了将for循环中的值取出来
		    CoNLLSentence coNLLWords = HanLP.parseDependency(sentence);
		    for (CoNLLWord word : coNLLWords)
		    {
		    	jsonObject.put("id", word.ID);
		    	jsonObject.put("word", word.LEMMA);
				jsonObject.put("postag", word.POSTAG);
				jsonObject.put("head", word.HEAD.ID);	//	词的父节点ID
				jsonObject.put("deprel", word.DEPREL);
				testlist.add(jsonObject.toString());
			}
		    
		    JSONObject jso = new JSONObject();
		    jso.put("text", sentence);
		    jso.put("items", testlist);
		    jso.putAll(jso);	//	要放入JSONObject中，必须是Map映射这种类型，直接把testlist放入里面会报错。
		    return Result.ok(jso);	//	JSONObject转换成Map<String,Object>黄色警告。
		}
		

	}

}
