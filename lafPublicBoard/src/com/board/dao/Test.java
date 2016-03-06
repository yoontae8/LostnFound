package com.board.dao;


public class Test {
	public static void main(String[] args) {
		ImageUrlDAO imageUrlDAO = new ImageUrlDAO("61636714");
		
		String item = imageUrlDAO.getImageUrl();
		
		System.out.println("|"+item+"|" );
		System.out.println(item.length());
	
	}
}
