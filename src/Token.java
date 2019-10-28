public class Token {
    String data;

    public Token(String data) {
        this.data = data;
    }

    public String evaluate() {
        return this.data;
    }

    public int size() {
        return data.length();
    }

    @Override
    public boolean equals(Object obj) {
        Token other = (Token) obj;
        return this.evaluate().equals(other.evaluate());
    }
}