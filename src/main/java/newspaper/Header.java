package newspaper;

import java.util.Objects;

public class Header {

    private String content;
    private int level;

    public Header(String content, int level) {
        this.content = content;
        this.level = level;
    }

    public String getContent() {
        return content;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Header header = (Header) o;
        return content != null ? content.equals(header.content) : header.content == null;
    }

    @Override
    public int hashCode() {
        return content != null ? content.hashCode() : 0;
    }
}
