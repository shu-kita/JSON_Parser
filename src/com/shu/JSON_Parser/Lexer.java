package com.shu.JSON_Parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexer {
	//private final char[] SYNTAX = {',', '{', '}', '[', ']', ':', '"'}; 
	
	private static final Pattern SYNTAX = Pattern.compile(",|\"|\\[|\\]|\\{|\\}|:");
	private static final Pattern WHITESPACE = Pattern.compile(" |¥t|¥n|¥n|¥r|¥b");
	private static final Pattern NUMBER = Pattern.compile("[0-9]|[-e¥.]");
	private static final char QUOTE = '"';
	
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Lexer l = new Lexer();
		// l.lexString("\"iaaaad\"test");
		// l.lexString("\"iaaaad\"");
		// l.lexString("kitamura");
		l.lexNumber("123:anc");
		l.lexNumber("kitamura");
	}
	
	private String[] lexString(String str) {
		String [] List = new String[2];
		
		// 「"」で始まらない
		if (!isQuote(str.charAt(0))) {
			List[0] = null;
			List[1] = str;
			return List;
		}
		
		// 「"」で始まる	
		String jsonString = "";
		for (int i=1; i <= str.length(); i++) {
			char c = str.charAt(i);
			if (isQuote(c)) {
				List[0] = jsonString;
				List[1] = str.substring(i+1);
				break;
			} else {
				jsonString += c;
			}
		}
		return List;
	}
	
	private void lexNumber(String str) {
		String number = "";
		
		for (int i=0; i <= str.length(); i++) {
			String s = String.valueOf(str.charAt(i));
			Matcher matcher = Lexer.NUMBER.matcher(String.valueOf(s));
			if (matcher.find()) {
				number += s;
			} else {
				break;
			}
		}
		
		if (number.length() == 0) {
			System.out.println("not number");
		} else {
			System.out.println("number");
			// int・floatに変換する必要がある
			var num = 0.0;
			if (isFloat(number)) {
				num = Float.parseFloat(number);
			} else {
				num = Integer.parseInt(number);
				
			}
		}
		System.out.println(number);
	}
	
	private boolean isQuote(char c) {
		return c == Lexer.QUOTE;
	}
	
	private boolean isFloat(String num) {
		return num.contains(".");
	}
}
