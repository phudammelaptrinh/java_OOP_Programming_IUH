package bai14;

public class EVWordClass implements Comparable {
	private String word;
	private String mean;
	private String type;
	private String notes;

	public EVWordClass() {
		this("", "", "", "");
	}

	public EVWordClass(String word, String mean, String type, String notes) {
		super();
		this.word = word;
		this.mean = mean;
		this.type = type;
		this.notes = notes;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getMean() {
		return mean;
	}

	public void setMean(String mean) {
		this.mean = mean;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public boolean equals(Object obj) {
		EVWordClass w = (EVWordClass) obj;
		return word.equalsIgnoreCase(w.getWord());
	}

	@Override
	public String toString() {
		return "EVWordClass [word=" + word + ", mean=" + mean + ", type=" + type + ", notes=" + notes + "]";
	}

	public int compareTo(Object o) {
		return this.word.compareToIgnoreCase(((EVWordClass) o).getWord());
	}

}
