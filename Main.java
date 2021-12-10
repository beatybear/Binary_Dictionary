package beaty;

public class Main {

	public static void main(String[] args) {
		Dictionary dictionary = new Dictionary();
		
		dictionary.addWord("money");
		dictionary.addWord("kangaroo");
		dictionary.addWord("frogs");
		dictionary.addWord("donut"); //The only d word I could this of was explicit
		dictionary.addWord("tree");
		dictionary.addWord("snake");
		dictionary.addWord("astronaut");
		dictionary.displayDictionary();
		dictionary.checkNode(dictionary.root, "frogs");
		
		dictionary.displayDictionary();
	}

}
