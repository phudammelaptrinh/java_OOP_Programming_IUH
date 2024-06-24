package bai15;

public class Card {
	private int face;
	private int suit;

	public Card() {
		this.face = (int) (Math.random() * 4);
		this.suit = (int) (Math.random() * 13);
	}

	public int getFace() {
		return face;
	}

	public void setFace(int face) {
		this.face = face;
	}

	public int getSuit() {
		return suit;
	}

	public void setSuit(int suit) {
		this.suit = suit;
	}

	public boolean euqals(Object obj) {
		Card c = (Card) obj;
		return (this.suit == c.getSuit() && this.face == c.getFace());
	}

	public String toString() {
		String ret = "";
		switch (suit) {
		case 0:
			ret = "At";
			break;
		case 1:
			ret = "Mot";
			break;
		case 2:
			ret = "Hai";
			break;
		case 3:
			ret = "Ba";
			break;
		case 4:
			ret = "Bon";
			break;
		case 5:
			ret = "Nam";
			break;
		case 6:
			ret = "Sau";
			break;
		case 7:
			ret = "Bay";
			break;
		case 8:
			ret = "Tam";
			break;
		case 9:
			ret = "Chin";
			break;
		case 10:
			ret = "Muoi";
			break;
		case 11:
			ret = "Muoi mot";
			break;
		case 12:
			ret = "Muoi hai ";
			break;
		}
		switch (face) {
		case 0:
			ret += " Co";
			break;
		case 1:
			ret += " Chuon";
			break;
		case 3:
			ret += " Bich";
			break;
		case 4:
			ret += " Ro";
			break;
		}
		return ret;
	}
}
