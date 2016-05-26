/**
 * 
 */
package de.viadee.springCoreDemo.dependencies;

public class AnsweringService {

    private final Brain brain;

    public AnsweringService(final Brain brain) {
        super();
        this.brain = brain;
    }

    public String answerQuestion(final String question) {
        return this.brain.thinkAbout(question);
    }

    public Object getBrain() {
        return brain;
    }

}
