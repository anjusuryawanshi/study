import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trie {
  private TrieNode root;

  public Trie(List<String> list) {
    root = new TrieNode();
    for (String s : list) {
      root.addWord(s);
    }
  }

  public Trie(String[] array) {
    root = new TrieNode();
    for (String s : array) {
      root.addWord(s);
    }
  }

  public boolean contains(String prefix, boolean exact) {
    TrieNode lastNode = root;
    for (int i = 0; i < prefix.length(); i++) {
      lastNode = lastNode.getChild(prefix.charAt(i));
      if (lastNode == null) {
        return false;
      }
    }
    return !exact || lastNode.terminates();
  }

  public boolean contains(String prefix) {
    return contains(prefix, false);
  }

  public TrieNode getRoot() {
    return root;
  }

  public static void main(String[] args) {
    List<String> stringList = new ArrayList<>();
    stringList.add("abc");
    stringList.add("ab");
    stringList.add("apple");
    stringList.add("boy");
    stringList.add("boring");
    stringList.add("batman");
    Trie trie = new Trie(stringList);
    System.out.println(trie.contains("zebra"));
    System.out.println(trie.contains("ab"));
    System.out.println(trie.contains("ap"));
    System.out.println(trie.contains("ae"));
    System.out.println(trie.contains("boring"));
    System.out.println(trie.contains("bat"));

  }

}

class TrieNode {
  Map<Character, TrieNode> children;
  Character character;
  boolean terminates = false;

  public TrieNode() {
    children = new HashMap<>();
  }
  public TrieNode(Character c) {
    this();
    this.character = c;
  }
  public TrieNode getChild(Character c) {
    return children.get(c);
  }
  public void addWord(String word) {
    if (word == null || word.isEmpty()) {
      return;
    }
    char firstChar = word.charAt(0);
    TrieNode child = getChild(firstChar);
    if (child == null) {
      child = new TrieNode(firstChar);
      children.put(firstChar, child);
    }
    if (word.length() > 1) {
      child.addWord(word.substring(1));
    } else {
      child.setTerminates(true);
    }
  }

  public Character getCharacter() {
    return character;
  }

  public void setCharacter(Character character) {
    this.character = character;
  }

  public boolean isTerminates() {
    return terminates;
  }

  public void setTerminates(boolean terminates) {
    this.terminates = terminates;
  }

  public Map<Character, TrieNode> getChildren() {
    return children;
  }

  public void setChildren(Map<Character, TrieNode> children) {
    this.children = children;
  }

  public boolean terminates() {
    return terminates;
  }
}
