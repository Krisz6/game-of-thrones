package character.type;

public enum House {
    STARK("Winter is Coming", "Közeleg a tél"),
    LANNISTER("Hear Me Roar", "Halld üvöltésem"),
    TARGARYEN("Fire and Blood", "Tűz és vér"),
    BARATHEON("Ours is the Fury", "Miénk a düh"),
    GREYJOY("We Do Not Sow", "Nem vetünk"),
    TYRELL("Growing Strong", "Kokszolunk");

    private final String englishWords;
    private final String hungarianWords;

    House(String englishWords, String hungarianWords) {
        this.englishWords = englishWords;
        this.hungarianWords = hungarianWords;
    }

    public String getWordsInEnglish() {
        return englishWords;
    }

    public String getWordsInHungarian() {
        return hungarianWords;
    }
}
