/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author bilal
 */
public class Question {
    private Founder evaluator;
    private String question;
    
    Question(Founder evaluator, String question){
        this.evaluator=evaluator;
        this.question=question;
    }
}
