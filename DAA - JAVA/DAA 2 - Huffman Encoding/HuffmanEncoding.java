import java.util.*;

class HuffmanNode implements Comparable<HuffmanNode> {
    char character;
    int frequency;
    HuffmanNode left, right;

    public HuffmanNode(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;
    }

    @Override
    public int compareTo(HuffmanNode other) {
        return this.frequency - other.frequency;
    }
}

public class HuffmanEncoding {
    public static Map<Character, String> buildHuffmanCodes(String text) {
        Map<Character, String> huffmanCodes = new HashMap<>();
        PriorityQueue<HuffmanNode> minHeap = new PriorityQueue<>();

        // Calculate character frequencies
        Map<Character, Integer> frequencies = new HashMap<>();
        for (char c : text.toCharArray()) {
            frequencies.put(c, frequencies.getOrDefault(c, 0) + 1);
        }

        // Create leaf nodes and add them to the min-heap
        frequencies.forEach((character, frequency) -> minHeap.add(new HuffmanNode(character, frequency)));

        // Build the Huffman tree
        while (minHeap.size() > 1) {
            HuffmanNode left = minHeap.poll();
            HuffmanNode right = minHeap.poll();
            HuffmanNode combined = new HuffmanNode('\0', left.frequency + right.frequency);
            combined.left = left;
            combined.right = right;
            minHeap.add(combined);
        }

        // Generate Huffman codes
        generateHuffmanCodes(minHeap.poll(), "", huffmanCodes);
        return huffmanCodes;
    }

    private static void generateHuffmanCodes(HuffmanNode node, String code, Map<Character, String> huffmanCodes) {
        if (node == null) return;
        if (node.character != '\0') huffmanCodes.put(node.character, code);
        generateHuffmanCodes(node.left, code + "0", huffmanCodes);
        generateHuffmanCodes(node.right, code + "1", huffmanCodes);
    }

    public static void main(String[] args) {
        String text = "this is an example for huffman encoding";
        Map<Character, String> huffmanCodes = buildHuffmanCodes(text);

        huffmanCodes.forEach((character, code) -> System.out.println(character + ": " + code));
    }
}
