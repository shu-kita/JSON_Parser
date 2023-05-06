package com.shu.JSON_Parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexer {
	//private final char[] SYNTAX = {',', '{', '}', '[', ']', ':', '"'}; 
	
	private static final Pattern SYNTAX = Pattern.compile(",|\"|\\[|\\]|\\{|\\}|:");
	private static final Pattern WHITESPACE = Pattern.compile(" |¥t|¥n|¥n|¥r|¥b");
	
	
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Lexer l = new Lexer();
		l.lexString(",");
		l.lexString("{");
		l.lexString("}");
		l.lexString(":");
		l.lexString("[");
		l.lexString("]");
		System.out.println("---------");
		l.lexString("a");
		l.lexString("b");
		l.lexString("c");
		System.out.println("---------");
		l.lexString("¥t");
		l.lexString(" ");
		l.lexString("¥n");
		l.lexString("¥b");
		l.lexString("¥r");
	}
	
	private void lexString(String s) {
		Matcher matcher = Lexer.SYNTAX.matcher(s);
		matcher = Lexer.WHITESPACE.matcher(s);
        if (matcher.find()) {
            System.out.println("正規表現にマッチしました。");
        } else {
            System.out.println("マッチしませんでした。");
        }
	}

}
