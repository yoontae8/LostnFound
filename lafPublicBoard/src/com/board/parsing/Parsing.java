package com.board.parsing;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import com.board.dto.ItemDTO;
import com.board.dto.ItemDetailsDTO;

public class Parsing extends Thread {

	private static boolean tSwitch;
	private XmlPullParser parser;

	private URL url;
	private int totalCount;

	private String imageURL;
	private ArrayList<ItemDTO> item;
	private ItemDetailsDTO itemDetails;
	private String parsingType;

	public final static String SEARCH_ITEM = "SearchLostArticleService/";
	public final static String ITEM_INFO = "SearchLostArticleInfoService/";
	public final static String ITEM_IMEAGEURL = "SearchLostArticleImageService/";

	public Parsing(String query) {
		tSwitch = false;
		StringBuilder strUrl = new StringBuilder();

		strUrl.append(
				"http://openAPI.seoul.go.kr:8088/70616b6267393032313631/xml/")
				.append(query);

		try {
			url = new URL(strUrl.toString());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			XmlPullParserFactory parsercreator = XmlPullParserFactory.newInstance();
			parser = parsercreator.newPullParser();
			parser.setInput(url.openStream(), "utf-8");

		} catch (Exception e) {
			// TODO: handle exception
		}

		if (parsingType.equals("search")) {
			this.item = new ArrayList<ItemDTO>();
			this.setItemDTO();
		} else if ((parsingType.equals("info"))) {
			this.setItemDetailsDTO();
		} else if ((parsingType.equals("image"))) {
			this.imageURL = null;
			this.setImageURL();
		}

		tSwitch = true;
	}

	public void setType(String type) {
		this.parsingType = type;
	}

	public void setImageURL() {
		String tag = "";
		String imageUrl = null;
		boolean textSwitch = true;

		try {
			int parserEvent = parser.getEventType();

			do {
				switch (parserEvent) {

				case XmlPullParser.START_DOCUMENT:
					break;
				case XmlPullParser.START_TAG:
					tag = parser.getName();
					textSwitch = true;
					break;

				case XmlPullParser.END_TAG:
					if (parser.getName().equals("row")) {
						this.imageURL = imageUrl;
					}
					break;
				case XmlPullParser.TEXT:
					if (textSwitch == false) {
						break;
					}
					if (tag.equals("IMAGE_URL")) {
						imageUrl = parser.getText();
					}
					textSwitch = false;
					break;
				}
				parserEvent = parser.next();
			} while (parserEvent != XmlPullParser.END_DOCUMENT);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void setItemDTO() {
		String tag = "";
		String id = "";
		String take_place = "";
		String name = "";
		String date = "";
		String position = "";
		boolean textSwitch = true;
		try {
			int parserEvent = parser.getEventType();
			
			do {
				switch (parserEvent) {
				
				case XmlPullParser.START_DOCUMENT:
					break;
				case XmlPullParser.START_TAG:
					tag = parser.getName();
					textSwitch = true;
					break;

				case XmlPullParser.END_TAG:
					if (parser.getName().equals("row")) {
						item.add(new ItemDTO(id, take_place, name, date,
								position));
					}
					break;

				case XmlPullParser.TEXT:
					if (textSwitch == false) {
						break;
					}
					if (tag.equals("list_total_count"))
						setTotalCount(Integer.parseInt(parser.getText()));
					if (tag.equals("ID")) {
						id = parser.getText();
					} else if (tag.equals("TAKE_PLACE")) {
						take_place = parser.getText();
					} else if (tag.equals("GET_NAME")) {
						name = parser.getText();
					} else if (tag.equals("GET_DATE")) {
						date = parser.getText();
					} else if (tag.equals("GET_POSITION")) {
						position = parser.getText();
					}
					textSwitch = false;
					break;
				}
				parserEvent = parser.next();
			} while (parserEvent != XmlPullParser.END_DOCUMENT);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	public void setItemDetailsDTO() {

		try {
			int parserEvent = parser.getEventType();
			String tag = "";
			String url = "";
			String title = "";
			String status = "";
			String date = "";
			String getplace = "";
			String thing = "";
			String takeplace = "";
			String contact = "";
			String itmename = "";
			String cate = "";
			String getposition = "";
			String drive_num = "";
			String finder = "";
			boolean textSwitch = true;
			do {
				switch (parserEvent) {

				case XmlPullParser.START_DOCUMENT:

					break;
				case XmlPullParser.START_TAG:

					tag = parser.getName();
					textSwitch = true;
					break;

				case XmlPullParser.END_TAG:

					if (parser.getName().equals("row")) {
						itemDetails = new ItemDetailsDTO(url, title, status,
								date, getplace, thing, takeplace, contact,
								itmename, cate, getposition, drive_num, finder);
					}
					break;

				case XmlPullParser.TEXT:
					if (textSwitch == false) {
						break;
					}
					if (tag.equals("URL")) {
						url = parser.getText();
					} else if (tag.equals("TITLE")) {
						title = parser.getText();
					} else if (tag.equals("STATUS")) {
						status = parser.getText();
					} else if (tag.equals("GET_DATE")) {
						date = parser.getText();
					} else if (tag.equals("GET_PLACE")) {
						getplace = parser.getText();
					} else if (tag.equals("GET_THING")) {
						thing = parser.getText();
					} else if (tag.equals("TAKE_PLACE")) {
						takeplace = parser.getText();
					} else if (tag.equals("CONTACT")) {
						contact = parser.getText();
					} else if (tag.equals("GET_NAME")) {
						itmename = parser.getText();
					} else if (tag.equals("CATE")) {
						cate = parser.getText();
					} else if (tag.equals("GET_POSITION")) {
						getposition = parser.getText();
					} else if (tag.equals("DRIVE_NUM")) {
						drive_num = parser.getText();
					} else if (tag.equals("GET_NM")) {
						finder = parser.getText();
					}
					textSwitch = false;
					break;
				}
				parserEvent = parser.next();
			} while (parserEvent != XmlPullParser.END_DOCUMENT);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	public ArrayList<ItemDTO> getItem() {
		return item;
	}

	public void setItem(ArrayList<ItemDTO> item) {
		this.item = item;
	}

	public ItemDetailsDTO getItemDetails() {
		return itemDetails;
	}

	public void setItemDetails(ItemDetailsDTO itemDetails) {
		this.itemDetails = itemDetails;
	}

	public XmlPullParser getParser() {
		return parser;
	}

	public static boolean istSwitch() {
		return tSwitch;
	}

	public static void settSwitch(boolean tSwitch) {
		Parsing.tSwitch = tSwitch;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	public int getTotalCount() {
		return totalCount;
	}

}
