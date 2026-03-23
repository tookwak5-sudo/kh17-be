package api.collection;

public class Card {
	private String shape;
	private String number;
	public String getShape() {
		return shape;
	}
	public void setShape(String shape) {
		switch(shape) {
		case "하트", "다이아몬드", "클로버", "스페이드":
			this.shape = shape;
		}
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		switch(number) {
		case "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K":
		this.number = number;
		}
	}
	public Card(String shape, String number) {
		this.setShape(shape);
		this.setNumber(number);
	}
}
