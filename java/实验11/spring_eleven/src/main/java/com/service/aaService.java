package com.service;

import org.springframework.stereotype.Service;

@Service
public class aaService {
	public String getHtml() {
		return "<section style='overflow:hidden;'><section data-role='outer' label='Powered by " +
				"365editor' style='font-family:微软雅黑;font-size:16px;'><section class='KolEditor'>" +
				"<section style='margin:10px auto;display:-webkit-flex;display:-moz-flex;display:-ms" +
				"-flex;display:-o-flex;-webkit-align-items: flex-end;-moz-align-items: flex-end;-ms-a" +
				"lign-items: flex-end;-o-align-items: flex-end;-webkit-justify-content: center;-moz-just" +
				"ify-content: center;-ms-justify-content: center;-o-justify-content: center;'><section style" +
				"='width:52px;margin-right: -15px;flex-shrink: 0;'><img src='http://editor-material.oss-c" +
				"n-beijing.aliyuncs.com/style/20181106/1541507691/%E6%96%B0%E5%A2%9E%E7%B4%A0%E6%9D%90_0.png'" +
				" style='max-width: 100%; vertical-align: middle; height: auto;' class='KolImg'></section><" +
				"section style='border-top: 1px solid rgb(68, 161, 128); border-bottom: 1px solid rgb(68, 161, 1" +
				"28); padding: 2px 18px; box-sizing: border-box;'><p style='margin:0;font-size: 24px;color:" +
				" #006754;'>立冬</p></section></section></section><p><br></p></section></section> ";
	} 
}
