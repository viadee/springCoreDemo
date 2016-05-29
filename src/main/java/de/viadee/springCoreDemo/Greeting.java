package de.viadee.springCoreDemo;

/**
 * A trivial class the represents the greeting of a user.
 */
public class Greeting {

    /**
     * A unique identifier of each instance, counted up from one.
     */
    private final long id;

    /**
     * Textual content, i.e. the greeting message itself.
     */
    private final String content;

    public Greeting(final long id, final String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}